<script>
import { RouterLink, RouterView } from 'vue-router'

//pinia
import { mapActions, mapState } from 'pinia'
import indexStore from '../stores/counter'
export default {
    components: {
        RouterLink,
    },
    data() {
        return {
            logoImg: null,
        }
    },
    beforeMount() {
        this.getImgByIdForUser(100)
    },
    computed: {
        // 參數 資料庫 要取用的 state / getters
        ...mapState(indexStore, ['URL']),
    },
    methods: {


        PersonBar() {
            this.$parent.switchPerson()
        },
        SearchBar() {
            this.$parent.switchSearchBar()
        },
        ChatList() {
            this.$parent.switchChatList()
        },
        NewsBar() {
            this.$parent.switchNewsBar()
        },




        getImgByIdForUser(imgId) { // 找圖片User
            const getImgId = {
                "imgId": imgId,
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
                    this.logoImg = data.img64
                })
                .catch(error => {
                    console.error("Error:", error);
                });
        },
    }
}
</script>

<template>
    <div class="fixed h-screen bgc w-400 flex flex-col justify-around items-center">
        <RouterLink to="/" class="w-400 h-40 mt-10 absolute top-0 left-0 cursor-pointer">
            <img :src="logoImg" class="w-40 block mx-auto">
        </RouterLink>
        <!-- <div class="fake!!"></div> -->
        <div class="mx-auto w-400">
            <div class="btn" @click="PersonBar">個人頁面</div>
            <div class="btn" @click="SearchBar">搜尋</div>
            <div class="btn" @click="ChatList">訊息</div>
            <div class="btn" @click="NewsBar">消息</div>
        </div>
        <!-- <div class="mx-auto w-400">
            <div class="btn">設定</div>
        </div> -->
    </div>
</template>

<style lang="scss" scoped>
.btn {
    font-size: 2.5rem;
    color: white;
    text-align: right;
    position: relative;
    padding-right: 30%;
    border-radius: 20px 0 0 20px;
    margin-left: -30%;
    cursor: pointer;

    &:hover {
        background-color: white;
        padding: 20px 10% 20px 0;
        margin-left: 20%;
        border-radius: 20px 0 0 20px;
        transition: all 0.6s;
        color: #6eac00;
    }
}
</style>