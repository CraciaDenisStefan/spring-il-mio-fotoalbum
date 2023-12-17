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
<template> 
  
            <div class="col-3 my-3 " v-if="foto.visibile">
                <div @click="navigateToFoto" class="card h-100 pointer">
                    <img v-if="foto.url" :src="foto.url" class="card-img-top" alt="Foto">
                    <div class="card-body">
                        <h6 class="card-title">{{ foto.titolo }}</h6>
                    </div>
                 </div> 
            </div>
</template>
<style lang="scss">
    .pointer{
        cursor: pointer;
    }
</style>