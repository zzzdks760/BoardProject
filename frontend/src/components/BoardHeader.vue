<template>
    <header class="header">

        <div class="headerbar">
            <h1 class="logo">
                <span>logo</span>
            </h1>
            <h3 class="menu">
            <span class="menubutton" v-if="this.loginstate.loginname === null || this.loginstate.loginname === '' || this.loginstate.loginname === undefined" @click="loginpage">로그인</span>
            <span class="menubutton" v-else @click="logout">로그아웃</span>
            <span class="menubutton" @click="boardpage">게시판</span>
            <span class="menubutton" v-if="this.loginstate.loginname !== null && this.loginstate.loginname !== '' && this.loginstate.loginname !== undefined" @click="writepage">글작성</span>
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
import { PageStore } from "@/store/store"

export default {
    data() {
        return {
            PageStore: PageStore.state,
            timestamp: "",
            loginname: "",
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
        loginpage() {
            this.loginstate.pagestate = 1
            localStorage.setItem('detailstate', false)
            this.loginstate.detailstate = false
        },
        logout() {
            this.loginstate.pagestate = 0
            this.loginstate.Name = ""
            alert("로그아웃 되었습니다.")
            localStorage.setItem('detailstate', false)
            this.loginstate.detailstate = false
            localStorage.removeItem('Name')
            localStorage.removeItem('Email')
            window.location.reload(true);
        },
        boardpage() {
            this.loginstate.pagestate = 0
            localStorage.setItem('detailstate', false)
            this.loginstate.detailstate = false
            window.location.reload(true);
        },
        writepage() {
            this.loginstate.pagestate = 3
            localStorage.setItem('detailstate', false)
            this.loginstate.detailstate = false
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