import type { ReactNode } from "react";

type BadgePanelProps = {
	icon: ReactNode;
	text: string | undefined;
	notification: boolean;
};

function BadgePanel({ icon, text, notification }: BadgePanelProps) {
	return (
		<>
			{icon && <div className="gwt-HTML badge-icon">{icon}</div>}
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

export { BadgePanel };
