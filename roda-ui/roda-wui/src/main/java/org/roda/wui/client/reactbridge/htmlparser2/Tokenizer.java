package org.roda.wui.client.reactbridge.htmlparser2;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "?")
public interface Tokenizer {
  void reset();
  void write(String chunk);
  void end();
  void pause();
  void resume();
}
