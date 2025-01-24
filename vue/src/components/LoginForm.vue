<script setup>
import {ref} from 'vue';

const loginType = ref('username');

const selectLoginType = () => {
    console.log(loginType.value);
}

</script>

<template>
    <div class="card w-50 w-md-75 w-sm-100">
      <div class="card-header">
        <h5 class="card-title text-center">Login</h5>
      </div>
      <div class="card-body">
        <form method="POST" class="p-3" action="" @post.prevent="">
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
