<script>
export default {
    
}
</script>
<template>
    <div class="mt-5">
        <div class="text-center ">
            <lord-icon
                src="https://cdn.lordicon.com/ihyatngg.json"
                trigger="loop"
                colors="primary:#121331,secondary:#d77d85"
                style="width:250px;height:250px">
            </lord-icon>
        </div>
        <div class="mt-5 text-white text-center" >
            <h1 >Grazie per averci contattato!</h1>
            <p >Il tuo messaggio è stato inviato con successo.</p>
            <router-link :to="{ name: 'FotoIndex' }" class="btn btn-secondary ">Torna Indietro</router-link>
        </div>
    </div>
</template>
<style lang="scss">
    
</style>