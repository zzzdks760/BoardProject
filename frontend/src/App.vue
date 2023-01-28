<template>
  <div id="app">
    <BoardHeader />
    <BoardSignUp />
    <BoardLogin />
    <BoardFooter />
  </div>
</template>

<script>
import BoardSignUp from "./components/BoardSignUp";
import BoardLogin from "./components/BoardLogin";
import BoardHeader from "./components/BoardHeader";
import BoardFooter from "./components/BoardFooter";

export default {
  name: 'App',
  components: {
    BoardSignUp,
    BoardLogin,
    BoardFooter,
    BoardHeader,
  }
}
</script>
