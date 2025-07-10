package org.roda.wui.client.reactbridge;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsProperty;
import org.roda.wui.client.reactbridge.reactdom.FunctionComponent;
import org.roda.wui.client.reactbridge.reactdom.ReactNode;

@JsFunction
public class ReactGwtComponent<P> implements FunctionComponent<P> {
  @Override
  public native ReactNode create(P props);

  @JsProperty
  public ReactGwtInterface gwtInterface;
}
