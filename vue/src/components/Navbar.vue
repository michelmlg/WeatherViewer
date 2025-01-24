<script setup>
import { defineProps, ref } from 'vue';
import { useRoute, RouterLink } from 'vue-router';

// Definindo a prop 'colorScheme' com um valor padrão de 'bg-primary'
defineProps({
    colorScheme: {
        type: String,
        default: 'bg-light',
    }
});

const isActiveLink = (routePath) => {
    const route = useRoute();
    return route.path === routePath;
  }

</script>

<template>
    <!-- A classe do navbar agora será dinâmica, utilizando a prop 'colorScheme' -->
    <nav :class="['navbar', 'navbar-expand-md', colorScheme]">
        <div class="container-fluid">
            <img src="../assets/reshot-icon-weather.svg" style="width: auto; height: 2rem;">
            <a class="navbar-brand" href="#">Weather Viewer</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <RouterLink
                        to="/"
                        :class="[isActiveLink('/') ? 'nav-link active' : 'nav-link']"
                        >Home</RouterLink
                        >
                    </li>
                    <li class="nav-item">
                        <RouterLink
                        to="/about"
                        :class="[isActiveLink('/about') ? 'nav-link active' : 'nav-link']"
                        >Sobre</RouterLink
                        >
                    </li>
                </ul>
                <div class="ms-auto">
                    <ul class="navbar-nav align-items-center">
                        <li class="nav-item">
                            <RouterLink
                                to="/login"
                                ><button class="btn btn-sm btn-outline-success me-2">Login</button>
                            </RouterLink>
                        </li>
                        <li class="nav-item">
                            <RouterLink
                                to="/register"
                                ><button class="btn btn-sm btn-outline-secondary">Register</button>
                            </RouterLink>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</template>
