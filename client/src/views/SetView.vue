<script>
//pinia
import { mapActions, mapState } from 'pinia'
import indexStore from '../stores/counter'
import Mesg from '../components/Mesg.vue'

export default {
    components: {
        Mesg,
    },
    data() {
        return {
            userName: null,
            introduce: null,
            birthday: null,
            address: null,
            sex: null,
            mesg: "",
            mesgView: false,
        }
    },
    mounted() {
        this.getUserDataByIdForUser(this.user)
    },
    computed: {
        // 參數 資料庫 要取用的 state / getters
        ...mapState(indexStore, ['URL', 'user']),
    },
    methods: {
        // 參數 資料庫 要取用的 actions(methods)
        ...mapActions(indexStore, []),
        getUserDataByIdForUser(id) { // 找User
            const getUserId = {
                "id": id,
            };
            // console.log(JSON.stringify(getImgId))
            fetch(this.URL + "get_user_data", { // 發送網址
                method: "POST", // 請求型態
                headers: { // 必要文件
                    'Content-Type': 'application/json'
                },
                // 轉成JSON
                body: JSON.stringify(getUserId) // 要傳送的資料
            })
                .then(res => res.json()) // 回傳資料轉成可讀取
                .then(data => {
                    // console.log(data)
                    this.userName = data.userData.userName
                    this.introduce = data.userData.introduce
                    this.birthday = data.userData.birthday
                    this.address = data.userData.address
                    this.sex = data.userData.sex

                })
                .catch(error => {
                    console.error("Error:", error)
                });
        },
        updateInfo() { // 更新資料
            const update = {
                "account": this.user,
                "userName": this.userName,
                "birthday": this.birthday,
                "address": this.address,
                "introduce": this.introduce,
                "sex": this.sex
            };
            // console.log(JSON.stringify(update))
            fetch(this.URL + "update_user_data", { // 發送網址
                method: "POST", // 請求型態
                headers: { // 必要文件
                    'Content-Type': 'application/json'
                },
                // 轉成JSON
                body: JSON.stringify(update) // 要傳送的資料
            })
                .then(res => res.json()) // 回傳資料轉成可讀取
                .then(data => {
                    // console.log(data)
                    if (data.code == 200) {
                        this.mesg = "更新成功"
                        this.switchMesg()
                    } else {
                        this.mesg = "更新失敗"
                        this.switchMesg()
                    }
                })
                .catch(error => {
                    console.error("Error:", error)
                });
        },
        switchMesg() {
            this.mesgView = !this.mesgView
        }




    }
}
</script>
<template>
    <div class="h-[100vh]  flex justify-center items-center">
        <div class="h-[80%] w-[80%] bg-[#C9FF84] rounded-2xl p-10 flex justify-center items-center">
            <div class="w-[80%]">
                <h1>暱稱</h1>
                <input type="text" v-model="userName">
                <h1>自介</h1>
                <textarea v-model="introduce"></textarea>
                <h1>生日</h1>
                <input type="date" v-model="birthday">
                <h1>地址</h1>
                <input type="text" v-model="address">
                <h1>性別</h1>
                <input type="text" v-model="sex">
                <button type="button"
                    class="w-80 h-16 bg-white block mx-auto mt-12 rounded-2xl text-2xl hover:bg-green-700 hover:text-white hover:transition"
                    @click="updateInfo">更
                    新</button>
            </div>
        </div>
        <Mesg v-if="mesgView" :mesg="mesg" />
    </div>
</template>
<style scoped>
input,
textarea {
    display: block;
    width: 100%;
    height: 50px;
    resize: none;
    outline: none;
    font-size: 24px;
    padding: 6px 20px 0 20px;
    border-radius: 16px;


}

h1 {
    font-size: 32px;
    margin-top: 20px;
}
</style>