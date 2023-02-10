<template>
  <div id="app">
    <BoardHeader />
    <BoardSignUp v-if="false" />
    <BoardLogin />
    <BoardWrite  />
    <BoardList />
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
//import { PageStore } from "@/store/store"

export default {
  name: 'App',
  components: {
    BoardSignUp,
    BoardLogin,
    BoardFooter,
    BoardHeader,
    BoardList,
    BoardWrite,
    BoardRead,
  }
}
</script>
