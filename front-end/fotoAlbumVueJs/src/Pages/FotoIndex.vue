<script>
import axios from 'axios';

import FotoSingola from '../components/FotoSingola.vue';
export default {
    name: 'FotoIndex',
    components:{
        FotoSingola,
    },
    
    data(){
        return{
            foto: [],
            filtroTitolo: '',

        }
    },
    created() {
    this.getFoto();
  },
    methods: {
      async getFoto() {
      try {
        const response = await axios.get(`http://localhost:8080/api/v1.0/foto?titolo=${this.filtroTitolo}`);
        this.foto = response.data;
      } catch (error) {
        console.error('Errore durante la richiesta delle foto', error);
      }
    },
    
  },
    
}
</script>
<template lang="">
   <router-link  :to="{name: 'Messaggio' }">Invia un email </router-link>
  <input v-model="filtroTitolo" @keyup.enter="getFoto" placeholder="Filtra per titolo" />
        <ul>
            <li class="spazio" v-for="foto in foto" :key="foto.id">
                <FotoSingola :foto="foto" />
            </li>
        </ul>
</template>
<style >
.spazio{
  margin-bottom: 20px;
  cursor: pointer;
}
</style>