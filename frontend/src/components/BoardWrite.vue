<template>
    <div>
        <div id="board_write">
            <h4>글을 작성하는 공간입니다.</h4>
            <div id="write_area">
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
            </div>
        </div>
    </div>
</template>

<script>
import { mapState } from "vuex";

export default {
    computed: {
        ...mapState({
            loginstate: state => state,
            writestate: state => state,
        }) 
    },
    methods: {
        write() {
            this.$store.commit("write", this.writestate, this.loginstate);
            this.writestate.Title = ""
            this.writestate.Contents = ""
            this.loginstate.pagestate = 0
            window.location.reload(true);
        },
    },
}
</script>