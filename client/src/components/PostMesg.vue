<script>
export default {
    props: [],
    data() {
        return {
            isShow: false,
            text: "123456789012345678901234567890123456789012345678901234567890",
            time: "2023",
            up: 200,
        }
    },
    methods: {
        switchIsShow() {
            this.isShow = !this.isShow
        }
    }
}
</script>


<template>
    <!-- 外框 -->
    <div class="w-[350px] mx-2 flex">
        <!--留言者頭貼框 -->
        <div class="w-16 h-16 bg-cyan-200 rounded-xl overflow-hidden">
            <!-- 留言者的頭貼 -->
            <img src="" alt="">
        </div>
        <!-- 留言者資訊區 -->
        <div class="w-[250px] px-2 overflow-hidden">
            <p class="font-bold">{{ "name" }}</p>
            <p :class="{ hideText: !isShow, showText: isShow }">{{ text }}</p>
            <p v-if="!isShow" class="text-sm text-[#6eac00] cursor-pointer" @click="switchIsShow">...閱讀更多</p>
            <p v-if="isShow" class="text-sm text-[#6eac00] cursor-pointer" @click="switchIsShow">...縮短</p>
            <p class="text-xs inline">{{ time }}</p>
            <p class="text-sm inline cursor-pointer ml-10 ">讚</p>
            <p class="text-xs inline pl-1">{{ up }}</p>
        </div>
    </div>
</template>


<style scoped>
.hideText {
    text-overflow: ellipsis;
    overflow: hidden;
}

.showText {
    word-wrap: break-word;
}
</style>