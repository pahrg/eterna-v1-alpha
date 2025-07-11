package org.roda.wui.client.reactbridge.domhandler;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/*
 TODO: Switch to sealed interface which supports pattern matching to emulate TS union types:
 public sealed interface ParentNode permits CDATA, Comment, Document, Element

 Should be possible since GWT 2.12.0 but doesn't seem to work as of 2.12.2
 */

/**
 * A node that can have children.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "?")
public interface ParentNode {
}
