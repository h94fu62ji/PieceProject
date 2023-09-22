<script>
export default {
  methods: {
    // 判定關閉視窗位置
    closePost() {
      this.$parent.switchPost()
    }
  }
}
</script>

<template>
  <!-- 測試貼文模塊 -->
  <div class="screen" @click="closePost">
    <div class="box bg-lime-200 rounded-3xl" @click.stop></div>
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

.box {
  width: 1400px;
  height: 800px;
}
</style>