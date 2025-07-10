package org.roda.wui.client.reactbridge.reactdom;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public interface Root {
  void render(ReactNode children);
  void unmount();
}
