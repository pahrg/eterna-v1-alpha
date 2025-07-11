package org.roda.wui.client.reactbridge.reactdom;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class React {
  /**
   * React is a static class.
   */
  private React() {
  }

  public static native <P> ReactElement<P> createElement(String type, P props);
  public static native <P> ReactElement<P> createElement(String type, P props, String value);
  public static native <P> ReactElement<P> createElement(String type, P props, ReactNode ...children);
  public static native <P> ReactElement<P> createElement(String type, P props, ReactNode child, String value);

  // function createElement<P extends {}>(type: FunctionComponent<P>, props?: Attributes & P | null, ...children: ReactNode[]): FunctionComponentElement<P>;
  public static native <P> ReactElement<P> createElement(FunctionComponent<P> type);
  public static native <P> ReactElement<P> createElement(FunctionComponent<P> type, P props);
  public static native <P> ReactElement<P> createElement(FunctionComponent<P> type, P props, ReactNode ...children);

  // function createElement<P extends {}, T extends Component<P, ComponentState>, C extends ComponentClass<P>>(type: ClassType<P, T, C>, props?: ClassAttributes<T> & P | null, ...children: ReactNode[]): CElement<P, T>;

  // function createElement<P extends {}>(type: FunctionComponent<P> | ComponentClass<P> | string, props?: Attributes & P | null, ...children: ReactNode[]): ReactElement<P>;

}
