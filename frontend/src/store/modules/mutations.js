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

const emailcheck = async (signup) => {
    var emailvalue = {
        memberEmail: signup.memberEmail
    }
    
    await axios
        .post('/member/email-check', JSON.stringify(emailvalue))
        .then(res => {
            if(res.data == "ok") {
                alert("사용 가능한 이메일입니다.");
            }
            else {
                alert("중복된 이메일입니다.");
            }
        })
}


const login = async (loginstate, loginname) => {
    var loginvalue = {
        memberEmail: loginstate.Email,
        memberPassword: loginstate.Password,
    }
    await axios
        .post('/member/login',JSON.stringify(loginvalue))
        .then(res => {
            if(res.data == "ok"){
                alert("로그인 완료");
                loginstate.state = true
                loginstate.Name = loginname
                loginstate.Email = loginvalue.memberEmail
                console.log(loginstate.state, loginstate.Name, loginstate.Email)
            }
            else {
                alert("로그인 실패");
            }
        })
}

const write = async (writestate, loginstate) => {
    var writevalue = {
        memberEmail: loginstate.Email,
        boardTitle: writestate.Title,
        boardContents: writestate.Contents,
    }
    console.log(writevalue.memberEmail, writevalue.boardTitle, writevalue.boardContents)
    await axios
        .post('/board/write' ,JSON.stringify(writevalue))
        .then(res => {
            if(res.data == "ok"){
                alert("게시글이 등록되었습니다.")
            }
            else {
                alert("등록 실패.")
            }
        })
}

export { signup, login, write, emailcheck,}