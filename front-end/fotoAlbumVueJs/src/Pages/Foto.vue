
<script >
import axios from 'axios';

export default {
    name: 'Foto',  
    data(){ 
        return {
      foto: {},
    }; 
    },
    created() {
    this.getUnaFoto();
  },
    methods: {
      async getUnaFoto() {
      try {
        const response = await axios.get(`http://localhost:8080/api/v1.0/foto/${this.$route.params.id}`);
        this.foto = response.data;
      } catch (error) {
        console.error('Errore durante la richiesta delle foto', error);
      }
    },
  },
    
}

</script>
<template>
  <div class="container mt-5 text-white">
    <div class="mb-3">
      <router-link :to="{name: 'FotoIndex' }" class="btn btn-secondary">Torna alla lista</router-link>
    </div>
    <h1 class="display-4">{{ foto.titolo }}</h1>
    <p class="lead">{{ foto.descrizione }}</p>
    <img :src="foto.url" alt="Immagine" class="img-fluid rounded">

    <p class="mt-2" v-if="foto.categorie && foto.categorie.length > 0">
          Categorie: {{ foto.categorie.map(categoria => categoria.titolo).join(', ') }}
    </p>
  </div>
</template>
<style >
img{
  width: 30rem;
}
</style>


