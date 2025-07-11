import type { ComponentClass, FunctionComponent } from "react";
import * as Components from "../src/components";
import type ReactGwtInterface from "../src/lib/ReactGwtInterface";

declare global {
	interface Window {
		ReactComponents: {
			[key: string]: FunctionComponent<unknown> | ComponentClass<unknown>;
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
//window.ReactGwtInterfaces.BadgePanel = Components.BadgePanelGwtInterface;
console.log("after");
