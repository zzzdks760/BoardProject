<template>
    <header class="header">

        <div class="headerbar">
            <h1 class="logo">
                <span>logo</span>
            </h1>
            <h3 class="menu">
            <span class="menubutton" v-if="this.loginstate.Name === null || this.loginstate.Name === '' || this.loginstate.Name === undefined" @click="pagestate">로그인</span>
            <span class="menubutton" v-else @click="pagestate">로그아웃</span>
            <span class="menubutton" @click="a">button</span>
            <span class="menubutton">button</span>
            <span class="menubutton">button</span>
            </h3>
        </div>
        <div class="time_date">
            
        <span class="header_date">{{ timestamp }}</span>
        </div>
    </header>
</template>

<script>
import getDate from "../assets/common/getDate.js";
import { mapState } from "vuex";
//import { PageStore } from "@/store/store"

export default {
    data() {
        return {
            timestamp: "",
        }
    },
    computed: {
        ...mapState({
            loginstate: state => state,
        }) 
    },
    created() {
        this.timestamp = `${getDate().month}/${getDate().date} ${getDate().week}`;
    },
    methods: {
        pagestate() {
            this.loginstate.pagestate = 1
        }
    },
}
</script>

<style>
.headerbar {
  height: 75px;
  padding: 1rem;
  color: white;
  background: powderblue;
  font-weight: bold;
  display: flex;
  align-items: center;
}
.header_date {
    padding-right: 20px;
}
.time_date {
    text-align: right;
}
.menu {
    text-align: left;
    padding:2em
}
.menubutton {
    padding:0.5em
}
</style>