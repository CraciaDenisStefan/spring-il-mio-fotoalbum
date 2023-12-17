import { createApp } from 'vue'
import './style.css'
import "bootstrap/dist/js/bootstrap.js";
import lottie from 'lottie-web';
import { defineElement } from 'lord-icon-element';
defineElement(lottie.loadAnimation);
import App from './App.vue'
import { router } from "./router"
createApp(App).use(router).mount('#app')
