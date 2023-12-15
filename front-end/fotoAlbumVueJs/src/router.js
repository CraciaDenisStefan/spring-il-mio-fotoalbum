import { createRouter, createWebHistory } from "vue-router";

import FotoIndex from './pages/FotoIndex.vue';
import Foto from './pages/Foto.vue';
import Messaggio from './pages/Messaggio.vue';

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
        {
            path: '/messaggio',
            name: 'Messaggio',
            component: Messaggio,
        },
    ]

});

export { router }