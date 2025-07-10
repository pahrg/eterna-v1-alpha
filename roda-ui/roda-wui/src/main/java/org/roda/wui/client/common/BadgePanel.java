/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE file at the root of the source
 * tree and available online at
 *
 * https://github.com/keeps/roda
 */
package org.roda.wui.client.common;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.FlowPanel;
import jsinterop.annotations.JsType;
import org.roda.wui.client.reactbridge.ReactGwtInterface;

import java.util.List;

/**
 * @author Gabriel Barros <gbarros@keep.pt>
 */
public class BadgePanel extends FlowPanel {
  @JsType(isNative = true, name="BadgePanel", namespace = "ReactGwtInterfaces")
  public static class BadgePanelReactInterface extends ReactGwtInterface {
    public native void setIcon(String iconString);

    public native void setText(String text);

    public native void enableNotification(boolean value);
  }

  private final BadgePanelReactInterface badgePanelReactComponent = new BadgePanelReactInterface();

  public static native void consoleLog(String text) /*-{
    console.log(text);
  }-*/;

  public static native void consoleLog(Element el) /*-{
    console.log(el);
  }-*/;

  public static native void consoleLog(List<String> obj) /*-{
    console.log(obj);
  }-*/;

  public static native void consoleLog(JavaScriptObject obj) /*-{
    console.log(obj);
  }-*/;

  public BadgePanel() {
    super();
    this.addStyleName("badge-panel");
  }

  @Override
  public void onAttach() {
    BadgePanel.consoleLog("onAttach");
    BadgePanel.consoleLog(this.getElement());
    super.onAttach();
    badgePanelReactComponent.mount(this.getElement());
  }

  @Override
  public void onDetach() {
    BadgePanel.consoleLog("onDetach");
    badgePanelReactComponent.unmount();
    super.onDetach();
  }

  public void setIconClass(String classSimpleName) {
    badgePanelReactComponent.setIcon(classSimpleName);
  }

  public void setIcon(String iconCss) {
    badgePanelReactComponent.setIcon(iconCss);
  }

  public void setIcon(SafeHtml iconSafeHtml) {
    badgePanelReactComponent.setIcon(iconSafeHtml.asString());
  }

  public void setText(String text) {
    BadgePanel.consoleLog("setText");
    BadgePanel.consoleLog("text");
    badgePanelReactComponent.setText(text);
  }

  @Override
  public void addStyleName(String style) {
    super.addStyleName(style);
  }

  public void enableNotification(boolean value){
    badgePanelReactComponent.enableNotification(value);
  }
}
