<template>
    <div>
        <div>
            Name:
            <input
                type="text"
                class="name_input"
                placeholder="Enter your name"
                v-model="signup.name"
            />
        </div>
        <div>
            E-Mail:
            <input
                type="email"
                class="mail_input"
                placeholder="Enter your E-mail"
                v-model="signup.email"
            />
            <p>{{ signup.errorEmail }}</p>
        </div>
        <div>
            PassWord:
            <input
                type="password"
                class="pw_input"
                placeholder="Enter your PassWord"
                v-model="signup.password"
            />
            <p>{{ signup.errorPassword }}</p>
        </div>
        <div>
            PassWord Check:
            <input
                type="password"
                class="pwcheck_input"
                placeholder="Enter your PassWord"
                v-model="signup.passwordConfirm"
            />
            <p>{{ errorPasswordConfirm }}</p>
        </div>
        <button class="signup_buttonn" @click="signup.submit" :disabled="!signup.canSignup">
            <span class="signup">SignUp</span>
        </button>
    </div>
</template>

<script>
import { useSignupStore } from "@/store/store"
import { mapGetters } from "vuex";

export default {
    setup() {
        const signup = useSignupStore
        return {
            signup,
        }
    },
    computed: {
        ...mapGetters(["errorEmail", "errorPassword", "errorPasswordConfirm", "canSignup"])
    },
}
</script>