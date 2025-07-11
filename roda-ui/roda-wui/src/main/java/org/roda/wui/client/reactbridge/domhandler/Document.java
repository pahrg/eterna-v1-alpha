package org.roda.wui.client.reactbridge.domhandler;

import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.roda.wui.client.reactbridge.domelementtype.ElementType;

/**
 * The root node of the document.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public final class Document extends NodeWithChildren implements ParentNode, ChildNode {
  public ElementType type;

  public int nodeType;

  /** <a href="https://dom.spec.whatwg.org/#concept-document-limited-quirks">Document mode</a> (parse5 only). */
  /*
  @JsNullable
  @JsProperty(name = "x-mode")
  public XMode xMode;
   */
}
