<script>
import Box from '../components/Box.vue'
import Masonry from "masonry-layout";

//pinia
import { mapActions, mapState } from 'pinia'
import indexStore from '../stores/counter'
export default {
  components: {
    Box,
  },
  beforeMount() {
    this.logincheck()

    // 載入貼文ID
    this.getPostList()
  },
  updated() {
    // 瀑布流設定
    let grid = document.querySelector('.grid');
    let msnry = new Masonry(grid, {
      // options...
      itemSelector: ".grid-item",
      transitionDuration: '0.4s',
      gutter: 40,
      columnWidth: 450,
    });
  },
  computed: {
    // 參數 資料庫 要取用的 state / getters
    ...mapState(indexStore, ['URL', 'postView', 'user', 'postIdList', 'login']),
  },
  methods: {
    // 參數 資料庫 要取用的 actions(methods)
    ...mapActions(indexStore, ['switchPost', 'pushList']),

    getPostList() {
      const getPostUser = {
        "userId": this.user,
      };
      // console.log(JSON.stringify(getPostUser))
      fetch(this.URL + "get_post_list", { // 發送網址
        method: "POST", // 請求型態
        headers: { // 必要文件 
          'Content-Type': 'application/json'
        },
        // 轉成JSON
        body: JSON.stringify(getPostUser) // 要傳送的資料
      })
        .then(res => res.json()) // 回傳資料轉成可讀取
        .then(data => {
          console.log(data);
          data.postList.forEach(item => {
            this.pushList(item)
          });
        })
        .catch(error => {
          console.error("Error:", error);
        });

    },
    // 重新布局方法
    rewrite() {
      let grid = document.querySelector('.grid');
      let msnry = new Masonry(grid, {
        // options...
        itemSelector: ".grid-item",
        gutter: 40,
        columnWidth: 450,
      });
      msnry.layout();
    },
    logincheck() {
      if (!this.login) {
        this.$router.push("/login");
      }
    },
  },
}

</script>


<template>
  <!-- 瀑布流用 -->
  <div class="grid ml-10 mt-6">
    <Box v-for="item in postIdList" class="grid-item" :postId="item" :id="item" @click=""></Box>
  </div>
</template>


<style scoped></style>