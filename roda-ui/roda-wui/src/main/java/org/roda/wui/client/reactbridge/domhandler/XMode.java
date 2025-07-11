package org.roda.wui.client.reactbridge.domhandler;

public enum XMode {
  NoQuirks("no-quirks"),
  Quirks("quirks"),
  LimitedQuirks("limited-quirks");


  public final String xmode;

  private XMode(String xmode) {
    this.xmode = xmode;
  }
}
