package org.roda.wui.client.reactbridge;

import org.roda.wui.client.reactbridge.reactdom.FunctionComponent;

public class ReactComponents {
  public static native <T> FunctionComponent<T> get(String componentName) /*-{
    return $wnd.ReactComponents[componentName];
  }-*/;
}
