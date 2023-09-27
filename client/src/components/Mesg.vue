<script>
//pinia
import { mapActions, mapState } from 'pinia'
import indexStore from '../stores/counter'
export default {
    props: ['mesg'],
    data() {
        return {
        }
    },
    methods: {
        // 參數 資料庫 要取用的 actions(methods)
        ...mapActions(indexStore, []),
        switchMesg() {
            this.$parent.switchMesg()
        }
    },
}
</script>

<template>
    <!-- 主外框 -->
    <div class="screen" @click="switchMesg">
        <div class="bg-lime-200 rounded-3xl w-96 h-40" @click.stop>
            <h1 class="text-center pt-16 text-4xl text-green-800">{{ mesg }}</h1>
        </div>
    </div>
</template>


<style scoped>
.screen {
    width: 100vw;
    height: 100vh;
    background-color: rgba(75, 75, 75, 0.7);
    display: flex;
    justify-content: center;
    align-items: center;
    position: fixed;
    top: 0;
    left: 0;
    z-index: 10;
}
</style>