<script>

import { RouterLink, RouterView } from 'vue-router'
//pinia
import { mapActions, mapState } from 'pinia'
import indexStore from '../stores/counter'
//websocket用
import Stomp from 'stompjs';
//emoji用
import data from "emoji-mart-vue-fast/data/all.json";
import "emoji-mart-vue-fast/css/emoji-mart.css";
import { Picker, EmojiIndex } from "emoji-mart-vue-fast/src";
let emojiIndex = new EmojiIndex(data);


export default {

  components: {
    Picker,
    // ChatroomList,
  },

  data() {
    return {
      stompClient: null,
      messages: [],
      newMsg: null,
      reciever: "",
      lastReadMsgIdFromCurrentUser: 0,
      lastReadMsgFromChatPartner: 0,

      emojiIndex: emojiIndex,
      emojisOutput: "",
      isEmojiModalShow: false,

      isCanRead: true,
      currentChatroomId: 40000000,
    }
  },
  props: [
    // "currentChatroomId",//用router把聊天室id給prop進來
  ],
  watch: {

  },
  created() {
    //元件創建時呼叫建立連接的方法
    this.connectWs();
  },
  updated() {
    this.scrollDown();
  },
  mounted() {

    this.getAllMsg(this.currentChatroomId);
    this.getChatroomInfo(this.currentChatroomId);

    this.scrollDown();


  },
  computed: {
    // 參數 資料庫 要取用的 state / getters
    ...mapState(indexStore, ['URL', 'user']),
  },

  methods: {

    // 參數 資料庫 要取用的 actions(methods)
    ...mapActions(indexStore, []),

    scrollDown() {
      if (this.isCanRead) {
        //網頁載入後自動捲到最下方
        setTimeout(() => {
          const msgs = document.getElementById("msgs");
          msgs.scrollTop = msgs.scrollHeight;
        }, 100);
      }

    },
    emojiModalHandler() {
      this.isEmojiModalShow = !this.isEmojiModalShow;
    },
    showEmoji(emoji) {
      if (this.newMsg === null) {
        this.newMsg = "";
      }
      this.newMsg = this.newMsg + emoji.native;

    },
    sendMessage() {
      if (this.newMsg === null || this.newMsg == "") {
        alert("請輸入訊息！");
        return;
      }
      const message = {
        chatroomId: this.currentChatroomId,
        sender: this.user,
        messageContent: this.newMsg,
      };

      //傳送訊息到通道
      this.stompClient.send(`/app/chat/${this.currentChatroomId}`, {}, JSON.stringify(message));

      //送出訊息後清空輸入框
      this.newMsg = "";
      this.isEmojiModalShow = false;

    },
    // 判斷USER1 與USER2
    getChatroomInfo(currentChatroomId) {
      fetch(this.URL + `findByChatroomId?chatroomId=${currentChatroomId}`)
        .then(res => {
          console.log(res)
          return res.json();
        })
        .then(data => {
          // console.log(data);
          if (this.user == data.user1) {
            this.reciever = data.user2;
            this.lastReadMsgFromChatPartner = data.user2Read;
          } else if (this.user == data.user2) {
            this.reciever = data.user1;
            this.lastReadMsgFromChatPartner = data.user1Read;
          } else {
            this.isCanRead = false;
          }

        });
    },
    // 獲取當前聊天室的所有訊息
    getAllMsg(currentChatroomId) {
      fetch(this.URL + `allMsg/${currentChatroomId}`)
        .then(res => res.json())
        .then(data => {
          console.log(data)
          this.messages = data.mList;

          //找出聊天室中sender不為自己，且id最大的訊息的id
          this.lastReadMsgIdFromCurrentUser = this.messages.reduce((maxId, currentMsg) => {
            if (currentMsg.sender !== this.user && currentMsg.messageId > maxId) {
              return currentMsg.messageId;
            }
            return maxId;
          }, -1);
          // console.log(this.lastReadMsgIdFromCurrentUser);

          this.setReadMsg();
        })
    },
    //設置最新已讀的訊息
    setReadMsg() {
      const setReadMsgIdReq = {
        "chatroomId": this.currentChatroomId,
        "user": this.user,
        "lastReadMsgId": this.lastReadMsgIdFromCurrentUser,
      }
      // console.log(JSON.stringify(setReadMsgIdReq))
      //對後端發送POST請求，儲存最新已讀的訊息id
      fetch(this.URL + "setReadMsgId", {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(setReadMsgIdReq),
      })
        .then(res => res.json())
        .then(data => {
          // console.log(data);
        })
        .catch(e => {
          console.error(e);
        });
    },
    //定義建立websocket連接的方法
    connectWs() {
      this.stompClient = Stomp.client("ws://localhost:8080/chat");

      this.stompClient.connect({}, () => {
        console.log("已連接到websocket");

        //訂閱通道
        this.stompClient.subscribe(`/topic/chat/${this.currentChatroomId}`, (message) => {
          console.log("接收到訊息");
          this.messages.push(JSON.parse(message.body));
        })
      });
    },
    //調整訊息時間的格式
    timeFormatter(datetimeStr) {
      const date = new Date(datetimeStr);

      const currentDatetime = new Date();
      // console.log(currentDatetime);

      let hr = date.getHours();
      let min = date.getMinutes();
      if (hr < 10) {
        hr = `0${hr}`;
      }
      if (min < 10) {
        min = `0${min}`;
      }

      if ((currentDatetime - date) / (1000 * 60 * 60) >= 24) {
        return `${date.getMonth() + 1}/${date.getDate()}  ${hr}:${min}`
      } else {
        return `${hr}:${min}`;
      }
    },
  },
}

</script>

<template>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
    integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
  <div style="width:100% ;height: 100vh;">
    <div v-if="isCanRead" class="mx-20 my-10 rounded-2xl overflow-hidden" style=" background-color: #DFDFDF;">
      <div class="header flex" style="padding: 10px 10%; background-color: #C9FF84;">
        <!-- 這裡之後要放對方的頭貼 -->
        <div class="w-20 h-20 bg-white rounded-xl">userPic</div>
        <h2 class="text-3xl font-bold ml-4 mt-4 ">{{ reciever }}</h2>
      </div>

      <div class="msgs flex flex-col justify-end overflow-y-scroll" id="msgs" style="padding: 0 10%;">
        <div class="" :key="message.messageId" v-for="message in messages">
          <div :class="{ 'justify-end': message.sender == user, 'justify-start': message.sender != user, }"
            class="msg-content flex items-center my-2">
            <div :class="{ 'order-1': message.sender != user }" class="flex flex-col text-green-800">
              <small class="text-end text-sm"
                v-if="message.sender == user && message.messageId <= lastReadMsgFromChatPartner">
                已讀
              </small>
              <small class="">{{ timeFormatter(message.datetime) }}</small>
            </div>

            <p :class="{ 'bg-white': message.sender != user, 'color2': message.sender == user }"
              class="p-2 mx-2 rounded-md break-all max-w-2xl">{{ message.messageContent }}</p>

          </div>


        </div>
      </div>
      <div style="padding: 0 10%;">
        <div class="input-block flex justify-around relative  py-4 ">

          <button class="w-16 bg-white rounded-2xl text-2xl mx-1" type="button">
            <i class="fa-solid fa-image"></i>
          </button>
          <button @click="emojiModalHandler" class="w-16 bg-white rounded-2xl text-2xl mx-1" type="button">
            <i class="fa-regular fa-face-smile"></i>
          </button>
          <!-- emoji -->
          <Picker class="absolute -translate-x-1/2 -translate-y-full" v-if="isEmojiModalShow" :data="emojiIndex"
            set="twitter" @select="showEmoji" />
          <!-- emoji -->
          <textarea @keydown.enter="sendMessage" rows="2"
            class="pl-2 pt-4 mx-1 text-2xl w-2/3 h-16 rounded-2xl resize-none overflow-visible" type="text"
            v-model="newMsg"></textarea>
          <button @click="sendMessage" class="color1 w-32 rounded-2xl text-white mx-1" type="button">
            <i class="fa-regular fa-paper-plane"></i>
          </button>
        </div>
      </div>
    </div>

    <div v-if="!isCanRead" class="bg-gray-100 flex justify-center items-center" style=" background-color: #D9D9D9;">
      <p class="text-center text-2xl font-bold">不可以偷看別人的訊息！壞壞！</p>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.msgs {
  height: 70vh;
  overflow-y: scroll;

  &::-webkit-scrollbar {
    margin-left: 10px;
    width: 5px;
    border-radius: 4px;
  }

  &::-webkit-scrollbar-thumb {
    background-color: rgb(205, 241, 205);
    transition: .3s;
    border-radius: 3px;
  }
}
</style>