import axios from 'axios';
import {BoardStore} from "@/store/store";

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
                        console.log(arr[i])
                    }
                }
            });
        BoardStore.state.Itmes = arr;
    }
}

export default liststorage;