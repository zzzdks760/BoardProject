import { createApp } from 'vue'
import Vuex from 'vuex'
import storage from "./modules/storage";
import * as getters from "./modules/getters";
import * as mutations from "./modules/mutations";

const app = createApp();
app.use(Vuex);

const useSignupStore = new Vuex.Store({
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

const LoginStore = new Vuex.Store({
    LoginState: () =>({
        Name: "",
        Email: "",
        Password: "",
        state: false,
    }),
    mutations: mutations
})

const WriteStore = new Vuex.Store({
    Writestate: () =>({
        Email: "",
        Title: "",
        Contents: "",
        Time: "",
    }),
    mutations: mutations
})

const BoardStore = new Vuex.Store({
    Boardstate: () => ({
        Itmes: storage.fetchboard(),
    }),
    mutations: mutations
})

export { useSignupStore, LoginStore, WriteStore, BoardStore}