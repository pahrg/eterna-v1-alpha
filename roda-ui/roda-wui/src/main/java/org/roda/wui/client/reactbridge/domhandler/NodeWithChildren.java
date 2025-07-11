package org.roda.wui.client.reactbridge.domhandler;

import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * A node that can have children.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class NodeWithChildren extends Node {
  /** First child of the node. */
  @JsNullable
  public ChildNode firstChild;

  /** Last child of the node. */
  @JsNullable
  public ChildNode lastChild;

  /**
   * Same as {@link children}.
   * <a href="https://dom.spec.whatwg.org">DOM spec</a>-compatible alias.
   */
  @JsNullable
  public ChildNode[] childNodes;
}
