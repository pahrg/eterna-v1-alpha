package org.roda.wui.client.reactbridge.htmlreactparser;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.roda.wui.client.reactbridge.reactdom.JSX;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "?")
public interface LibraryOptions {
  JSX.Element cloneElement(JSX.Element element);
  JSX.Element cloneElement(JSX.Element element, Object props);
  JSX.Element cloneElement(JSX.Element element, Object props, Object ...children);

  JSX.Element createElement(Object type);
  JSX.Element createElement(Object type, Object props);
  JSX.Element createElement(Object element, Object props, Object ...children);

  boolean isValidElement(Object element);
}
