<script>
import { RouterLink, RouterView } from 'vue-router'
//直接從資料庫拿資料，不用連websocket?

//pinia
import { mapActions, mapState } from 'pinia'
import indexStore from '../stores/counter'

//判斷對方為互相追蹤or追蹤中or被追蹤的部分要等user表整合

export default {
    data() {
        return {
            stompClient: null,
            lastMsgList: [],

            isChatroomDataOver: false,
        }
    },
    // props: ["currentUserId"],

    watch: {
        isChatroomDataOver() {
            console.log("載入完畢")
            console.log(this.lastMsgList.length)

        }
    },
    created() {
        this.getAllChatroom();

    },
    updated() {
        //排序
        this.lastMsgList.sort((a, b) => b.messageId - a.messageId);

    },
    computed: {
        // 參數 資料庫 要取用的 state / getters
        ...mapState(indexStore, ['URL', 'user']),
    },
    methods: {
        // 參數 資料庫 要取用的 actions(methods)
        ...mapActions(indexStore, []),

        closeChatList() {
            this.$parent.switchChatList()
        },

        getAllChatroom() {
            fetch(this.URL + `chatAll?currentUserId=${this.user}`)
                .then(res => res.json())
                .then(data => {
                    console.log(data);
                    // this.cList = data.cList;
                    let msgsArr = []; // 暫定排序用
                    data.cList.forEach(c => {
                        fetch(this.URL + `allMsg/${c.chatroomId}`)
                            .then(res => res.json())
                            .then(data => {
                                const lastMsgObj = data.mList[data.mList.length - 1];

                                if (lastMsgObj.messageContent.length > 8) {
                                    lastMsgObj.messageContent = lastMsgObj.messageContent.substring(0, 8) + "...";
                                }
                                this.lastMsgList.push(lastMsgObj);
                            })
                    });
                })
            this.isChatroomDataOver = true;
        },
        timeFormatter(datetimeStr) {
            const date = new Date(datetimeStr);

            const currentDatetime = new Date();
            // console.log(currentDatetime);
            let year = date.getFullYear();
            let month = date.getMonth() + 1;
            let d = date.getDate();
            let hr = date.getHours();
            let min = date.getMinutes();
            if (hr < 10) {
                hr = `0${hr}`;
            }
            if (min < 10) {
                min = `0${min}`;
            }

            return `${year} ${month}/${d} ${hr}:${min}`;
        },
        goToChatroom(chatroomId) {
            console.log(`前往聊天室${chatroomId}`);
            this.$router.push({
                name: "ChatHome",
                params: {
                    currentChatroomId: chatroomId,
                }
            });
        },

    },
}
</script>

<template>
    <div class="w-400 fixed h-screen bgc">
        <div class="w-80 mx-auto">
            <div class="my-4">
                <div class="w-16 h-16 bg-white " @click="closeChatList"></div>
            </div>
            <RouterLink @click.stop :to="`/chat/${msg.chatroomId}`" v-for="msg in lastMsgList"
                class="flex bg-gray-100 py-2 rounded-2xl items-center mb-4 cursor-pointer">
                <div class="icon bg-green-200 h-12 w-12 mx-2">
                </div>
                <div class="name-and-last-msg">
                    <p v-if="msg.sender == user" class="font-bold text-green-800">
                        {{ msg.reciever }}
                    </p>
                    <p v-if="msg.sender != user" class="font-bold text-green-800">
                        {{ msg.sender }}
                    </p>
                    <p class="text-gray-500 text-xs leading-3">
                        {{ msg.messageContent }}
                    </p>
                    <small class="text-gray-400 text-xs">
                        {{ timeFormatter(msg.datetime) }}
                    </small>
                </div>
            </RouterLink>
        </div>
    </div>
</template>

<style lang='scss' scoped></style>