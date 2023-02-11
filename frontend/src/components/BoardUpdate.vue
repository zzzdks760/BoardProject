<template>
    <div>
        <div id="board_write">
            <h4>글을 작성하는 공간입니다.</h4>
            <div id="write_area">
                <div id="in_title">
                    <textarea name="title" id="utitle" rows="1" cols="55" placeholder="제목" maxlength="100" required v-model="this.update.detailItems.boardTitle"></textarea>
                </div>

                <div class="wi_line"></div>
                <div id="in_content">
                    <textarea name="content" id="ucontent" cols="55" placeholder="내용" required v-model="this.update.detailItems.boardContents"></textarea>
                </div> 
                <div class="bt_se">
                    <button @click="boardupdate">수정</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { useSignupStore } from "@/store/store"
export default {
    setup() {
        const update = useSignupStore.state
        return {
            update,
        }
    },
    methods: {
        boardupdate() {
            this.$store.commit("updates", this.update);
            this.update.pagestate = 0
        }
    },
}
</script>