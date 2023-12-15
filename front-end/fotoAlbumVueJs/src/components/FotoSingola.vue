<script>


export default {
    name: 'FotoSingola',
    props:{
        foto: Object
    },
methods: {
    navigateToFoto() {
      this.$router.push({ name: 'Foto', params: { id: this.foto.id } });
    },
}
}
</script>
<template lang=""> 
        <div @click="navigateToFoto">{{foto.titolo}}</div>    
</template>
<style lang="">
    
</style>