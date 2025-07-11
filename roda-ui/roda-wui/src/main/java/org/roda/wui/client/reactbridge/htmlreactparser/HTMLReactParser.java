package org.roda.wui.client.reactbridge.htmlreactparser;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import org.roda.wui.client.reactbridge.reactdom.ReactElement;

public class HTMLReactParser {
  @JsMethod(name = "HTMLReactParser", namespace = JsPackage.GLOBAL)
  public static native ReactElement<?> parse(String html);

  @JsMethod(name = "HTMLReactParser", namespace = JsPackage.GLOBAL)
  public static native ReactElement<?> parse(String html, HTMLReactParserOptions options);
}
