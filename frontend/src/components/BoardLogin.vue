<template>
    <div>
        <div>
            E-Mail
            <input
                type="email"
                class="mail_input"
                placeholder="Enter your E-mail"
                v-model="this.loginstate.Email"
            />
        </div>
        <div>
            PassWord
            <input
                type="password"
                class="pw_input"
                placeholder="Enter your PassWord"
                v-model="this.loginstate.Password"
            />
        </div>
        <button class="login_buttonn">
            <span class="login" @click="login">LogIn</span>
        </button>
    </div>
</template>

<script>
//import { LoginStore } from "@/store/store"
import { mapState } from "vuex";

export default {
    setup() {

    },
    computed: {
        ...mapState({
            loginstate: LoginState => LoginState
        }) 
    },
    methods: {
        login() {
            this.$store.commit("login", this.loginstate);
        }
    },
}
</script>