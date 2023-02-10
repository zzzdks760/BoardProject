<template>
  <div id="app">
    <BoardHeader />
    <BoardSignUp v-if="false" />
    <BoardLogin />
    <BoardWrite  />
    <BoardList v-if="false" />
    <BoardRead v-if="false" />
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
