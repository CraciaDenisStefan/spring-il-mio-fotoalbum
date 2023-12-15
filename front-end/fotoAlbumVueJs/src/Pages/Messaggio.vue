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
        this.$router.push({ name: 'FotoIndex' });
      } catch (error) {
        console.error('Errore durante l\'invio del messaggio', error);
      }
    },
  },
};
</script>

<template>
    <div>
      <h1>Messaggio</h1>
      <form @submit.prevent="nuovoMessaggio">
        <label for="email">Email:</label>
        <input type="email" v-model="formMessaggio.email" required />
  <br>
        <label for="messaggio">Messaggio:</label>
        <textarea v-model="formMessaggio.messaggio" required></textarea>
  <br>
      
        <button type="submit">Invia</button><br>
        <router-link :to="{ name: 'FotoIndex' }">Torna Indietro</router-link>
      </form>
    </div>
  </template>
  
 
  