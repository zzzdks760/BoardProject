<template>
    <div>
        <button @click="start">시작</button>
        <span>
            <button v-if="pagenumber === pagination.paging.totalElements" @click="pageingsave">
                {{pagenumber - 2}}
            </button>
            <button v-if="pagenumber !== 1">
                {{pagenumber - 1}}
            </button>
            <button>
                {{pagenumber}}
            </button>
            <button v-if="pagenumber !== pagination.paging.totalElements">
                {{pagenumber + 1}}
            </button>
            <button v-if="pagenumber === 1">
                {{pagenumber + 2}}
            </button>
        </span>
        <button @click="end">끝</button>
    </div>
</template>

<script>
import { mapState } from "vuex";

export default {
    setup() {
        const pagenumber = 1
        return{
            pagenumber,
        }
    },
    computed: {
        ...mapState({
            pagination: LoginState => LoginState
        }) 
    },
    methods: {
        start() {
            localStorage.setItem('pagenumber', 1)
            this.pagenumber = localStorage.getItem('pagenumber')
        },
        end() {
            localStorage.setItem('pagenumber', this.pagination.paging.totalElements)
            this.pagenumber = localStorage.getItem('pagenumber')
            console.log(this.pagenumber)
        },
        pageingsave() {
            localStorage.setItem('pagenumber', this.pagenumber)
            this.pagenumber = localStorage.getItem('pagenumber')
        }
    },
}
</script>