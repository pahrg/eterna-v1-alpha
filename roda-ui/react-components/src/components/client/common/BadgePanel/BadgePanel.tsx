import parse from "html-react-parser";
import { useAtomValue } from "jotai";
import { atomWithStore } from "jotai-zustand";
import type { WritableAtom } from "jotai/vanilla/atom";
import type { SetStateAction } from "jotai/vanilla/typeUtils";
import type { ReactNode } from "react";
import { create } from "zustand";
import type { Mutate, StoreApi, StoreMutatorIdentifier } from "zustand/vanilla";
import ReactGwtInterface from "../../../../lib/ReactGwtInterface";

type BadgePanelStateTypes = {
	iconHTML: ReactNode;
	text: string | undefined;
	notification: boolean;
};

type BadgePanelProps = {
	[key in keyof BadgePanelStateTypes]: WritableAtom<
		BadgePanelStateTypes[key],
		[update: SetStateAction<BadgePanelStateTypes[key]>],
		void
	>;
};

type BadgePanelStoresType = {
	[key in keyof BadgePanelStateTypes]: Mutate<
		StoreApi<BadgePanelStateTypes[key]>,
		[StoreMutatorIdentifier, unknown][]
	>;
};

class BadgePanelGwtInterface extends ReactGwtInterface {
	BadgePanelStores: BadgePanelStoresType;

	constructor() {
		super();

		this.BadgePanelStores = {
			iconHTML: create<ReactNode>(() => undefined),
			text: create<string | undefined>(() => undefined),
			notification: create<boolean>(() => false),
		};

		const BadgePanelState = {
			iconHTML: atomWithStore(this.BadgePanelStores.iconHTML),
			text: atomWithStore(this.BadgePanelStores.text),
			notification: atomWithStore(this.BadgePanelStores.notification),
		};

		this.component = <BadgePanel {...BadgePanelState} />;
	}

	setIcon(iconString: string) {
		const reactNode = parse(iconString, {
			replace: (node) => {
				if (node instanceof Element) {
					return node;
				} else {
					const iconClassName =
						iconString.trim().length === 0
							? "fa fa-question-circle"
							: iconString;
					return <i className={iconClassName}></i>;
				}
			},
		});

		this.BadgePanelStores.iconHTML.setState(reactNode);
	}

	setText(text: string) {
		this.BadgePanelStores.text.setState(text);
	}

	enableNotification(value: boolean) {
		this.BadgePanelStores.notification.setState(value);
	}
}

function BadgePanel(BadgePanelState: BadgePanelProps) {
	const iconHTML = useAtomValue(BadgePanelState.iconHTML);
	const text = useAtomValue(BadgePanelState.text);
	const notification = useAtomValue(BadgePanelState.notification);

	return (
		<>
			{iconHTML && <div className="gwt-HTML badge-icon">{iconHTML}</div>}
			<div className="gwt-Label badge-label" title={text}>
				{text}
			</div>
			<div
				className="gwt-HTML badge-notification"
				style={{ display: notification ? "inline" : "none" }}
				aria-hidden={!notification}
			>
				<span className="fa-stack">
					<i className="fas fa-sync-alt fa-stack-1x"></i>
					<i className="fas fa-question fa-stack-1x"></i>
				</span>
			</div>
		</>
	);
}

export { BadgePanel, BadgePanelGwtInterface };
