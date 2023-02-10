<template>
  <div id="app">
    <BoardHeader />
    <BoardList v-if="this.loginstate.pagestate == 0"/>
    <BoardLogin v-if="this.loginstate.pagestate == 1"/>
    <BoardSignUp v-if="this.loginstate.pagestate == 2" />
    <BoardWrite v-if="this.loginstate.pagestate == 3" />
    <BoardRead v-if="this.loginstate.pagestate == 4" />
    <BoardUpdate v-if="this.loginstate.pagestate == 5" />
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
import BoardUpdate from "./components/BoardUpdate"
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
    BoardUpdate,
  },
}
</script>
