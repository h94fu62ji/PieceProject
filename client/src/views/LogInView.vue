<script>
import axios from 'axios';

//pinia
import { mapActions, mapState } from 'pinia'
import indexStore from '../stores/counter'

export default {

    name: "Login",
    data() {
        return {
            user: {
                account: '',
                pwd: ''
            }
        }

    },
    mounted() {
        if (this.login) {
            console.log("轉跳頁面")
            this.$router.push("/");
        }
    },
    computed: {
        // 參數 資料庫 要取用的 state / getters
        ...mapState(indexStore, ['URL', 'login']),
    },

    methods: {
        // 參數 資料庫 要取用的 actions(methods)
        ...mapActions(indexStore, ['changeUser']),
        getData() {
            axios
                .post(this.URL + 'test01', this.user)
                .then((res) => {
                    console.log(res.data)
                    if (res.status == 200) {
                        if (res.data.code == '200') {

                            localStorage.setItem('account', this.user.account);
                            localStorage.setItem('pwd', this.user.pwd);
                            alert('登入成功!');
                            this.changeUser(this.user.account)
                            this.$router.push("/");
                            console.log(res)

                        } else {
                            alert('登入失敗');

                        }
                    } else {
                        alert('其他神奇的錯誤');
                        return
                    }


                })
                .catch((error) => {
                    console.error(error);
                    alert('網路錯誤');
                });
        },
    },
    // mounted() {

    //     const savedAccount = localStorage.getItem('account');
    //     const savedPwd = localStorage.getItem('pwd');
    //     if (savedAccount && savedPwd) {
    //         this.user.account = savedAccount;
    //         this.user.pwd = savedPwd;
    //     }
    // },

}

</script>

<template>
    <div class="h-screen w-screen flex justify-center items-center">

        <!-- main -->
        <div class="z-10">
            <!-- LOGO -->
            <div class="flex justify-center items-center">

                <img class="flex w-32 h-32" src="../../public/logo.png" alt="">

            </div>
            <!-- 口號 -->
            <p class=" mt-2 flex justify-center items-center text-[#5A7A22] tracking-[7px] text-[1px] font-semibold">成為我們的一塊
            </p>

            <!-- 輸入帳號 -->
            <div class="flex flex-col  items-center mt-2 " :model="user">
                <div prop="username">
                    <input
                        class="focus:outline-[#90a073]   w-[500px] h-[40px] rounded-[5px] shadow-[inset_0px_1px_1px_rgba(0,0,0,0.3)] pl-[6px] "
                        type="text" placeholder=" 輸入帳號" v-model="user.account" v-on:keyup.enter="getData">
                </div>
                <p class=" flex text-[#909090] text-[1px]  ml-[420px] mt-1">輸入帳號</p>
            </div>

            <!-- 輸入密碼 -->
            <div class="flex flex-col  items-center mt-2 ">
                <div prop="password">
                    <input
                        class=" focus:outline-[#90a073] w-[500px] h-[40px] rounded-[5px] shadow-[inset_0px_1px_1px_rgba(0,0,0,0.3)] pl-[6px] "
                        type="password" placeholder="輸入密碼" v-model="user.pwd" v-on:keyup.enter="getData">

                </div>

                <div class="flex mt-1 ">
                    <router-link to="/signup"
                        class=" fixed text-[#90a073] text-[1px] ml-[365px]  cursor-pointer ">我要註冊</router-link>
                    <!-- <div class=" fixed text-[#90a073] text-[1px] ml-[365px]  cursor-pointer">
                        我要註冊
                    </div> -->
                    <router-link to="/pwdforgot"
                        class="  text-[#909090] text-[1px]  ml-[420px] cursor-pointer ">忘記密碼</router-link>
                    <!-- <div class="  text-[#909090] text-[1px]  ml-[420px] cursor-pointer">
                        忘記密碼
                    </div> -->



                </div>


            </div>

            <!-- button -->
            <div class=" flex flex-col  items-center mt-2 ">

                <button
                    class="hover:scale-105  flex justify-center items-center  w-40 h-9 mt-3 rounded-[5px] text-center text-white bg-gradient-to-r from-[#6EA627] to-[#96C659]  font-semibold "
                    type="button" @click="getData">登　　入</button>
            </div>

        </div>

        <!-- 背景 -->
        <div class="backk absolute top-0 left-0">
        </div>
    </div>
</template>

<style lang="scss" scoped>
.backk {
    background: (linear-gradient(125deg, rgba(#5A8C00, .5) 20%, transparent 100%), linear-gradient(-125deg, rgba(#54F9EF, .5), transparent 40%));
    width: 100vw;
    height: 100vh;

}
</style>
