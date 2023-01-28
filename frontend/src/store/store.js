import { createApp } from 'vue'
import Vuex from 'vuex'
//import storage from "./modules/storage";
import * as getters from "./modules/getters";
import * as mutations from "./modules/mutations";

const app = createApp();
app.use(Vuex);

export const useSignupStore = new Vuex.Store({
    state: () =>({
        name: "",
        email: "",
        password: "",
        passwordConfirm: "",
    }),

    getters: getters,
    mutations: mutations
})