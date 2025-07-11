package org.roda.wui.client.reactbridge.reactdom;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

public class JSX {
  @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
  public static class Element {
    public Object type;
    public Object props;
    public String key;
  }
}
