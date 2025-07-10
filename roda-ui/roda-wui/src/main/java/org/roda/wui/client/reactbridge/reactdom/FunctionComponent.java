package org.roda.wui.client.reactbridge.reactdom;

import jsinterop.annotations.JsFunction;

/**
 * Represents the type of a function component. Can optionally
 * receive a type argument that represents the props the component
 * accepts.
 *
 * @template P The props the component accepts.
 * @see {@link <a href="https://react-typescript-cheatsheet.netlify.app/docs/basic/getting-started/function_components">React TypeScript Cheatsheet</a>}
 *
 * @example
 *
 * ```tsx
 * // With props:
 * type Props = { name: string }
 *
 * const MyComponent: FunctionComponent<Props> = (props) => {
 *  return <div>{props.name}</div>
 * }
 * ```
 *
 * @example
 *
 * ```tsx
 * // Without props:
 * const MyComponentWithoutProps: FunctionComponent = () => {
 *   return <div>MyComponentWithoutProps</div>
 * }
 * ```
 */
@JsFunction
public interface FunctionComponent<P> {
  ReactNode create(P props);
}
