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
import { mapGetters } from 'vuex'
export default {
    data() {
        return {
            loginemail: "",
            loginpw: "",
        }
    },
    computed: {
        ...mapGetters(["storedmemberItems", "storedmemberItemsCount"])
    },
    methods: {
        login() {
            const memberitems = this.storedmemberItems;
            for (let i = 0; i < this.storedmemberItemsCount; i++) {
                if (memberitems[i].item.email === this.loginemail && memberitems[i].item.password === this.loginpw) {
                    console.log("로그인 성공")
                }
                else {
                    console.log("아이디와 비밀번호를 확인해주세요.")
                }
            }
        }
    },
}
</script>