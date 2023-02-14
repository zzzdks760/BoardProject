import axios from 'axios';
import {useSignupStore} from "@/store/store";

const liststorage = {
    async fetchboard() {
        const arr = [];

        await axios
            .get('/board/boardList')
            .then(res => {
                const jsonData = res.data;
                if(jsonData.length > 0){
                    for(let i = 0; i < jsonData.length; i++){
                        arr.push(
                            jsonData[i]
                        );
                    }
                }
            })
            useSignupStore.state.Items = arr;
    },

    async fetchcomments() {
        const arr = []

        await axios
            .get('/board/commentsList')
            .then(res => {
                const jsonData = res.data
                if(jsonData.length > 0){
                    for(let i = 0; i < jsonData.length; i++){
                        arr.push(
                            jsonData[i]
                        );
                    }
                }
            })
            useSignupStore.state.commentsItems = arr;
    },

    async fetchpaging() {

        await axios
            .get('/board/paging')
            .then(res => {
                const jsonData = res.data
                console.log(res)
                useSignupStore.state.paging = jsonData
            })
    }
}

export default liststorage;