
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
  <div>
    <div class="mt-5">
      <router-link  :to="{name: 'FotoIndex' }">Torna alla lista </router-link>
     </div>
    <h1>{{ foto.titolo }}</h1>
    <p>{{ foto.descrizione }}</p>
    <img :src="foto.url" alt="Immagine" />
  </div>
</template>
<style >
img{
  width: 20rem;
}
</style>


