import type { ComponentClass, FunctionComponent } from "react";
import * as Components from "./components";
import type ReactGwtInterface from "./lib/ReactGwtInterface";

declare global {
	interface Window {
		ReactComponents: {
			[key: string]: FunctionComponent<never> | ComponentClass<never>;
		};
		ReactGwtInterfaces: {
			[key: string]: typeof ReactGwtInterface;
		};
	}
}

window.ReactComponents = {};
window.ReactGwtInterfaces = {};

console.log("before 2");
window.ReactComponents.BadgePanel = Components.BadgePanel;
console.log("after");
