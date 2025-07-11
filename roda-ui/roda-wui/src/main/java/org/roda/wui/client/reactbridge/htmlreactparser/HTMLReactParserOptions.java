package org.roda.wui.client.reactbridge.htmlreactparser;

import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsOptional;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.apache.xpath.operations.Bool;
import org.roda.wui.client.reactbridge.domhandler.DOMNode;
import org.roda.wui.client.reactbridge.reactdom.JSX;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class HTMLReactParserOptions {
  @JsNullable
  public ParserOptions htmlparser2;

  @JsNullable
  public LibraryOptions libraryOptions;

  @JsNullable
  public ReplaceFunction replace;

  @JsNullable
  public TransformFunction tranform;

  @JsNullable
  public Boolean trim;
}
