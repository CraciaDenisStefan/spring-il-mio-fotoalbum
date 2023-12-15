import { createRouter, createWebHistory } from "vue-router";

import FotoIndex from './pages/FotoIndex.vue';
import Foto from './pages/Foto.vue';

const router = createRouter({

    history: createWebHistory(),

    routes: [
        {
            path:'/',
            name: 'FotoIndex',
            component: FotoIndex,
        },
        {
            path: '/foto/:id',
            name: 'Foto',
            component: Foto,
        },
    ]

});

export { router }