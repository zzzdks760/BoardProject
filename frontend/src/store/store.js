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
        pagingnumber: localStorage.getItem('pagenumber'),
        paging: liststorage.fetchpaging(),
        commentsItems: liststorage.fetchcomments(),
        comments: "",
        listsearch: "",
        loginname: localStorage.getItem('Name'),
        loginemail: localStorage.getItem('Email'),
        detailstate: localStorage.getItem('detailstate'),
        detailItems: "",
        Items: liststorage.fetchboard(),
        boardreadstate: 0,
        pagererload: false,
        pagestate: 0,
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
    mutations: mutations,
})

const LoginStore = new Vuex.Store({
    state: () =>({
        Name: "",
        Email: "",
        Password: "",
        loginstate: false,
    }),
    mutations: mutations,
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
/*
const BoardStore = new Vuex.Store({
    state: () => ({
        Itmes: liststorage.fetchboard(),
    }),
    getters: getters,
    mutations: mutations
})*/
//0 = 게시판, 1 = 로그인, 2 = 회원가입, 3 = 글작성, 4 = 상세정보, 5 = 수정
const PageStore = new Vuex.Store({
    state: () => ({
        pagestate: 0,
    })
})

export { PageStore, useSignupStore, LoginStore, WriteStore,}