package org.roda.wui.client.reactbridge.domhandler;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class SourceCodeLocation {
  /** One-based line index of the first character. */
  public int startLine;
  /** One-based column index of the first character. */
  public int startCol;
  /** Zero-based first character index. */
  public int startOffset;
  /** One-based line index of the last character. */
  public int endLine;
  /** One-based column index of the last character. Points directly *after* the last character. */
  public int endCol;
  /** Zero-based last character index. Points directly *after* the last character. */
  public int endOffset;
}
