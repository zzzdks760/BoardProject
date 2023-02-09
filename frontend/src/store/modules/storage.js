import axios from 'axios';
import {useSignupStore} from "@/store/store";

const storage = {
    async fetch() {
        /* 서버 통신 */
        const arr = [];

        await axios
            .get('/member/get')
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
        useSignupStore.state.memberItmes = arr;
    },
    fetchemail() {
        if (localStorage.getItem("memberEmails")) {
            const memberEmails = localStorage.getItem("memberEmails");
            return memberEmails;
        }
    },
    fetchpw() {
        if(localStorage.getItem("memberPasswords")) {
            const memberPasswords = localStorage.getItem("memberPasswords");
            return memberPasswords;
        }
    },
}
export default storage;