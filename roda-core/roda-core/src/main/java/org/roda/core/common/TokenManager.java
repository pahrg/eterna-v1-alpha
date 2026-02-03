/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE file at the root of the source
 * tree and available online at
 *
 * https://github.com/keeps/roda
 */
package org.roda.core.common;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.roda.core.data.common.RodaConstants;
import org.roda.core.data.exceptions.AuthenticationDeniedException;
import org.roda.core.data.exceptions.GenericException;
import org.roda.core.data.exceptions.RODAException;
import org.roda.core.data.utils.JsonUtils;
import org.roda.core.data.v2.accessToken.AccessToken;
import org.roda.core.data.v2.synchronization.local.LocalInstance;

/**
 * @author Gabriel Barros <gbarros@keep.pt>
 */
public class TokenManager {
  private static TokenManager instance;
  private AccessToken currentToken;
  private Date expirationTime;

  private TokenManager() {
    // do nothing
  }

  public static TokenManager getInstance() {
    if (instance == null) {
      instance = new TokenManager();
    }
    return instance;
  }

  public AccessToken getAccessToken(LocalInstance localInstance)
    throws AuthenticationDeniedException, GenericException {
    try {
      if (currentToken != null) {
        if (!tokenExpired()) {
          return currentToken;
        }
      }
      currentToken = grantToken(localInstance);
      setExpirationTime();
      return currentToken;
    } catch (RODAException e) {
      currentToken = null;
      throw e;
    }
  }

  public AccessToken grantToken(LocalInstance localInstance) throws GenericException, AuthenticationDeniedException {
    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    String baseUrl;
    try {
      baseUrl = validateCentralInstanceUrl(localInstance.getCentralInstanceURL());
    } catch (URISyntaxException | UnknownHostException e) {
      throw new GenericException("Invalid central instance URL configuration", e);
    }
    String url = baseUrl + RodaConstants.API_SEP + RodaConstants.API_REST_V1_AUTH
      + RodaConstants.API_PATH_PARAM_AUTH_TOKEN;
    HttpPost httpPost = new HttpPost(url);
    httpPost.addHeader("content-type", "application/json");

    try {
      httpPost.setEntity(new StringEntity(JsonUtils.getJsonFromObject(localInstance.getAccessKey())));
      HttpResponse response = httpClient.execute(httpPost);
      HttpEntity responseEntity = response.getEntity();
      int responseStatusCode = response.getStatusLine().getStatusCode();

      if (responseStatusCode == 200) {
        return JsonUtils.getObjectFromJson(responseEntity.getContent(), AccessToken.class);
      } else if (responseStatusCode == 401) {
        throw new AuthenticationDeniedException("Cannot authenticate on central instance with current configuration");
      } else {
        throw new GenericException("url: " + url + ", response code; " + responseStatusCode);
      }
    } catch (IOException e) {
      throw new GenericException("Error sending POST request", e);
    }
  }

  /**
   * Validates the central instance base URL to reduce the risk of SSRF.
   *
   * @param centralInstanceUrl the configured central instance URL
   * @return a normalized base URL string without a trailing slash
   * @throws URISyntaxException     if the URL is not a valid URI
   * @throws UnknownHostException   if the host cannot be resolved
   * @throws GenericException       if the URL is otherwise invalid
   */
  private String validateCentralInstanceUrl(String centralInstanceUrl)
    throws URISyntaxException, UnknownHostException, GenericException {
    if (centralInstanceUrl == null || centralInstanceUrl.trim().isEmpty()) {
      throw new GenericException("Central instance URL is not configured");
    }

    URI uri = new URI(centralInstanceUrl.trim());

    String scheme = uri.getScheme();
    if (scheme == null || (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme))) {
      throw new GenericException("Central instance URL must use HTTP or HTTPS");
    }

    String host = uri.getHost();
    if (host == null || host.isEmpty()) {
      throw new GenericException("Central instance URL must include a valid host");
    }

    InetAddress address = InetAddress.getByName(host);
    if (address.isLoopbackAddress() || address.isAnyLocalAddress() || address.isLinkLocalAddress()) {
      throw new GenericException("Central instance URL cannot point to a local or loopback address");
    }

    // Normalize: remove trailing slash from the original string representation
    String normalized = centralInstanceUrl.trim();
    if (normalized.endsWith("/")) {
      normalized = normalized.substring(0, normalized.length() - 1);
    }
    return normalized;
  }

  private void setExpirationTime() {
    long today = new Date().getTime();
    expirationTime = new Date(today + currentToken.getExpiresIn());
  }

  private boolean tokenExpired() {
    return new Date().after(expirationTime);
  }

  public void removeToken() {
    this.currentToken = null;
  }
}
