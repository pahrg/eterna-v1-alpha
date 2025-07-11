package org.roda.wui.client.reactbridge.domhandler;

import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * The description of an individual attribute.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class Attribute {
  @JsNonNull
  public String name;

  @JsNonNull
  public String value;

  @JsNullable
  public String namespace;

  @JsNullable
  public String prefix;
}
