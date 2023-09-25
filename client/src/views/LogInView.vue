<script>
import axios from 'axios';
// import { getDefaultFlags } from 'mysql/lib/ConnectionConfig';

export default {

    name: "Login",

    methods: {
        getData() {
            axios
                .post('http://localhost:8080/test01', { maxRedirects: 0, })
                .then((response) => {
                    console.log(response)

                })
                .catch((error) => {
                    console.log(error)
                })
        },
        keymonitor: function (event) {
            if (event.key == 'Enter') {
                checklogin();
                // alert('登入成功~')
            } else {
                alert('你失敗了!')
            }
        },
        checklogin: function () { },
    },
    data() {
        return {
            user: {
                account: '',
                password: ''
            }
        }

    },
    created() {
        this.getData()
    }
    //=====================================
    // data() {
    //     return {
    //         user: {
    //             account: '',
    //             password: ''
    //         },
    //         rules: {
    //             account: [{
    //                 required: true,
    //                 message: '請輸入帳號'
    //                 // trigger:'blur'
    //             }],
    //             password: [{
    //                 required: true,
    //                 message: '請輸入密碼'
    //                 // trigger:'blur'
    //             }]
    //         }
    //     }

    // },
    // methods: {
    //     submitForm(formName) {
    //         console.log(this.$data.user.account);
    //         console.log(this.$data.user.password);
    //         let _this = this;
    //         this.$axios({
    //             method: 'post',
    //             url: 'http://localhost:8080/test01',
    //             data: _this.$data.user
    //         }).then(res => {
    //             console.log(res)
    //             // console.log(res.data.success)
    //             // console.log(res.data.ueser)
    //             if (res.data.success == 'true') {
    //                 alert('登入成功')
    //             }
    //         }).catch(error => {
    //             _this.message({
    //                 message: '錯誤，請重試',
    //                 type: "warning"
    //             })

    //         })
    //     }

    // }
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
                        type="text" placeholder=" 輸入帳號" v-model="user.account" v-on:keyup="keymonitor">
                </div>
                <p class=" flex text-[#909090] text-[1px]  ml-[420px] mt-1">輸入帳號</p>
            </div>

            <!-- 輸入密碼 -->
            <div class="flex flex-col  items-center mt-2 ">
                <div prop="password">
                    <input
                        class=" focus:outline-[#90a073] w-[500px] h-[40px] rounded-[5px] shadow-[inset_0px_1px_1px_rgba(0,0,0,0.3)] pl-[6px] "
                        type="password" placeholder="輸入密碼" v-model="user.password" v-on:keyup="keymonitor">

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
