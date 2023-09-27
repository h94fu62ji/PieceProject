<script>
//pinia
import { mapActions, mapState } from 'pinia'
import indexStore from '../stores/counter'
export default {
    data() {
        return {
            text: null,
            img: null,
            isText: false,
            isImg: false,
        }
    },
    inject: ['reload'],
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
                    this.pushListToFirst(data.postId)
                })
                .catch(error => {
                    console.error("Error:", error);
                });
        },
        checkNewPost() {
            this.isText = false; this.isImg = false;
            if (this.text === null || this.text === "") {
                this.isText = true;
            }
            if (this.img === null) {
                this.isImg = true;
            }
            if (this.text === null || this.text === "" || this.img === null) {
                return;
            }
            this.closeNewPost()
            this.updateNewPost()
            this.reload()
            alert('新增成功')
        }
    }
}
</script>

<template>
    <!-- 主外框 -->
    <div class="screen" @click="closeNewPost">
        <div class="bg-lime-200 rounded-3xl max-h-[100vh]" @click.stop>
            <div class="m-6 w-[400px]">
                <h1 class="text-2xl">新增貼文</h1>
                <div class="w-full h-6">
                    <p v-show="isText" class="text-sm pl-2 pt-1 text-red-500 ">請輸入內文</p>
                </div>
                <textarea class="w-full h-[300px] rounded-2xl p-2"
                    style="display: block; resize: none; outline: none; border : 0;" v-model="text"></textarea>
                <div class="w-full h-6">
                    <p v-show="isImg" class="text-sm pl-2 pt-1 text-red-500">請上傳圖片</p>
                </div>
                <label for="newfile">
                    <div class="cursor-pointer w-full color1 rounded-2xl overflow-hidden"
                        style="min-height: 50px; background-repeat:no-repeat; display: flex; justify-content: center;">
                        <img :src="img">
                        <p class="pt-3 text-white">上傳圖片</p>
                    </div>
                </label>
                <input id="newfile" type="file" @change="updateImg" class="hidden">
                <button type="button" class="w-full h-12 hover:bg-slate-400 bg-white block mx-auto mt-6 rounded-2xl"
                    @click="checkNewPost()">發 布</button>
            </div>
        </div>
    </div>
</template>


<style scoped>
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