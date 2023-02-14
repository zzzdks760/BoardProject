<template>
	<div class="container">
		<h1>게시판 등록</h1>

		<div class="AddWrap">
			<form>
				<table class="tbAdd">
					<colgroup>
						<col width="15%" />
						<col width="85%" />
					</colgroup>
					<tr>
						<th>제목</th>
						<td><input type="text" class="inputbox" v-model="this.writestate.Title" ref="subject" /></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea class="inputbox" v-model="this.writestate.Contents" ref="cont"></textarea></td>
					</tr>
				</table>
			</form>
		</div>

		<div class="btnWrap">
			<a href="javascript:;" @click="write" class="btnAdd btn">등록</a>
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
            this.loginstate.pagestate = 0
            this.writestate.Title = ""
            this.writestate.Contents = ""
            window.location.reload(true);
        },
    },
}
</script>

<style scoped>
	.tbAdd{border-top:1px solid #888;}
	.tbAdd th, .tbAdd td{border-bottom:1px solid #eee; padding:5px 0;}
	.tbAdd td{padding:10px 10px; box-sizing:border-box;}
	.tbAdd td input{width:100%; min-height:30px; box-sizing:border-box; padding:0 10px;}
	.tbAdd td textarea{width:100%; min-height:300px; padding:10px; box-sizing:border-box;}
	.btnWrap{text-align:center; margin:20px 0 0 0;}
	.btnWrap a{margin:0 10px;}
	.btnAdd {background:#43b984}
	.btnDelete{background:#f00;}
    .container{text-align: center}
    .inputbox{size: 200;}
</style>