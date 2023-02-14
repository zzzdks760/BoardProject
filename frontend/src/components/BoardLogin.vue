<template>
  <div class="col-md-12">
    <div class="card card-container">
      <img
        id="profile-img"
        src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"
        class="profile-img-card"
      />
      <form name="form">
        <div class="form-group">
          <label for="username">Username</label>
          <input
            type="email"
            class="form-control"
            name="username"
            v-model="this.loginstate.Email"
          />
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input
            type="password"
            class="form-control"
            name="password"
            v-model="this.loginstate.Password"
          />
        </div>
        <div class="form-group">
          <button class="btn btn-primary btn-block" @click="login">
            <span>Login</span>
          </button>
          <button class="btn btn-primary btn-block" @click="signup">
            <span>SginUp</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script>
import { mapState } from "vuex";

export default {
    setup() {
        const loginname = ""
        return {
            loginname,
        }
    },
    computed: {
        ...mapState({
            loginstate: LoginState => LoginState
        }) 
    },
    methods: {
        login() {
            this.loginname = this.loginstate.memberItmes.filter(item => {
                return item.memberEmail === this.loginstate.Email
            })[0].memberName
            this.loginstate.Name = this.loginname
            this.$store.commit("login", this.loginstate);
            this.loginstate.pagestate = 0
            this.loginstate.Email = ""
            this.loginstate.Password = ""
            window.location.reload(true);
        },
        signup() {
            this.loginstate.pagestate = 2
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