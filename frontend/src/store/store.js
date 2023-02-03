import { createApp } from 'vue'
import Vuex from 'vuex'
import storage from "./modules/storage";
import * as getters from "./modules/getters";
import * as logingetters from "./modules/logingetters";
import * as mutations from "./modules/mutations";

const app = createApp();
app.use(Vuex);

export const useSignupStore = new Vuex.Store({
    state: () =>({
        memberName: "",
        memberEmail: "",
        memberPassword: "",
        memberPasswordConfirm: "",
        memberItmes: storage.fetch(),
        memberEmails: storage.fetchemail(),
        fetchpw: storage.fetchpw(),
        //boardItems: storage.fetch(),
    }),
    getters: getters,
    mutations: mutations
})

export const LoginStore = new Vuex.Store({
    LoginState: () =>({
        Name: "",
        Email: "",
        Password: "",
        state: false,
    }),
    logingetters: logingetters,
    mutations: mutations
})