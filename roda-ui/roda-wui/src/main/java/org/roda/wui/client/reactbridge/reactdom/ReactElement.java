package org.roda.wui.client.reactbridge.reactdom;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Represents a JSX element.
 *
 * Where {@link ReactNode} represents everything that can be rendered, `ReactElement`
 * only represents JSX.
 *
 * @template P The type of the props object
 * @template T The type of the component or tag
 *
 * @example
 *
 * ```tsx
 * const element: ReactElement = <div />;
 * ```
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ReactElement<P> extends JSX.Element implements ReactNode {
  public Object type;
  public P props;
  public String key;
}
