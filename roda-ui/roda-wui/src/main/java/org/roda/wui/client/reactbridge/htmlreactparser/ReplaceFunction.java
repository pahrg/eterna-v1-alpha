package org.roda.wui.client.reactbridge.htmlreactparser;

import jsinterop.annotations.JsFunction;
import org.roda.wui.client.reactbridge.domhandler.DOMNode;
import org.roda.wui.client.reactbridge.reactdom.JSX;

@JsFunction
public interface ReplaceFunction {
  JSX.Element replace(DOMNode domNode, int index);
}
