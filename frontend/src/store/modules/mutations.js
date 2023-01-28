import axios from 'axios';
import router from '@/router'
//import storage from "@/store/modules/storage";

const signup = async (state) => {
    var signupvalue = {
        name: state.name,
        email: state.email,
        password: state.password,
        passwordConfirm: state.passwordConfirm,
    }
    
    await axios
        .post('/member/save',JSON.stringify(signupvalue))
        .then(res => {
            if(res.data == "ok"){
                alert("회원가입이 완료되었습니다.");
                router.push("/");
            }
            else {
                alert("등록 실패");
            }
        })
}

export { signup, }