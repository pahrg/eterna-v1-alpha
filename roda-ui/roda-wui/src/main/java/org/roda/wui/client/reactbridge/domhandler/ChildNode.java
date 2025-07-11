package org.roda.wui.client.reactbridge.domhandler;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/*
 TODO: Switch to sealed interface which supports pattern matching to emulate TS union types:
 public sealed interface ChildNode permits Text, Comment, ProcessingInstruction, Element, CDATA, Document

 Should be possible since GWT 2.12.0 but doesn't seem to work as of 2.12.2
 */

/**
 * A node that can have a parent.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public interface ChildNode {
}