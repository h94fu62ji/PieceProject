<script>
// import PostBoxView from '../../src/components/PostBox.vue'
// import PostBox2View from '../../src/components/PostBox2.vue'
// import PostView from '../../src/components/Post.vue'
export default {
  components: {
    // PostBoxView,
    // PostBox2View,
    // PostView,
  }
}

</script>

<template>
  <!-- 最外層的容器 -->
  <div class="container">
    <!-- 左邊的Header -->
    <header>
      <!-- //Logo -->
      <img class="logo" src="./../../public/img/logoWhite.png" alt="圖片載入失敗">
      <!-- 各個選單 -->
      <h2>主頁</h2>
      <h2>搜尋</h2>
      <h2>傳信</h2>
      <h2>消息</h2>
      <h3>設定</h3>
    </header>
    <!-- 右方的貼文區塊 -->
    <div class="main-aera">

      <!-- 插入貼文元件 -->
      <!-- <PostBoxView />
      <PostBox2View />
      <PostView /> -->
    </div>


  </div>
</template>

<style lang="scss" scoped>
// 最外層容器
.container {
  display: flex;
  margin-right: 5%;

  //左邊的Header
  header {
    position: sticky;
    top: 0%;
    background-image: linear-gradient(to bottom, #6EAC00, #9DCF45, #B6E16A, #DAFF9A);
    width: 400px;
    height: 100vh;
    margin-right: 5%;

    //Logo
    .logo {
      width: 25%;
      height: 13%;
      margin-top: 10%;
      margin-bottom: 25%;
      margin-left: 35%;
    }

    //Header裡面的主頁、搜尋、傳信、消息
    h2 {
      font-size: 4vh;
      color: white;
      text-align: right;
      position: relative;
      padding-right: 25%;
      cursor: pointer;

      &:hover {
        background-color: white;
        padding: 5%;
        margin-left: 10%;
        border-radius: 20px 0 0 20px;
        transition: all 0.6s;
        color: #4B9F54;
      }

    }

    //Header裡面的設定
    h3 {
      margin-top: 35%;
      font-size: 4vh;
      color: #4B9F54;
      text-align: right;
      position: relative;
      padding-right: 25%;
      cursor: pointer;

      &:hover {
        background-color: #4B9F54;
        padding: 5%;
        margin-left: 10%;
        border-radius: 20px, 0, 0, 20px;
        transition: all 0.6s;
        color: white;
      }

    }

  }

  //右方的貼文區塊

}
</style>
