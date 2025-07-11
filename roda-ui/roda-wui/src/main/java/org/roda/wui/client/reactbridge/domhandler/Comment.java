package org.roda.wui.client.reactbridge.domhandler;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.roda.wui.client.reactbridge.domelementtype.ElementType;

/**
 * Comments within the document.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public final class Comment extends DataNode implements ChildNode, ParentNode, DOMNode {
  public ElementType type;

  public int nodeType;
}