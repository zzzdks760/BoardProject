import axios from 'axios';
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


const login = async (email, password) => {
    var loginvalue = {
        memberEmail: email,
        memberPassword: password,
    }
    
    await axios
        .post('/member/login',JSON.stringify(loginvalue))
        .then(res => {
            if(res.data == "ok"){
                alert("로그인 완료");
            }
            else {
                alert("로그인 실패");
            }
        })
}
export { signup, login,}