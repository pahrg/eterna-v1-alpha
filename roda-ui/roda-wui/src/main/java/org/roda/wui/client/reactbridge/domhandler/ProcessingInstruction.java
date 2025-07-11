package org.roda.wui.client.reactbridge.domhandler;

import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Processing instructions, including doc types.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public final class ProcessingInstruction extends DataNode implements ChildNode, DOMNode {
  public int nodeType;

  /** If this is a doctype, the document type name (parse5 only). */
  /*
  @JsNullable
  @JsProperty(name = "x-name")
  public String xName;
   */

  /** If this is a doctype, the document type public identifier (parse5 only). */
  /*
  @JsNullable
  @JsProperty(name = "x-publicId")
  public String xPublicId;
   */

  /** If this is a doctype, the document type system identifier (parse5 only). */
  /*
  @JsNullable
  @JsProperty(name = "x-systemId")
  public String xSystemId;
   */
}
