package org.roda.wui.client.reactbridge;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "ReactComponents", namespace = JsPackage.GLOBAL)
public interface ReactComponentMap extends JsPropertyMap<ReactGwtComponent<?>> {
}
