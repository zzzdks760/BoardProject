<template>
    <div>
        <div id="board_write">
            <h4>글을 작성하는 공간입니다.</h4>
            <div id="write_area">
                <form>
                    <div id="in_title">
                        <textarea name="title" id="utitle" rows="1" cols="55" placeholder="제목" maxlength="100" required v-model="this.writestate.Title"></textarea>
                    </div>
 
                    <div class="wi_line"></div>
                    <div id="in_content">
                        <textarea name="content" id="ucontent" cols="55" placeholder="내용" required v-model="this.writestate.Contents"></textarea>
                    </div> 
                    <div class="bt_se">
                        <button @click="write">글 작성</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
import { mapState } from "vuex";

export default {
    computed: {
        ...mapState({
            loginstate: LoginState => LoginState,
            writestate: Writestate => Writestate,
        }) 
    },
    methods: {
        write() {
            console.log(this.loginstate.Email)
            this.$store.commit("write", this.writestate, this.loginstate);

        }
    },
}
</script>