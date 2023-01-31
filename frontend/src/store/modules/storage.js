import axios from 'axios';
import {useSignupStore} from "@/store/store";

const storage = {
    async memberinformation(orderState) {
        var setState = true;
        /* 서버 통신 */
        const arr = [];

        if(orderState == undefined || orderState === null){
            setState == true;
        }
        else if(orderState != null || orderState != ""){
            setState = orderState;
        }

        await axios
            .get('/member')
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