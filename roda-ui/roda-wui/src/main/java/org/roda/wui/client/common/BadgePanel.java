/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE file at the root of the source
 * tree and available online at
 *
 * https://github.com/keeps/roda
 */
package org.roda.wui.client.common;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.FlowPanel;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.roda.core.data.common.RodaConstants;
import org.roda.wui.client.reactbridge.ReactComponents;
import org.roda.wui.client.reactbridge.domhandler.Element;
import org.roda.wui.client.reactbridge.htmlreactparser.HTMLReactParser;
import org.roda.wui.client.reactbridge.htmlreactparser.HTMLReactParserOptions;
import org.roda.wui.client.reactbridge.reactdom.React;
import org.roda.wui.client.reactbridge.reactdom.ReactDOMClient;
import org.roda.wui.client.reactbridge.reactdom.ReactNode;
import org.roda.wui.client.reactbridge.reactdom.Root;
import org.roda.wui.common.client.tools.ConfigurationManager;
import org.roda.wui.common.client.tools.StringUtils;

import java.util.Objects;

/**
 * @author Gabriel Barros <gbarros@keep.pt>
 */
public class BadgePanel extends FlowPanel {
  BadgePanelProps props = new BadgePanelProps();
  Root reactRoot;

  public BadgePanel() {
    super();
    this.addStyleName("badge-panel");
    this.reactRoot = ReactDOMClient.createRoot(this.getElement());
  }

  @Override
  public void onAttach() {
    super.onAttach();
    this.reactRoot.render(React.createElement(ReactComponents.get("BadgePanel"), props));
  }

  @Override
  public void onDetach() {
    this.reactRoot.unmount();
    super.onDetach();
  }

  // Get icon class name from roda-wui.properties, eg: ui.icons.class.IndexedAIP = far fa-circle
  // Not used....
  public void setIconClass(String classSimpleName) {
    setIcon(ConfigurationManager.getString(RodaConstants.UI_ICONS_CLASS, classSimpleName));
  }

  // Set className with arbitrary name
  public void setIcon(String iconCss) {
    // set default if empty
    if (StringUtils.isBlank(iconCss)) {
      iconCss = "fa fa-question-circle";
    }

    setIcon(SafeHtmlUtils.fromSafeConstant("<i class=\"" + iconCss + "\"></i>"));
  }

  public void setIcon(SafeHtml iconSafeHtml) {
    HTMLReactParserOptions htmlReactParserOptions = new HTMLReactParserOptions();
    htmlReactParserOptions.replace = (node, index) -> {
      if (Objects.requireNonNull(node) instanceof Element) {
        return Js.uncheckedCast(node);
      }
      String iconString = iconSafeHtml.asString();
      String iconClassName = iconString.trim().isEmpty() ? "fa fa-question-circle" : iconString;
      return React.createElement("i", JsPropertyMap.of("className", iconClassName));
    };

    props.icon = HTMLReactParser.parse(iconSafeHtml.asString(), htmlReactParserOptions);
    this.reactRoot.render(React.createElement(ReactComponents.get("BadgePanel"), props));
  }

  public void setText(String text) {
    props.text = text;
    this.reactRoot.render(React.createElement(ReactComponents.get("BadgePanel"), props));
  }

  public void enableNotification(boolean value) {
    props.notification = value;
    this.reactRoot.render(React.createElement(ReactComponents.get("BadgePanel"), props));
  }

  @Override
  public void addStyleName(String style) {
    super.addStyleName(style);
  }

  @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
  public static class BadgePanelProps {
    ReactNode icon;

    String text;

    boolean notification;
  }
}
