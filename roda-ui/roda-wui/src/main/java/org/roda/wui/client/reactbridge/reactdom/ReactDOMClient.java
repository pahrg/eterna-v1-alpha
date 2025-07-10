package org.roda.wui.client.reactbridge.reactdom;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class ReactDOMClient {
  /**
   * ReactDOMClient is a static class.
   */
  private ReactDOMClient() {
  }

  /**
   * createRoot lets you create a root to display React components inside a browser DOM node.
   *
   * @see {@link <a href="https://react.dev/reference/react-dom/client/createRoot">API Reference for `createRoot`</a>}
   */
  public static native Root createRoot(Container container);
  public static native Root createRoot(Container container, RootOptions options);

}
