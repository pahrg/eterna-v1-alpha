package org.roda.wui.client.reactbridge.htmlreactparser;

import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ParserOptions {
  /**
   * Indicates whether special tags (`<script>`, `<style>`, and `<title>`) should get special treatment
   * and if "empty" tags (eg. `<br>`) can have children.  If `false`, the content of special tags
   * will be text only. For feeds and other XML content (documents that don't consist of HTML),
   * set this to `true`.
   *
   * @default false
   */
  @JsNullable
  public Boolean xmlMode;

  /**
   * Decode entities within the document.
   *
   * @default true
   */
  @JsNullable
  public Boolean decodeEntities;

  /**
   * If set to true, all tags will be lowercased.
   *
   * @default !xmlMode
   */
  @JsNullable
  public Boolean lowerCaseTags;

  /**
   * If set to `true`, all attribute names will be lowercased. This has noticeable impact on speed.
   *
   * @default !xmlMode
   */
  @JsNullable
  public Boolean lowerCaseAttributeNames;

  /**
   * If set to true, CDATA sections will be recognized as text even if the xmlMode option is not enabled.
   * NOTE: If xmlMode is set to `true` then CDATA sections will always be recognized as text.
   *
   * @default xmlMode
   */
  @JsNullable
  public Boolean recognizeCDATA;

  /**
   * If set to `true`, self-closing tags will trigger the onclosetag event even if xmlMode is not set to `true`.
   * NOTE: If xmlMode is set to `true` then self-closing tags will always be recognized.
   *
   * @default xmlMode
   */
  @JsNullable
  public Boolean recognizeSelfClosing;

  /**
   * Allows the default tokenizer to be overwritten.
   */
  public org.roda.wui.client.reactbridge.htmlparser2.Tokenizer Tokenizer;

  /**
   * Add a `startIndex` property to nodes.
   * When the parser is used in a non-streaming fashion, `startIndex` is an integer
   * indicating the position of the start of the node in the document.
   *
   * @default false
   */
  @JsNullable
  public Boolean withStartIndices;

  /**
   * Add an `endIndex` property to nodes.
   * When the parser is used in a non-streaming fashion, `endIndex` is an integer
   * indicating the position of the end of the node in the document.
   *
   * @default false
   */
  @JsNullable
  public Boolean withEndIndices;
}
