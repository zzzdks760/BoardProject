import axios from 'axios';
import {useSignupStore} from "@/store/store";

const storage = {
    async memberinformation() {
        /* 서버 통신 */
        const arr = [];

        await axios
            .get('/member/')
            .then(res => {
               const jsonData = res.data;

               if(jsonData.length > 0){
                   for(let i = 0 ; i < jsonData.length; i++){
                       arr.push(
                           jsonData[i]
                       );
                   }
               }
            });

        useSignupStore.state.memberinformations = arr;
    },
}

export default storage;