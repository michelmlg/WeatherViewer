<script setup>
import {ref} from 'vue';

const dataResponse = ref(null);
const loginType = ref('username');

const formData = ref({
  method: loginType,
  username: "",
  email: "",
  password: "",
});

const selectLoginType = () => {
    console.log(loginType.value);
    console.log(formData);
}

const onSend = async () => {
  try {
    const response = await fetch("/api/user/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData.value),
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
      title: "Logado!",
      icon: "success"
    });

    console.log(result);
  } catch (error) {
    Swal.fire({
      title: "Ocorreu um erro.",
      text: `Não foi possível realizar o login. ${error}`,
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
        <h5 class="card-title text-center">Login</h5>
      </div>
      <div class="card-body">
        <form @submit.prevent="onSend" >
          <!-- Username -->
            <div class="mb-3">
                <label for="login_with">Login with:</label>
                <select class="form-select" name="login_with" id="login_with" @change="selectLoginType" v-model="loginType">
                    <option value="username">Username</option>
                    <option value="email">E-mail</option>
                </select>
            </div>
          <div class="mb-3" v-if="loginType === 'username'">
            <label for="username" class="form-label">Username</label>
            <input
              type="text"
              class="form-control"
              id="username"
              name="username"
              v-model="formData.username"
              placeholder="seunome"
              maxlength="80"
              required
            />
          </div>
          <div class="mb-3" v-else>
            <label for="email" class="form-label">Email</label>
            <input
              type="email"
              class="form-control"
              id="email"
              name="email"
              v-model="formData.email"
              maxlength="255"
              placeholder="seu-email@email.com"
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
              name="password"
              v-model="formData.password"
              maxlength="32"
              required
            />
          </div>

          <!-- Submit Button -->
          <button type="submit" class="btn btn-primary w-100">Enviar</button>
        </form>
      </div>
    </div>

</template>
