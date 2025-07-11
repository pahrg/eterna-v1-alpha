package org.roda.wui.client.reactbridge.domhandler;

import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.roda.wui.client.reactbridge.domelementtype.ElementType;

/**
 * This object will be used as the prototype for Nodes when creating a
 * DOM-Level-1-compliant structure.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class Node {
  /** The type of the node. */
  public ElementType type;

  /** Parent of the node */
  @JsNullable
  public ParentNode parent;

  /** Previous sibling */
  @JsNullable
  public ChildNode prev;

  /** Next sibling */
  @JsNullable
  public ChildNode next;

  /** The start index of the node. Requires `withStartIndices` on the handler to be `true. */
  @JsNullable
  public int startIndex;

  /** The end index of the node. Requires `withEndIndices` on the handler to be `true. */
  @JsNullable
  public int endIndex;

  /**
   * `parse5` source code location info.
   *
   * Available if parsing with parse5 and location info is enabled.
   */
  @JsNullable
  public SourceCodeLocation sourceCodeLocation;

  /**
   * <a href="https://dom.spec.whatwg.org/#dom-node-nodetype">DOM spec</a>-compatible
   * node {@link type}.
   */
  public int nodeType;

  /**
   * Same as {@link parent}.
   * <a href="https://dom.spec.whatwg.org/#dom-node-nodetype">DOM spec</a>-compatible alias.
   */
  @JsNullable
  public ParentNode parentNode;

  /**
   * Same as {@link prev}.
   * <a href="https://dom.spec.whatwg.org/#dom-node-nodetype">DOM spec</a>-compatible alias.
   */
  @JsNullable
  public ChildNode previousSibling;

  /**
   * Same as {@link next}.
   * <a href="https://dom.spec.whatwg.org/#dom-node-nodetype">DOM spec</a>-compatible alias.
   */
  @JsNullable
  public ChildNode nextSibling;

  /**
   * Clone this node
   *
   * @returns A clone of the node.
   */
  public native <T extends Node> T cloneNode(T thisNode);

  /**
   * Clone this node, and optionally its children.
   *
   * @param recursive Clone child nodes as well.
   * @returns A clone of the node.
   */
  public native <T extends Node> T cloneNode(T thisNode, boolean recursive);
}
