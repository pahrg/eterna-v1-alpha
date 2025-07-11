package org.roda.wui.client.reactbridge.domhandler;

import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * An element within the DOM.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public final class Element extends NodeWithChildren implements ParentNode, ChildNode, DOMNode {
  public int nodeType;

  /**
   * `parse5` source code location info, with start & end tags.
   * <p>
   * Available if parsing with parse5 and location info is enabled.
   */
  @JsNullable
  public TagSourceCodeLocation sourceCodeLocation;

  /**
   * Same as {@link name}.
   * <a href="https://dom.spec.whatwg.org">DOM spec</a>-compatible alias.
   */
  public String tagName;

  public Attribute[] attributes;

  /**
   * Element namespace (parse5 only).
   */
  @JsNullable
  public String namespace;

  /** Element attribute namespaces (parse5 only). */
  /*
  @JsNullable
  @JsProperty(name = "x-attribsNamespace")
  public JsPropertyMap<String> xAttribsNamespace;
  */

  /** Element attribute namespace-related prefixes (parse5 only). */
  /*
  @JsNullable
  @JsProperty(name = "x-attribsPrefix")
  public JsPropertyMap<String> xAttribsPrefix;
  */
}
