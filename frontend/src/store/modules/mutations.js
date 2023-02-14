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


const login = async (loginstate) => {
    var loginvalue = {
        memberName: loginstate.Name,
        memberEmail: loginstate.Email,
        memberPassword: loginstate.Password,
    }
    await axios
        .post('/member/login',JSON.stringify(loginvalue))
        .then(res => {
            if(res.data == "ok"){
                alert("로그인 완료");
                localStorage.setItem('Name', loginvalue.memberName)
                localStorage.setItem('Email', loginvalue.memberEmail)
                localStorage.setItem('detailstate', false)
            }
            else {
                alert("로그인 실패");
            }
            console.log(localStorage.getItem('Name'),localStorage.getItem('Email'))
        })
}

const write = async (writestate, loginstate) => {
    var writevalue = {
        memberEmail: loginstate.loginemail,
        boardTitle: writestate.Title,
        boardContents: writestate.Contents,
    }
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

const updates = async (listup) => {
    var writingidvalue = {
        id: listup.Items[0].id,
        boardTitle: listup.Items[0].boardTitle,
        boardContents: listup.Items[0].boardContents,
    }
    console.log(writingidvalue)
    console.log(listup)
    await axios
        .post('/board/update', JSON.stringify(writingidvalue))
        .then(res => {
            if(res.data == "ok"){
                alert("수정 성공")
            }
            else {
                alert("수정 실패")
            }
        })
}

const listdelete = async (boardid) => {
    var deletevalue = {
        id: boardid.boardreadstate
    }
    await axios
        .post(`/board/delete/${deletevalue.id}`, JSON.stringify(deletevalue))
        .then(res => {
            if(res.data == "ok"){
                console.log(res)
                alert("삭제 성공")
            }
            else {
                alert("삭제 실패")
            }
        })
}

const boardhit = async (id) => {
    var boardid = {
        id: id.boardreadstate
    }
    await axios
        .post(`/board/hit/${boardid.id}`, JSON.stringify(boardid))
}

const listsearch = async (word) => {
    var wordvalue = {
        Search: word.listsearch
    }
    console.log(wordvalue.search)
    await axios
        .post('/board/search', JSON.stringify(wordvalue))
        .then(res => {
            console.log(res)
            if(res !== null) {
                console.log("1")
            }
            else {
                console.log("1")
            }
        })
}

const comment = async (commentscopy) => {
    var commentsvalue = {
        Comments: commentscopy.comments,
        Email: localStorage.getItem('Email')
    }
    await axios
        .post('/board/comments', JSON.stringify(commentsvalue))
        .then(res => {
            if(res.data == "ok") {
                alert("댓글이 등록되었습니다.")
            }
            else {
                alert("댓글 등록에 실패하였습니다.")
            }
        })
}

export { signup, login, write, emailcheck, updates, listdelete, boardhit, listsearch, comment}