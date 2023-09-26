<script>
import imagesloaded from 'imagesloaded'
//pinia
import { mapActions, mapState } from 'pinia'
import indexStore from '../stores/counter'
export default {
  props: ["postId"],
  data() {
    return {
      text: "正在載入中...",
      up: 0,
      postImg: null,
      userImg: null,
      time: null,
    }
  },
  directives: {
    imagesloaded
  },
  beforeMount() {
    this.getPostById()

  },
  updated() {
    imagesloaded('img', () => { // 圖片加載確認
      this.$parent.rewrite()
    });
  },
  computed: {
    // 參數 資料庫 要取用的 state / getters
    ...mapState(indexStore, ['URL']),
  },
  methods: {
    // 參數 資料庫 要取用的 actions(methods)
    ...mapActions(indexStore, ['switchPost']),

    openPost(e) {
      this.$parent.switchPost()
    },

    getPostById() {  // 找貼文
      const getPostId = {
        "id": this.postId,
      };
      // console.log(JSON.stringify(newPost))
      fetch(this.URL + "get_post_by_post_id", { // 發送網址
        method: "POST", // 請求型態
        headers: { // 必要文件
          'Content-Type': 'application/json'
        },
        // 轉成JSON
        body: JSON.stringify(getPostId) // 要傳送的資料
      })
        .then(res => res.json()) // 回傳資料轉成可讀取
        .then(data => {
          // console.log(data);
          this.text = data.gpbiv.text
          this.up = data.gpbiv.up
          this.time = data.gpbiv.time.replace("T", "\t")
          // this.postImgId = data.gpbiv.postImg
          this.getImgByIdForUser(data.gpbiv.userImg)
          this.getImgByIdForPost(data.gpbiv.postImg)
        })
        .catch(error => {
          console.error("Error:", error);
        });
    },


    getImgByIdForPost(imgId) { // 找圖片Post
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
          this.postImg = data.img64
        })
        .catch(error => {
          console.error("Error:", error);
        });
    },


    getImgByIdForUser(imgId) { // 找圖片User
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
          console.error("Error:", error);
        });
    },
  },
}
</script>

<template>
  <!-- 貼文外框 -->
  <div class="bg-lime-300 rounded-3xl relative overflow-hidden outsideBox shadow-2xl shadow-gray-700"
    style="width: 450px;margin-bottom: 50px;">
    <!-- 貼文內框 -->
    <div class="mx-auto my-3" style="width: 430px; overflow:hidden;">
      <!-- 圖片區 -->
      <img :src="postImg" class="rounded-2xl" style="width: 430px;">
      <!-- 資訊區 -->
      <div class="mx-auto flex justify-center pt-2" style="width: 430px;">
        <!-- 頭貼 -->
        <img :src="userImg" class="rounded-lg block" style="width: 60px;height: 60px;">
        <!-- 內文區 -->
        <div class="" style="width: 330px;  height: 60px;">
          <!-- 內文 -->
          <div class=" mx-auto text-xl pt-4 text-center"
            style="width: 80%; height: 60px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
            {{ text }}</div>
        </div>
      </div>
    </div>
    <!-- 反黑 -->
    <div class="show bg-gray-700 opacity-80 absolute top-0 left-0 z-0 hidden" style="width: 450px; height: 100%;"
      @click="openPost()">
      <div>

        <p class="absolute bottom-24 left-6 text-white font-bold select-none">按讚人數 {{ up }}</p>
        <p class="absolute bottom-24 right-6 text-white font-bold select-none">{{ time }}</p>

      </div>


      <div class="btn w-16 h-16 rounded-full bg-white absolute top-6 right-4 z-10 select-none" @click.stop @click="">按讚
      </div>
      <div class="btn w-16 h-16 rounded-full bg-white absolute top-6 right-24 z-10 select-none" @click.stop>儲存</div>
      <div class="btn w-16 h-16 rounded-full bg-white absolute top-6 right-44 z-10 select-none" @click.stop>分享</div>
    </div>
  </div>
</template>


<style lang="scss" scoped>
.outsideBox {
  &:hover {
    .show {
      display: block;
    }
  }
}

.btn {
  text-align: center;
  padding-top: 20px;
  cursor: pointer;

  &:hover {
    background-color: wheat;
    transition: 0.3s;

  }
}
</style>