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
            <div class="spazio container mt-5">
                <div class="d-flex my-5">
                    <div class="col-6">
                      <router-link  :to="{name: 'Messaggio' }" class="btn btn-primary">Invia un email </router-link>
                    </div>
                    <div class="col-6">
                      <input class="form-control me-2 bg-transparent w-50 text-white" type="search" aria-label="Search" v-model="filtroTitolo" @keyup.enter="getFoto" placeholder="Filtra per titolo" />
                    </div>
                </div>
                <div class="row" >
                  <FotoSingola  v-for="foto in foto" :key="foto.id" :foto="foto" />
                </div>
            </div>
      
</template>
<style >
.form-control::placeholder {
  color: rgba(255, 255, 255, 0.295); /* Il colore che desideri */
}
</style>