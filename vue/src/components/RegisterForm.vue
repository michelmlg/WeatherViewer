<script setup>
import { ref } from "vue";

const formData = ref({
  action: "register",
  username: "",
  email: "",
  password: "",
});

const dataResponse = ref(null);
const errorMessage = ref("");

const onSend = async () => {
  try {
    // Faz a requisição POST
    const response = await fetch("/api/user", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData.value), // Envia os dados como JSON
    });

    // Processa a resposta
    const result = await response.json();
    dataResponse.value = result;

    if (result.error) {
      errorMessage.value = result.error.message;
      return;
    }

    // Sucesso
    Swal.fire({
      title: "Registrado!",
      text: `O usuário ${username.value} foi registrado com sucesso!`,
      icon: "success"
    });
  } catch (error) {
    Swal.fire({
      title: "Ocorreu um erro.",
      text: `O usuário não foi registrado.`,
      icon: "error"
    });
    console.error("Erro ao enviar o formulário:", error);
    errorMessage.value = "Erro na requisição. Tente novamente mais tarde.";
  }
};

</script>

<template>
    <div class="card w-50 w-md-75 w-sm-100">
    <div class="card-header">
      <h5 class="card-title text-center">Register</h5>
    </div>
    <div class="card-body">
      <form @submit.prevent="onSend" class="p-3">
        <!-- Username -->
        <div class="mb-3">
          <label for="username" class="form-label">Username</label>
          <input
            type="text"
            class="form-control"
            id="username"
            v-model="formData.username"
            maxlength="80"
            required
          />
        </div>

        <!-- Email -->
        <div class="mb-3">
          <label for="email" class="form-label">Email</label>
          <input
            type="email"
            class="form-control"
            id="email"
            v-model="formData.email"
            maxlength="255"
            required
          />
        </div>

        <!-- Password -->
        <div class="mb-3">
          <label for="password" class="form-label">Password</label>
          <input
            type="password"
            class="form-control"
            id="password"
            v-model="formData.password"
            maxlength="32"
            required
          />
        </div>

        <!-- Erro -->
        <p v-if="errorMessage" class="text-danger">{{ errorMessage }}</p>

        <!-- Submit Button -->
        <button type="submit" class="btn btn-primary w-100">Enviar</button>
      </form>
    </div>
  </div>
</template>
