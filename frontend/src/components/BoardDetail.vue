<template>
    <div>
        <div>
            <h1>게시판 상세보기</h1>

            <div class="AddWrap">
                <form>
                    <table class="tbAdd">
                        <colgroup>
                            <col width="3%" />
                            <col width="*" />
                            <col width="10%" />
                        </colgroup>
                        <tr>
                            <th>제목</th>
                            <td>{{this.detail.detailItems.boardTitle}}</td>
                            <td>{{this.detail.detailItems.memberEmail}}<br>{{this.detail.detailItems.boardCreatedTime}}<br>{{this.detail.detailItems.boardUpdatedTime}}</td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td class="txt_cont">{{this.detail.detailItems.boardContents}}</td>
                        </tr>
                    </table>
                </form>
            </div>
            <button @click="update" v-if="this.detail.detailstate">수정</button>
            <button @click="listdelete"  v-if="this.detail.detailstate">삭제</button>
        </div>
    </div>
</template>

<script>
import { useSignupStore } from "@/store/store"

export default {
    setup() {
        const detail = useSignupStore.state
        return {
            detail,
        }
    },
    methods: {
        update() {
            this.detail.pagestate = 5
            localStorage.setItem('detailstate', false)
            this.detail.detailstate = false
        },
        listdelete() {
            localStorage.setItem('detailstate', false)
            this.detail.detailstate = false
            this.$store.commit("listdelete", this.detail);
            this.detail.pagestate = 0
            window.location.reload(true);
        },
    },
}
</script>

<style scoped>
	.tbAdd{border-top:1px solid #888;}
	.tbAdd th, .tbAdd td{border-bottom:1px solid #eee; padding:5px 0; }
	.tbAdd td{padding:10px 10px; box-sizing:border-box; text-align:left;}
	.tbAdd td.txt_cont{height:300px; vertical-align:top;}
	.btnAdd {background:#43b984}
	.btnDelete{background:#f00;}
</style>