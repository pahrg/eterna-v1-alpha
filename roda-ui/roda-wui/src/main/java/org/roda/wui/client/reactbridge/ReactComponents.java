package org.roda.wui.client.reactbridge;

public class ReactComponents {
  public static native ReactGwtInterface get(String componentName) /*-{
    return $wnd.ReactComponents[componentName];
  }-*/;
}
