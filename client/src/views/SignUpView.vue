<script >
import axios from 'axios';

export default {

    name: "SignUp",

    methods: {
        // getData() {
        //     axios
        //         .get('http://localhost:8080/api')
        //         .then((response) => {
        //             console.log(response)
        //         })
        //         .catch((error) => {
        //             console.log(error)
        //         })
        // },
        save() {
            if (this.user.account == "") {
                console.log("請輸入帳號")
                this.active.account = true
                return
            } else {
                this.active.account = false
            }
            if (this.user.password == "") {
                console.log("請輸入密碼")
                this.active.password = true
                return
            } else {
                this.active.password = false
            }
            if (this.user.confirm == "") {
                console.log("請輸入密碼")
                this.active.confirm = true
                return
            } else {
                this.active.confirm = false
            }
            console.log(this.user)

            axios
                .put('http://localhost:8080/addInfo', this.user)
                .then((res) => {
                    console.log(res)
                    // this.$store.commit('註冊', res.data.user)

                    this.$router.push({ name: "login" })

                })
                .catch((err) => console.log(err))
        }
    },
    data() {
        return {
            user: {
                account: '',
                password: '',
                confirm: ''
            },
            active: {
                account: false,
                password: false,
                confirm: false
            }
        }

    },

}
</script>

<template>
    <div class="h-screen w-screen flex justify-center items-center">
        <!-- main -->
        <div class="z-10">
            <!-- LOGO -->
            <div class=" flex justify-center items-center">

                <img class="flex w-32 h-32" src="../../public/logo.png" alt="">

            </div>
            <!-- 口號 -->
            <p class=" mt-2 flex justify-center items-center text-[#5A7A22] tracking-[7px] text-[1px] font-semibold">成為我們的一塊
            </p>
            <!-- 輸入帳號 -->
            <div class="flex flex-col  items-center mt-2 ">

                <input
                    class="  focus:outline-[#90a073]  w-[500px] h-[40px] rounded-[5px] shadow-[inset_0px_1px_1px_rgba(0,0,0,0.3)] pl-[12px] "
                    type="text" placeholder="註冊帳號" :class="{ active: active.account }" v-model="user.account">
                <p class=" flex text-[#909090] text-[1px]  ml-[420px] mt-1">註冊帳號</p>
            </div>
            <!-- 輸入密碼 -->
            <div class="flex flex-col  items-center mt-2 ">

                <input
                    class=" focus:outline-[#90a073] w-[500px] h-[40px] rounded-[5px] shadow-[inset_0px_1px_1px_rgba(0,0,0,0.3)] pl-[12px] "
                    type="text" placeholder="輸入密碼" :class="{ active: active.password }" v-model="user.password">
                <p class=" flex text-[#909090] text-[1px]  ml-[420px] mt-1">輸入密碼</p>
            </div>

            <!-- 輸入密碼 -->
            <div class="flex flex-col  items-center mt-2 ">

                <input
                    class=" focus:outline-[#90a073] w-[500px] h-[40px] rounded-[5px] shadow-[inset_0px_1px_1px_rgba(0,0,0,0.3)] pl-[12px] "
                    type="text" placeholder="再次輸入密碼" :class="{ active: active.confirm }" v-model="user.confirm">
                <p class=" flex text-[#909090] text-[1px]  ml-[420px] mt-1">輸入密碼</p>
            </div>

            <!-- button -->
            <div class="hover:scale-105 flex flex-col  items-center mt-2 ">

                <button
                    class="flex justify-center items-center  w-40 h-9 mt-3 rounded-[5px] text-center text-white bg-gradient-to-r from-[#6EA627] to-[#96C659]  font-semibold "
                    type="button" @click="save">註　　冊</button>
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


.active {
    background-color: blanchedalmond;
}
</style>
