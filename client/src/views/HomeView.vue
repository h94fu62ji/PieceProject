<script>
import Box from '../components/Box.vue'
import Masonry from "masonry-layout";

//pinia
import { mapActions, mapState } from 'pinia'
import indexStore from '../stores/counter'
export default {
  data() {
    return {
    }
  },
  components: {
    Box,
  },
  beforeMount() {
    // 載入貼文ID
    this.getPostList(this.user)
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
  watchEffect: {

  },
  computed: {
    // 參數 資料庫 要取用的 state / getters
    ...mapState(indexStore, ['URL', 'postView', 'user', 'postIdList']),
  },
  methods: {
    // 參數 資料庫 要取用的 actions(methods)
    ...mapActions(indexStore, ['switchPost', 'pushList', 'changeId']),

    getPostList(user) {
      const getPostUser = {
        "id": user,
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

    consolelog(id) {
      this.$emit('getPostId', id)
    }
  },
}

</script>


<template>
  <!-- 瀑布流用 -->
  <div class="grid ml-10 mt-6">
    <Box v-for="(item, index) in postIdList" class="grid-item" :postId="item" :key="index" @click="consolelog(item)">
    </Box>
  </div>
</template>


<style scoped></style>