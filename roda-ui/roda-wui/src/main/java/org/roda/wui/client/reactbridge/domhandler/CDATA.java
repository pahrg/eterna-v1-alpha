package org.roda.wui.client.reactbridge.domhandler;

import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.roda.wui.client.reactbridge.domelementtype.ElementType;

/**
 * CDATA nodes.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public final class CDATA extends NodeWithChildren implements ParentNode, ChildNode {
  public ElementType type;

  public int nodeType;
}
