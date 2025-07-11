package org.roda.wui.client.reactbridge.domelementtype;

/** Types of elements found in htmlparser2's DOM */
public enum ElementType {
  /** Type for the root element of a document */
  Root("root"),
  /** Type for Text */
  Text("text"),
  /** Type for <? ... ?> */
  Directive("directive"),
  /** Type for <!-- ... --> */
  Comment("comment"),
  /** Type for <script> tags */
  Script("script"),
  /** Type for <style> tags */
  Style("style"),
  /** Type for Any tag */
  Tag("tag"),
  /** Type for <![CDATA[ ... ]]> */
  CDATA("cdata"),
  /** Type for <!doctype ...> */
  Doctype("doctype");

  public final String type;

  private ElementType(String type) {
    this.type = type;
  }
}
