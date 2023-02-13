<template>
    <div>
        <div>
            Name:
            <input
                type="text"
                class="name_input"
                placeholder="Enter your name"
                v-model="signup.memberName"
            />
            <p>{{ this.errorName }}</p>
        </div>
        <div>
            E-Mail:
            <input
                type="email"
                class="mail_input"
                placeholder="Enter your E-mail"
                v-model="signup.memberEmail"
            /> <button @click="check">중복확인</button>
            <p>{{ this.errorEmail }}</p>
        </div>
        <div>
            PassWord:
            <input
                type="password"
                class="pw_input"
                placeholder="Enter your PassWord"
                v-model="signup.memberPassword"
            />
            <p>{{ this.errorPassword }}</p>
        </div>
        <div>
            PassWord Check:
            <input
                type="password"
                class="pwcheck_input"
                placeholder="Enter your PassWord"
                v-model="signup.memberPasswordConfirm"
            />
            <p>{{ this.errorPasswordConfirm }}</p>
        </div>
        <button class="signup_buttonn" @click="submit">
            <span class="signup">SignUp</span>
        </button>
    </div>
</template>

<script>
import { useSignupStore } from "@/store/store"
import { mapGetters } from "vuex";
import { mapState } from "vuex";

export default {
    name: "BoardSignUp",
    setup() {
        const signup = useSignupStore.state
        return {
            signup,
        }
    },
    computed: {
        ...mapGetters([
            "errorEmail", "errorPassword", "errorPasswordConfirm", "errorName", "storedmemberItems", "storedmemberItemsCount"
            ]),
        ...mapState({
            signupstate: state => state
        }) 
    },
    methods: {
        submit() {
            if(this.errorEmail === "" && this.errorPassword === "" && this.errorPasswordConfirm === "" && this.errorName === "")
            {
                this.$store.commit("signup", this.signup);
                this.clearInput();
                this.signupstate.pagestate = 0
                window.location.reload(true);
            }
            else
            {
                const text = "회원가입에 실패하셨습니다.";
                alert(text)
            }
        },
        clearInput() {
            this.signup.memberName = "";
            this.signup.memberEmail = "";
            this.signup.memberPassword = "";
            this.signup.memberPasswordConfirm = "";
        },
        check() {
            if(this.errorEmail === "")
            {
                this.$store.commit("emailcheck", this.signup)
            }
        }
    },
}
</script>