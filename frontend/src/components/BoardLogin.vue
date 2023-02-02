<template>
    <div>
        <div>
            E-Mail
            <input
                type="email"
                class="mail_input"
                placeholder="Enter your E-mail"

            />
        </div>
        <div>
            PassWord
            <input
                type="password"
                class="pw_input"
                placeholder="Enter your PassWord"
            />
        </div>
        <button class="login_buttonn">
            <span class="login" @click="login">LogIn</span>
        </button>
    </div>
</template>

<script>
import { useSignupStore } from "@/store/store"

export default {
    setup() {
        const loginstate = useSignupStore.loginstate
        return {
            loginstate,
        }
    },
    methods: {
        login() {
            this.$store.commit("login", this.loginstate);
        }
    },
}
</script>