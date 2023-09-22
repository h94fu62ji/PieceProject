<script>
export default {
    data() {
        return {
            items: [1, 2, 3, 4, 5],

        }
    },
    methods: {
        closePerson() {
            this.$parent.switchPerson()
        },
        openSetBar() {
            this.$parent.switchSetBar()
        },
    },

}
</script>

<template>
    <!-- 隱藏滾動條用 -->
    <div class="fixed h-screen w-400 overflow-hidden top-0 left-0">
        <!-- 背景 -->
        <div class="absolute h-full w-400 bgc overflow-y-auto top-0 left-0" style="width: 415px;">
            <!-- 至中用 -->
            <div class="w80 ml-10">
                <!-- 上方功能區 -->
                <div class="w-80 h-16 my-6 flex justify-between">
                    <div class="w-16 h-16 bg-white cursor-pointer" @click="closePerson"></div>
                    <div class="w-16 h-16 bg-white cursor-pointer" @click="openSetBar"></div>
                </div>
                <!-- 大頭貼 -->
                <div class="bg-white w-80 h-80  my-6 rounded-3xl "></div>
                <!-- 名稱 -->
                <div class="w-80  my-4">
                    <h3 class="text-4xl font-bold text-end pr-1">{{ "UserName" }}</h3>
                </div>
                <!-- 自介 -->
                <div class="w-80  my-4">
                    <h1 class="text-2xl font-bold text-end pr-1">{{ "我是一個沒有裝飾的蛋糕" }}</h1>
                </div>
                <!-- 追蹤模塊 -->
                <div class="w-80  my-6 flex justify-around">
                    <div>
                        <p class="text-xl font-bold text-white cursor-pointer">追蹤中 {{ 30 }}</p>
                    </div>
                    <div>
                        <p class="text-xl font-bold text-white cursor-pointer">追蹤中 {{ 274 }}</p>
                    </div>
                </div>
                <!-- 追蹤按紐 -->
                <!-- <button type="button" class="w-40 h-16 ml-20 my-6 bg-green-700 block rounded-2xl text-white text-2xl">追 蹤</button> -->

                <!-- 基本資料區 -->
                <div class="my-4">
                    <div v-for="item in items" class="bg-white w-80 h-16  my-2 rounded-2xl flex">
                        <div class="bg-yellow-200 w-32 h-16 rounded-2xl ">
                            <h3 class="text-2xl font-bold text-center pt-4 ">{{ "生 日" }}</h3>
                        </div>
                        <div class="flex-grow h-16 rounded-2xl">
                            <p class="text-2xl font-bold text-center pt-4 ">{{ 870829 }}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<style lang="scss" scoped></style>