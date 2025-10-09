// vite.config.ts
import { fileURLToPath, URL } from "node:url";
import { defineConfig } from "file:///Users/h.a.hu/accenture/learn_space/learn-ai/project-integration/commerce-intelligent-customer-service/frontend/node_modules/vite/dist/node/index.js";
import vue from "file:///Users/h.a.hu/accenture/learn_space/learn-ai/project-integration/commerce-intelligent-customer-service/frontend/node_modules/@vitejs/plugin-vue/dist/index.mjs";
import vueJsx from "file:///Users/h.a.hu/accenture/learn_space/learn-ai/project-integration/commerce-intelligent-customer-service/frontend/node_modules/@vitejs/plugin-vue-jsx/dist/index.mjs";
var __vite_injected_original_import_meta_url = "file:///Users/h.a.hu/accenture/learn_space/learn-ai/project-integration/commerce-intelligent-customer-service/frontend/vite.config.ts";
var vite_config_default = defineConfig({
  base: "/",
  build: {
    outDir: "./dist"
  },
  server: {
    proxy: {
      "/api": {
        target: "http://127.0.0.1:8888",
        // 改为 8888 端口
        changeOrigin: true
      }
    }
  },
  plugins: [
    vue(),
    vueJsx()
  ],
  resolve: {
    alias: {
      "@": fileURLToPath(new URL("./src", __vite_injected_original_import_meta_url)),
      "monaco-editor": "monaco-editor/esm/vs/editor/editor.api.js"
    },
    // ignore suffix
    extensions: [".mjs", ".js", ".ts", ".jsx", ".tsx", ".json", ".vue"]
  }
});
export {
  vite_config_default as default
};
//# sourceMappingURL=data:application/json;base64,ewogICJ2ZXJzaW9uIjogMywKICAic291cmNlcyI6IFsidml0ZS5jb25maWcudHMiXSwKICAic291cmNlc0NvbnRlbnQiOiBbImNvbnN0IF9fdml0ZV9pbmplY3RlZF9vcmlnaW5hbF9kaXJuYW1lID0gXCIvVXNlcnMvaC5hLmh1L2FjY2VudHVyZS9sZWFybl9zcGFjZS9sZWFybi1haS9wcm9qZWN0LWludGVncmF0aW9uL2NvbW1lcmNlLWludGVsbGlnZW50LWN1c3RvbWVyLXNlcnZpY2UvZnJvbnRlbmRcIjtjb25zdCBfX3ZpdGVfaW5qZWN0ZWRfb3JpZ2luYWxfZmlsZW5hbWUgPSBcIi9Vc2Vycy9oLmEuaHUvYWNjZW50dXJlL2xlYXJuX3NwYWNlL2xlYXJuLWFpL3Byb2plY3QtaW50ZWdyYXRpb24vY29tbWVyY2UtaW50ZWxsaWdlbnQtY3VzdG9tZXItc2VydmljZS9mcm9udGVuZC92aXRlLmNvbmZpZy50c1wiO2NvbnN0IF9fdml0ZV9pbmplY3RlZF9vcmlnaW5hbF9pbXBvcnRfbWV0YV91cmwgPSBcImZpbGU6Ly8vVXNlcnMvaC5hLmh1L2FjY2VudHVyZS9sZWFybl9zcGFjZS9sZWFybi1haS9wcm9qZWN0LWludGVncmF0aW9uL2NvbW1lcmNlLWludGVsbGlnZW50LWN1c3RvbWVyLXNlcnZpY2UvZnJvbnRlbmQvdml0ZS5jb25maWcudHNcIjtcbmltcG9ydCB7ZmlsZVVSTFRvUGF0aCwgVVJMfSBmcm9tICdub2RlOnVybCdcbmltcG9ydCB7ZGVmaW5lQ29uZmlnfSBmcm9tICd2aXRlJ1xuaW1wb3J0IHZ1ZSBmcm9tICdAdml0ZWpzL3BsdWdpbi12dWUnXG5pbXBvcnQgdnVlSnN4IGZyb20gJ0B2aXRlanMvcGx1Z2luLXZ1ZS1qc3gnXG5cbi8vIGh0dHBzOi8vdml0ZWpzLmRldi9jb25maWcvXG5leHBvcnQgZGVmYXVsdCBkZWZpbmVDb25maWcoe1xuICAgIGJhc2U6ICcvJyxcbiAgICBidWlsZDoge1xuICAgICAgICBvdXREaXI6ICcuL2Rpc3QnLFxuICAgIH0sXG4gICAgc2VydmVyOiB7XG4gICAgICAgIHByb3h5OiB7XG4gICAgICAgICAgICAnL2FwaSc6IHtcbiAgICAgICAgICAgICAgICB0YXJnZXQ6ICdodHRwOi8vMTI3LjAuMC4xOjg4ODgnLCAgLy8gXHU2NTM5XHU0RTNBIDg4ODggXHU3QUVGXHU1M0UzXG4gICAgICAgICAgICAgICAgY2hhbmdlT3JpZ2luOiB0cnVlLFxuICAgICAgICAgICAgfVxuICAgICAgICB9XG4gICAgfSxcbiAgICBwbHVnaW5zOiBbXG4gICAgICAgIHZ1ZSgpLFxuICAgICAgICB2dWVKc3goKSxcbiAgICBdLFxuICAgIHJlc29sdmU6IHtcbiAgICAgICAgYWxpYXM6IHtcbiAgICAgICAgICAgICdAJzogZmlsZVVSTFRvUGF0aChuZXcgVVJMKCcuL3NyYycsIGltcG9ydC5tZXRhLnVybCkpLFxuICAgICAgICAgICAgJ21vbmFjby1lZGl0b3InOiAnbW9uYWNvLWVkaXRvci9lc20vdnMvZWRpdG9yL2VkaXRvci5hcGkuanMnXG4gICAgICAgIH0sXG4gICAgICAgIC8vIGlnbm9yZSBzdWZmaXhcbiAgICAgICAgZXh0ZW5zaW9uczogWycubWpzJywgJy5qcycsICcudHMnLCAnLmpzeCcsICcudHN4JywgJy5qc29uJywgJy52dWUnXVxuICAgIH0sXG5cbn0pXG4iXSwKICAibWFwcGluZ3MiOiAiO0FBQ0EsU0FBUSxlQUFlLFdBQVU7QUFDakMsU0FBUSxvQkFBbUI7QUFDM0IsT0FBTyxTQUFTO0FBQ2hCLE9BQU8sWUFBWTtBQUptVCxJQUFNLDJDQUEyQztBQU92WCxJQUFPLHNCQUFRLGFBQWE7QUFBQSxFQUN4QixNQUFNO0FBQUEsRUFDTixPQUFPO0FBQUEsSUFDSCxRQUFRO0FBQUEsRUFDWjtBQUFBLEVBQ0EsUUFBUTtBQUFBLElBQ0osT0FBTztBQUFBLE1BQ0gsUUFBUTtBQUFBLFFBQ0osUUFBUTtBQUFBO0FBQUEsUUFDUixjQUFjO0FBQUEsTUFDbEI7QUFBQSxJQUNKO0FBQUEsRUFDSjtBQUFBLEVBQ0EsU0FBUztBQUFBLElBQ0wsSUFBSTtBQUFBLElBQ0osT0FBTztBQUFBLEVBQ1g7QUFBQSxFQUNBLFNBQVM7QUFBQSxJQUNMLE9BQU87QUFBQSxNQUNILEtBQUssY0FBYyxJQUFJLElBQUksU0FBUyx3Q0FBZSxDQUFDO0FBQUEsTUFDcEQsaUJBQWlCO0FBQUEsSUFDckI7QUFBQTtBQUFBLElBRUEsWUFBWSxDQUFDLFFBQVEsT0FBTyxPQUFPLFFBQVEsUUFBUSxTQUFTLE1BQU07QUFBQSxFQUN0RTtBQUVKLENBQUM7IiwKICAibmFtZXMiOiBbXQp9Cg==
