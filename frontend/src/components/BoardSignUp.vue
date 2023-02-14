<template>
  <div class="col-md-12">
    <div class="card card-container">
      <img
        id="profile-img"
        src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"
        class="profile-img-card"
      />
      <form name="form" @submit.prevent="handleRegister">
        <div v-if="!successful">
          <div class="form-group">
            <label class="form-text" for="username">Username</label>
            <input
              type="text"
              class="form-control"
              name="username"
              v-model="signup.memberName"
              v-validate="'required|min:3|max:20'"
            />
            <div
              class="alert-danger"
              
            >{{ this.errorName }}</div>
          </div>
          <div class="form-group">
            <label class="form-text" for="email">Email</label>
            <input
              type="email"
              class="form-control"
              name="email"
              v-model="signup.memberEmail"
              v-validate="'required|email|max:50'"
            />
            <div
              class="alert-danger"
              
            >{{ this.errorEmail }}</div>
          </div>
          <div class="form-group">
            <label class="form-text" for="password">Password</label>
            <input
              type="password"
              class="form-control"
              name="password"
              v-model="signup.memberPassword"
              v-validate="'required|min:6|max:40'"
            />
            <div
              class="alert-danger"
              
            >{{ this.errorPassword }}</div>
          </div>
          <div class="form-group">
            <label class="form-text" for="passwordConfirm">PasswordConfirm</label>
            <input
              type="password"
              class="form-control"
              name="passwordConfirm"
              v-model="signup.memberPasswordConfirm"
              v-validate="'required|min:6|max:40'"
            />
            <div
              class="alert-danger"
              
            >{{ this.errorPasswordConfirm }}</div>
          </div>
          <div class="form-group">
            <button class="btn btn-primary btn-block">Sign Up</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>


<script>
import { useSignupStore } from "@/store/store"
import { mapGetters } from "vuex";
import { mapState } from "vuex";

export default {
    name: "BoardSignUp",
    setup() {
        const signup = useSignupStore.state
        return {
            signup,
        }
    },
    computed: {
        ...mapGetters([
            "errorEmail", "errorPassword", "errorPasswordConfirm", "errorName", "storedmemberItems", "storedmemberItemsCount"
            ]),
        ...mapState({
            signupstate: state => state
        }) 
    },
    methods: {
        submit() {
            if(this.errorEmail === "" && this.errorPassword === "" && this.errorPasswordConfirm === "" && this.errorName === "")
            {
                this.$store.commit("signup", this.signup);
                this.clearInput();
                this.signupstate.pagestate = 0
                window.location.reload(true);
            }
            else
            {
                const text = "회원가입에 실패하셨습니다.";
                alert(text)
            }
        },
        clearInput() {
            this.signup.memberName = "";
            this.signup.memberEmail = "";
            this.signup.memberPassword = "";
            this.signup.memberPasswordConfirm = "";
        },
        check() {
            if(this.errorEmail === "")
            {
                this.$store.commit("emailcheck", this.signup)
            }
        }
    },
}
</script>


<style scoped>
label {
  display: block;
  margin-top: 10px;
}

.form-group {
    text-align: center ;
}

.form-text {
    padding-left: 50px;
    text-align: left ;
}

.card-container.card {
  max-width: 350px !important;
  padding: 40px 40px;
}

.card {
  background-color: #f7f7f7;
  padding: 20px 25px 30px;
  margin: 0 auto 25px;
  margin-top: 50px;
  -moz-border-radius: 2px;
  -webkit-border-radius: 2px;
  border-radius: 2px;
  -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.profile-img-card {
  width: 96px;
  height: 96px;
  margin: 0 auto 10px;
  display: block;
  -moz-border-radius: 50%;
  -webkit-border-radius: 50%;
  border-radius: 50%;
}
</style>