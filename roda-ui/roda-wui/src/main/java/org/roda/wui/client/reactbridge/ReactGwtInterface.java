package org.roda.wui.client.reactbridge;

import com.google.gwt.dom.client.Element;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name="GwtInterface")
abstract public class ReactGwtInterface {
  @JsMethod
  public native void mount(Element root);

  @JsMethod
  public native void unmount();
}
