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

window.ReactComponents = Components;
