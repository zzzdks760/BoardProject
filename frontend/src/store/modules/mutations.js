import axios from 'axios';
//import { LoginStore } from "@/store/store"
//import storage from "@/store/modules/storage";

const signup = async (signup) => {
    var signupvalue = {
        memberName: signup.memberName,
        memberEmail: signup.memberEmail,
        memberPassword: signup.memberPassword,
    }
    
    await axios
        .post('/member/save',JSON.stringify(signupvalue))
        .then(res => {
            if(res.data == "ok"){
                alert("회원가입이 완료되었습니다.");
            }
            else {
                alert("등록 실패");
            }
        })
}


const login = async (loginstate) => {
    var loginvalue = {
        memberEmail: loginstate.Email,
        memberPassword: loginstate.Password,
    }
    console.log(loginvalue)
    await axios
        .post('/member/login',JSON.stringify(loginvalue))
        .then(res => {
            if(res.data == "ok"){
                alert("로그인 완료");
                //LoginStore.LoginState.state = true
                //LoginStore.LoginState.Name = ""
                //LoginStore.LoginState.Email = loginvalue.memberEmail
            }
            else {
                alert("로그인 실패");
            }
        })
}
export { signup, login,}