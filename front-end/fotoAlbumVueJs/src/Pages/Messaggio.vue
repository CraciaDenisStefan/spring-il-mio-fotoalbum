<script>
import axios from 'axios';

export default {
  data() {
    return {
      formMessaggio: {
        email: '',
        messaggio: '',
      },
    };
  },
  methods: {
    async nuovoMessaggio() {
      try {
        await axios.post('http://localhost:8080/api/v1.0/foto', this.formMessaggio);
        this.$router.push({ name: 'Grazie' });
      } catch (error) {
        console.error('Errore durante l\'invio del messaggio', error);
      }
    },
  },
};
</script>

<template>
 <div class="container text-white mt-5">
    <h1>Messaggio</h1>
    <form @submit.prevent="nuovoMessaggio" class="col-6">
      <div class="mb-3">
        <label for="email" class="form-label">Email:</label>
        <input type="email" class="form-control" v-model="formMessaggio.email" required />
      </div>
      <div class="mb-3">
        <label for="messaggio" class="form-label">Messaggio:</label>
        <textarea class="form-control" v-model="formMessaggio.messaggio" required></textarea>
      </div>
      <button type="submit" class="btn btn-primary me-3">Invia</button>
      <router-link :to="{ name: 'FotoIndex' }" class="btn btn-secondary ">Torna Indietro</router-link>
    </form>
  </div>
  </template>
  
 
  