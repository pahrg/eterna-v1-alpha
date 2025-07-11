package org.roda.wui.client.reactbridge.reactdom;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import elemental2.dom.DocumentFragment;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "ReactDOM", namespace = JsPackage.GLOBAL)
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

  // GWT Interop
  public static native Root createRoot(Element container);
  public static native Root createRoot(Element container, RootOptions options);

  public static native Root createRoot(Document container);
  public static native Root createRoot(Document container, RootOptions options);

  public static native Root createRoot(DocumentFragment container);
  public static native Root createRoot(DocumentFragment container, RootOptions options);

}
