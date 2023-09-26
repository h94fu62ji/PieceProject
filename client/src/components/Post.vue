<script>
//pinia
import { mapActions, mapState } from 'pinia'
import indexStore from '../stores/counter'
export default {
  data() {
    return {
      postImg: null,
    }
  },
  beforeMount() {
    this.getImgById(10000000)
  },
  computed: {
    // 參數 資料庫 要取用的 state / getters
    ...mapState(indexStore, ['URL']),
  },

  methods: {
    // 參數 資料庫 要取用的 actions(methods)
    ...mapActions(indexStore, []),
    // 判定關閉視窗位置
    closePost() {
      this.$parent.switchPost()
    },
    getImgById(imgId) { // 找圖片
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
  }
}
</script>

<template>
  <!-- 返回背景 -->
  <div class="screen" @click="closePost">
    <!-- 主體 -->
    <div class="w-[80%] h-[80%] bg-lime-200 rounded-3xl flex p-6" @click.stop>
      <!-- 照片 -->
      <div class="flex-grow h-[100%] bg-black rounded-2xl overflow-hidden">
        <img :src="postImg">
      </div>
      <!-- 貼文區 -->
      <div class="flex-grow-0 w-[350px] ml-6  rounded-2xl  overflow-hidden">
        <!-- 隱藏滾動條用 -->
        <div class="w-[365px] h-full overflow-y-auto overflow-x-hidden">
          <!-- 大頭區域 -->
          <div class="w-[350px] h-24 bg-white rounded-2xl mb-6">
            <div class="w-24 h-24 bg-cyan-100 rounded-2xl overflow-hidden">
              <img src="" class="w-24 h-24">
            </div>
          </div>
          <!-- 貼文本體 -->
          <div class="w-[350px] bg-[#D9D9D9] rounded-2xl mb-6">
            <div class=" w-full bg-[#6EAC00] rounded-2xl">
              <!-- 內文 -->
              <div class="w-full min-h-[1000px] bg-white rounded-2xl ">
                <p>{{ '內文' }}</p>
              </div>
              <!-- 功能區 -->
              <div class="w-full h-16 border">
                案讚功能
              </div>
            </div>
            <!-- 留言區 -->
            <div class="w-full">
              一堆留言
            </div>

          </div>

          <!-- 留言發送 -->
          <div class="w-[350px] h-24 bg-white rounded-2xl">

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