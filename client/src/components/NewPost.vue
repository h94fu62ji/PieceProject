<script>
//pinia
import { mapActions, mapState } from 'pinia'
import indexStore from '../stores/counter'
export default {
    data() {
        return {
            text: null,
            img: null,
        }
    },
    computed: {
        // 參數 資料庫 要取用的 state / getters
        ...mapState(indexStore, ['URL', 'user']),
    },
    methods: {
        ...mapActions(indexStore, ['pushListToFirst']),
        // 判定關閉視窗位置
        closeNewPost() {
            this.$parent.switchNewPost()
        },
        // 上傳圖片
        updateImg(e) {

            let file = e.target.files[0]
            let reader = new FileReader()
            reader.readAsDataURL(file)
            reader.onload = (e) => {
                console.log(e.target.result)
                this.img = e.target.result
            }
        },
        updateNewPost() {
            const newPost = {
                "id": this.user,
                "text": this.text,
                "img": this.img
            };
            // console.log(JSON.stringify(newPost))
            fetch(this.URL + "new_post", { // 發送網址
                method: "POST", // 請求型態
                headers: { // 必要文件
                    'Content-Type': 'application/json'
                },
                // 轉成JSON
                body: JSON.stringify(newPost) // 要傳送的資料
            })
                .then(res => res.json()) // 回傳資料轉成可讀取
                .then(data => {
                    console.log(data);
                })
                .catch(error => {
                    console.error("Error:", error);
                });
        }
    }
}
</script>

<template>
    <!-- 主外框 -->
    <div class="screen" @click="closeNewPost">
        <div class="bg-lime-200 rounded-3xl" @click.stop>
            <div class="m-10">
                <h1 class="text-2xl">新增貼文</h1>
                <textarea class="w-96 my-8"
                    style="min-height: 100px; max-height: 500px; height: auto; display: block; resize: none; outline: none; border : 0;"
                    v-model="text"></textarea>
                <label for="newfile">
                    <div class="cursor-pointer w-96 color1 rounded-2xl overflow-hidden"
                        style="min-height: 50px; background-repeat:no-repeat; display: flex; justify-content: center;">
                        <img :src="img" alt="">
                    </div>
                </label>
                <input id="newfile" type="file" @change="updateImg" class="hidden">
                <!-- <img :src="img" alt="NO"> -->
                <button type="button" class="w-40 h-12 hover:bg-slate-400 bg-white block mx-auto mt-8 rounded-xl"
                    @click="closeNewPost(), updateNewPost()">發布</button>
                <!-- <p>{{ text }}</p> -->
            </div>
        </div>
    </div>
</template>


<style scoped>
textarea {
    height: auto;
    min-height: 100px;
    max-height: 500px;
}

.screen {
    position: fixed;
    width: 100vw;
    height: 100vh;
    background-color: rgba(75, 75, 75, 0.7);
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>