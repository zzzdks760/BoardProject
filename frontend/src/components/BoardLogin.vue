<template>
    <div>
        <div>
            E-Mail
            <input
                type="email"
                class="mail_input"
                placeholder="Enter your E-mail"
                v-model="loginemail"
            />
        </div>
        <div>
            PassWord
            <input
                type="password"
                class="pw_input"
                placeholder="Enter your PassWord"
                v-model="loginpw"
            />
        </div>
        <button class="login_buttonn">
            <span class="login" @click="login">LogIn</span>
        </button>
    </div>
</template>

<script>
export default {
    data() {
        return {
            loginemail: "",
            loginpw: "",
        }
    },
    methods: {
        login() {
            this.$store.commit("login", this.loginemail, this.loginpw);
        }
    },
}
</script>