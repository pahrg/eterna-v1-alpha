package org.roda.wui.client.reactbridge.domhandler;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * A node that contains some data.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class DataNode {
  /**
   * Same as {@link data}.
   * <a href="https://dom.spec.whatwg.org">DOM spec</a>-compatible alias.
   */
  public String nodeValue;
}
