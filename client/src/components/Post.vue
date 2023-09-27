<script>
//pinia
import { mapActions, mapState } from 'pinia'
import indexStore from '../stores/counter'

import PostMesg from './PostMesg.vue'

export default {
  components: {
    PostMesg
  },
  props: ['postId'],
  inject: ['reload'],
  data() {
    return {



      //單純判斷有沒有按過讚(回傳1是有，回傳0是沒按過讚)
      likeYesOrNo: null,
      //按讚貼文及收回讚的顯示顏色
      isNiceClick: false,
      //貼文資訊
      postList: [],
      //發文者的資訊
      userInfoList: [],
      //發文者名字
      userName: "正在載入中...",
      //發文者Id
      userId: null,
      //傳入按讚人Req
      likePostUserInfo: { "PostId": null, "UserId": null },
      userId: null,
      userImg: null,
      postImg: null,
      text: '正在載入中...',
      up: 0,
      time: null,
      fans: 0,

    }
  },
  mounted() {
    this.getPostById(this.postId)
  },
  beforeUpdate() {
    this.getPostById(this.postId)
  },
  computed: {
    // 參數 資料庫 要取用的 state / getters
    ...mapState(indexStore, ['URL']),
  },

  methods: {
    // 參數 資料庫 要取用的 actions(methods)
    ...mapActions(indexStore, ['switchPost', 'rePostIdList']),
    // 判定關閉視窗位置
    closePost() {
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
          this.userId = data.gpbiv.senderId
          // this.postImgId = data.gpbiv.postImg
          this.getUserData(data.gpbiv.senderId)
          this.getImgByIdForUser(data.gpbiv.userImg)
          this.getImgByIdForPost(data.gpbiv.postImg)
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
    getImgByIdForPost(imgId) { // 找圖片
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
    getUserData(id) { // 找User資料
      const getUser = {
        "id": id,
      };
      // console.log(JSON.stringify(getUser))
      fetch(this.URL + "get_user_data", { // 發送網址
        method: "POST", // 請求型態
        headers: { // 必要文件
          'Content-Type': 'application/json'
        },
        // 轉成JSON
        body: JSON.stringify(getUser) // 要傳送的資料
      })
        .then(res => res.json()) // 回傳資料轉成可讀取
        .then(data => {
          // console.log(data);
          this.userName = data.userData.userName

        })
        .catch(error => {
          console.error("Error:", error);
        });
    },

    goPerson() {
      this.$parent.homeBarClose()
      this.switchPost()
      if (this.userId != this.$route.query.userId) {
        this.rePostIdList()
        this.$router.push(`?userId=${this.userId}`)
      }
    },



  }
}
</script>

<template>
  <!-- 返回背景 -->
  <div class="screen" @click="closePost">
    <!-- 主體 -->
    <div class="w-[80%] h-[80%] bg-lime-200 rounded-3xl p-6" @click.stop>
      <div class="w-full h-full flex">
        <!-- 照片 -->
        <div class="flex-grow h-full bg-black rounded-2xl overflow-hidden">
          <img :src="postImg">
        </div>
        <!-- 貼文區 -->
        <div class="flex-shrink-0 w-6 h-full"></div>
        <div class="flex-shrink-0 w-[350px] rounded-2xl overflow-hidden">
          <!-- 隱藏滾動條用 -->
          <div class="w-[365px] h-full overflow-y-auto overflow-x-hidden">
            <!-- 大頭區域 -->
            <div class="w-[350px] h-24 bg-white rounded-2xl mb-6 flex cursor-pointer" @click="goPerson">
              <div class="w-24 h-24 bg-cyan-100 rounded-2xl overflow-hidden">
                <img :src="userImg" class="w-24 h-24">
              </div>
              <div>
                <h2 class="text-2xl pt-4 pl-2">{{ userName }}</h2>
                <h2 class="pt-2 pl-2">粉絲數 {{ fans }} 人</h2>
              </div>

            </div>
            <!-- 貼文本體 -->
            <div class="w-[350px] bg-[#D9D9D9] rounded-2xl mb-6">
              <div class=" w-full bg-[#6EAC00] rounded-2xl">
                <!-- 內文 -->
                <div class="w-full min-h-[300px] bg-white rounded-2xl p-2 flex flex-col justify-between">
                  <p>{{ text }}</p>
                  <div class="w-full mt-10 flex justify-between">
                    <p>{{ up }} 個按讚數</p>
                    <p>{{ time }}</p>
                  </div>
                </div>
                <!-- 功能區 -->
                <div class="w-full h-16">
                  案讚功能
                </div>
              </div>
              <!-- 留言區 -->
              <div class="w-full p-2">
                <PostMesg></PostMesg>
              </div>

            </div>

            <!-- 留言發送 -->
            <div class="w-[350px] h-24 bg-white rounded-2xl">

            </div>
          </div>
        </div>
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

img {
  object-fit: contain;
  width: 100%;
  height: 100%;
}
</style>