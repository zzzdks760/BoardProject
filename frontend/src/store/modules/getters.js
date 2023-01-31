const errorName = (state) => {
    if (state.name.length == 0) return "이름을 입력해주세요."
    return ""
}

const errorEmail = (state) => {
    if (state.email.length == 0) return "이메일을 입력해주세요.";
    if (!checkEmail(state.email)) return "이메일 형식이 잘못되었습니다.";
    return ""
};

const errorPassword = (state) => {
    if (state.password.length == 0) return "비밀번호을 입력해주세요.";
    if (state.password.length < 6) return "비밀번호는 6자 이상 입력해주세요.";
    return ""
};

const errorPasswordConfirm = (state) => {
    if (state.passwordConfirm.length == 0) return "비밀번호를 입력해주세요.";
    if (state.passwordConfirm.length < 6) return "비밀번호는 6자 이상 입력해주세요.";
    if (state.passwordConfirm !== state.password) return "비밀번호가 일치하지 않습니다.";
    return ""
};

const storedmemberItems = (state) => {
    return state.memberitmes;
};

const storedmemberItemsCount = (state, getters) => {
    return getters.storedmemberItems.length;
}

function checkEmail(email) {
    try {
        let pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
        return (pattern.test(email));
    } catch (error) {
        return false;
    }
}

export { errorEmail, errorPassword, errorPasswordConfirm, errorName, storedmemberItems, storedmemberItemsCount};