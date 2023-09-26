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
  <!-- 返回背景 -->
  <div class="screen" @click="closePost">
    <!-- 主體 -->
    <div class="w-[80%] h-[80%] bg-lime-200 rounded-3xl flex p-6" @click.stop>
      <!-- 照片 -->
      <div class="flex-grow h-[100%] bg-black rounded-2xl overflow-hidden">
        <img src="">
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