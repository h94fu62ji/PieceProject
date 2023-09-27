<script>
//pinia
import { mapActions, mapState } from 'pinia'
import indexStore from '../stores/counter'
export default {

    props: ['userId'],
    data() {
        return {
            items: [1, 2, 3, 4, 5],
            userImg: null,
            userName: "載入中...",
            introduce: "載入中...",

            Userdata: {
                birthday: "載入中...",
                address: "載入中...",
                sex: "載入中...",

            },

            haveTrack: false,
            track: 0,
            fans: 0,
        }
    },
    mounted() {
        this.checkUser()
    },

    computed: {
        // 參數 資料庫 要取用的 state / getters
        ...mapState(indexStore, ['URL']),
    },
    methods: {
        // 參數 資料庫 要取用的 actions(methods)
        ...mapActions(indexStore, []),
        openHomeBar() {
            this.$parent.switchHomeBar()
        },
        openSetBar() {
            this.$parent.switchSetBar()
        },

        getUserDataByIdForUser(userId) { // 找User
            const getUserId = {
                "id": userId,
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
                    this.getImgById(data.userData.picId)
                    this.userName = data.userData.userName
                    this.introduce = data.userData.introduce
                    this.Userdata.birthday = data.userData.birthday
                    this.Userdata.address = data.userData.address
                    this.Userdata.sex = data.userData.sex

                })
                .catch(error => {
                    console.error("Error:", error)
                });
        },
        getImgById(imgId) { // 找圖片User
            const getImgId = {
                "id": imgId,
            };
            // console.log(JSON.stringify(getImgId))
            fetch(this.URL + "get_pic_by_img_id", { // 發送網址
                method: "POST", // 請求型態
                headers: { // 必要文件
                    'Content-Type': 'application/json'
                },
                // 轉成JSON
                body: JSON.stringify(getImgId) // 要傳送的資料
            })
                .then(res => res.json()) // 回傳資料轉成可讀取
                .then(data => {
                    // console.log(data);
                    this.userImg = data.img64
                })
                .catch(error => {
                    console.error("Error:", error)
                });

        },
        getTrack(Id) { // 求追蹤人數
            const getById = {
                "id": Id,
            };
            // console.log(JSON.stringify(getById))
            fetch(this.URL + "get_track", { // 發送網址
                method: "POST", // 請求型態
                headers: { // 必要文件
                    'Content-Type': 'application/json'
                },
                // 轉成JSON
                body: JSON.stringify(getById) // 要傳送的資料
            })
                .then(res => res.json()) // 回傳資料轉成可讀取
                .then(data => {
                    // console.log(data)
                    this.track = data.track
                    this.fans = data.fans

                })
                .catch(error => {
                    console.error("Error:", error)
                });

        },
        checkUser() {
            if (this.$route.query.userId == undefined) {
                this.getUserDataByIdForUser(this.userId)
                this.getTrack(this.userId)
            } else {
                this.getUserDataByIdForUser(this.$route.query.userId)
                this.getTrack(this.$route.query.userId)
                if (this.$route.query.userId != this.userId) {
                    this.haveTrack = true
                }
            }
        },
        goSet() {
            this.$router.push("set")
            this.$parent.homeBarClose()
        },
    }
}
</script>

<template>
    <!-- 隱藏滾動條用 -->
    <div class="fixed h-screen w-400 overflow-hidden top-0 left-0">
        <!-- 背景 -->
        <div class="absolute h-full w-400 bgc overflow-y-auto top-0 left-0" style="width: 415px;">
            <!-- 至中用 -->
            <div class="ml-10">
                <!-- 上方功能區 -->
                <div class="w-80 h-16 my-6 flex justify-between">
                    <div class="w-16 h-16 bg-white cursor-pointer" @click="openHomeBar"></div>
                    <div class="w-16 h-16 bg-white cursor-pointer" @click="goSet"></div>
                </div>
                <!-- 大頭貼 -->
                <div class="bg-white w-80 my-6 rounded-3xl overflow-hidden">
                    <img :src="userImg" class="w-80">
                </div>
                <!-- 名稱 -->
                <div class="w-80  my-4">
                    <h3 class="text-4xl font-bold text-end pr-1">{{ userName }}</h3>
                </div>
                <!-- 自介 -->
                <div class="w-80  my-4">
                    <h1 class="text-2xl font-bold text-end pr-1">{{ introduce }}</h1>
                </div>
                <!-- 追蹤模塊 -->
                <div class="w-80  my-6 flex justify-around">
                    <div>
                        <p class="text-xl font-bold text-white cursor-pointer">追蹤中 {{ track }}</p>
                    </div>
                    <div>
                        <p class="text-xl font-bold text-white cursor-pointer">粉絲 {{ fans }}</p>
                    </div>
                </div>
                <!-- 追蹤按紐 -->
                <div v-if="haveTrack">
                    <button v-if="condition" type="button"
                        class="w-40 h-16 ml-20 my-6 bg-green-700 block rounded-2xl text-white text-2xl">追
                        蹤</button>
                    <button v-else type="button"
                        class="w-40 h-16 ml-20 my-6 bg-green-700 block rounded-2xl text-white text-2xl">已 追 蹤</button>
                </div>

                <!-- 基本資料區 -->
                <div class="my-4">
                    <div v-for="(item, index) in Userdata" class="bg-white w-80 h-16  my-2 rounded-2xl flex">
                        <div class="bg-yellow-200 w-32 h-16 rounded-2xl ">
                            <h3 class="text-2xl font-bold text-center pt-4 ">{{ index }}</h3>
                        </div>
                        <div class="flex-grow h-16 rounded-2xl">
                            <p class="text-2xl font-bold text-center pt-4 ">{{ item == null ? '尚未設定' : item }}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<style lang="scss" scoped></style>