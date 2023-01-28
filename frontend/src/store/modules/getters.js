const errorEmail = (state) => {
    if (state.email.length == 0) return "이메일을 입력해주세요.";
    if (!checkEmail(state.email)) return "이메일 형식이 잘못되었습니다.";
    return ""
};

const errorPassword = (state) => {
    if (state.email.length == 0) return "이메일을 입력해주세요.";
    if (!checkEmail(state.email)) return "이메일 형식이 잘못되었습니다.";
    return ""
};

const errorPasswordConfirm = (state) => {
    if (state.email.length == 0) return "이메일을 입력해주세요.";
    if (!checkEmail(state.email)) return "이메일 형식이 잘못되었습니다.";
    return ""
};

const canSignup = (state) => {
    return (state.email != "") &&
        (state.errorEmail === "") &&
        (state.errorPassword === "") &&
        (state.errorPasswordConfirm === "")
};

function checkEmail(email) {
    try {
        let pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
        return (pattern.test(email));
    } catch (error) {
        return false;
    }
}

export { errorEmail, errorPassword, errorPasswordConfirm, canSignup};