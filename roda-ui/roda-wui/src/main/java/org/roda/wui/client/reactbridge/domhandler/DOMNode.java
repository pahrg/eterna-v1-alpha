package org.roda.wui.client.reactbridge.domhandler;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/*
 TODO: Switch to sealed interface which supports pattern matching to emulate TS union types:
 public sealed interface DOMNode permits Comment, Element, ProcessingInstruction, Text

 Should be possible since GWT 2.12.0 but doesn't seem to work as of 2.12.2
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "?")
public interface DOMNode {
}
