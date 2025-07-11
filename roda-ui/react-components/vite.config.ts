import path from "node:path";
//import react from "@vitejs/plugin-react-swc";
//import externalize from "vite-plugin-externalize-dependencies";
import pluginExternal from "vite-plugin-external";
import { defineConfig } from "vite";

// https://vite.dev/config/
export default defineConfig(({ mode }) => {
	const isDevMode = mode === "development";

	return {
		plugins: [
			pluginExternal({
				externals(libName) {
					if (
						[
							"react",
							"react-dom",
							"react-dom/client",
							"react/jsx-runtime",
						].includes(libName)
					) {
						return true;
					}
				},
			}),
			/*externalize({
				externals: [
					"react", // Externalize "react", and all of its subexports (react/*), such as react/jsx-runtime
					"react-dom",
					(moduleName) => moduleName.includes("external"), // Externalize all modules containing "external",
				],
			}),*/
		],
		root: !isDevMode ? "." : "demo",
		build: {
			lib: !isDevMode
				? {
						entry: path.resolve(__dirname, "src/main.tsx"),
						name: "react-components.js",
						formats: ["es"],
					}
				: undefined,
		},
		rollupOptions: !isDevMode
			? {
					external: ["react", "react-dom"],
					output: {
						globals: {
							react: "React",
							"react-dom/client": "ReactDOM",
						},
					},
					/*format: "iife",*/
				}
			: undefined,
		define: {
			"process.env.NODE_ENV": JSON.stringify(mode),
		},
	};
});
