<script setup>
    import { RouterLink } from 'vue-router';
</script>
<template>
    <section class="text-center mt-4">  
      <i class="fa-solid fa-xmark" style="font-size: 3rem; color: #FFCC00"></i>
      <h1 class="">404 Not Found</h1>
      <p class="">Essa página não existe.</p>
      <RouterLink
        to="/"
        class=""
        >Go Back</RouterLink
      >
    </section>
</template>