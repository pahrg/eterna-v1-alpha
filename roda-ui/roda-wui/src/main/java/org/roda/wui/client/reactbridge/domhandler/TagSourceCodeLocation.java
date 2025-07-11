package org.roda.wui.client.reactbridge.domhandler;

import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TagSourceCodeLocation extends SourceCodeLocation {
  @JsNullable
  public SourceCodeLocation startTag;

  @JsNullable
  public SourceCodeLocation endTag;
}
