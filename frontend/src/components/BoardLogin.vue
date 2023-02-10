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
        <button class="login_buttonn">
            <span class="login" @click="signup">SignUp</span>
        </button>

    </div>
</template>

<script>
//import { LoginStore } from "@/store/store"
import { mapState } from "vuex";

export default {
    setup() {
        const loginname = ""
        return {
            loginname,
        }
    },
    computed: {
        ...mapState({
            loginstate: LoginState => LoginState
        }) 
    },
    methods: {
        login() {
            this.loginname = this.loginstate.memberItmes.filter(item => {
                return item.memberEmail === this.loginstate.Email
            })[0].memberName
            this.$store.commit("login", this.loginstate, this.loginname);
        },
        signup() {
            this.loginstate.pagestate = 2
        }
    },
}
</script>