import type { ReactNode } from "react";
import React from "react";
import { createRoot, type Root } from "react-dom/client";

class ReactGwtInterface {
	private root: Root | undefined;
	protected component: ReactNode;

	mount(rootElement: HTMLElement) {
		this.root = createRoot(rootElement);
		this.root.render(<React.StrictMode>{this.component}</React.StrictMode>);
	}

	unmount() {
		this.root?.unmount();
	}
}

export default ReactGwtInterface;

