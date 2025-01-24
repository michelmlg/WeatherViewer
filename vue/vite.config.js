import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  server: {
    watch: {
      usePolling: true, // Permite o uso de polling para sistemas de arquivos, útil em Docker.
    },
    host: '0.0.0.0', // Torna o servidor acessível externamente.
    strictPort: true, // Garante que o servidor usará exatamente a porta definida.
    port: 5173, // Porta para o servidor de desenvolvimento.
    proxy: {
      '/api': {
        target: 'http://host.docker.internal:8089', // Altere para o endereço do backend.
        changeOrigin: true, // Ajusta o cabeçalho `Origin` da requisição para o backend.
        secure: false, // Desativa a verificação SSL no ambiente de desenvolvimento.
        rewrite: (path) => path.replace(/^\/api/, ''), // Remove o prefixo `/api` ao redirecionar para o backend.
      },
    },
  },
  hmr: true,
})

// import { defineConfig } from 'vite'
// import vue from '@vitejs/plugin-vue'

// // https://vitejs.dev/config/
// export default defineConfig({
//   plugins: [vue()],
//   server: {
//     watch: {
//       usePolling: true,
//     },
//     host: '0.0.0.0',
//     strictPort: true,
//     port: 5173, 
//   },
//   hmr: true,
// })