import { createApp } from 'vue'
import Vuex from 'vuex'
import storage from "./modules/storage";
import * as getters from "./modules/getters";
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
    loginstate: () =>({
        loginName: "",
        loginEmail: "",
        loginPassword: "",
        loginstate: false,
    }),
    getters: getters,
    mutations: mutations
})