import { createApp } from 'vue'
import Vuex from 'vuex'
import storage from "./modules/storage";
import liststorage from './modules/Liststorage';
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
    state: () =>({
        Name: "",
        Email: "",
        Password: "",
        state: false,
    }),
    mutations: mutations
})

const WriteStore = new Vuex.Store({
    state: () =>({
        Email: "",
        Title: "",
        Contents: "",
        Time: "",
    }),
    mutations: mutations
})

const BoardStore = new Vuex.Store({
    state: () => ({
        Itmes: liststorage.fetchboard(),
    }),
    getters: getters,
    mutations: mutations
})
//0 = 게시판, 1 = 로그인, 2 = 회원가입, 3 = 글작성
const PageStore = new Vuex.Store({
    state: () => ({
        pagestate: 0,
    })
})

export { PageStore, useSignupStore, LoginStore, WriteStore, BoardStore}