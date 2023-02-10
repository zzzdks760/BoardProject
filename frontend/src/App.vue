<template>
  <div id="app">
    <BoardHeader />
    <BoardSignUp v-if="this.loginstate.pagestate == 2" />
    <BoardLogin v-if="this.loginstate.pagestate == 1"/>
    <BoardWrite v-if="this.loginstate.pagestate == 3" />
    <BoardList v-if="this.loginstate.pagestate == 4"/>
    <BoardRead />
    <BoardFooter />
  </div>
</template>

<script>
import BoardSignUp from "./components/BoardSignUp";
import BoardLogin from "./components/BoardLogin";
import BoardHeader from "./components/BoardHeader";
import BoardFooter from "./components/BoardFooter";
import BoardList from "./components/BoardList";
import BoardWrite from "./components/BoardWrite";
import BoardRead from "./components/BoardRead";
import { mapState } from "vuex";

export default {
  name: 'App',
    computed: {
        ...mapState({
            loginstate: state => state,
        }) 
    },
  components: {
    BoardSignUp,
    BoardLogin,
    BoardFooter,
    BoardHeader,
    BoardList,
    BoardWrite,
    BoardRead,
  },
}
</script>
