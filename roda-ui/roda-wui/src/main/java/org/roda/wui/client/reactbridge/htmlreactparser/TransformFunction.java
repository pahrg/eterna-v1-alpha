package org.roda.wui.client.reactbridge.htmlreactparser;

import jsinterop.annotations.JsFunction;
import org.roda.wui.client.reactbridge.domhandler.DOMNode;
import org.roda.wui.client.reactbridge.reactdom.JSX;
import org.roda.wui.client.reactbridge.reactdom.ReactNode;

@JsFunction
public interface TransformFunction {
  <T> T transform(ReactNode reactNode, DOMNode domNode, int index);
}