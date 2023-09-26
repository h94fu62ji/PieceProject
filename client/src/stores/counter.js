// 狀態資料庫
import { defineStore } from "pinia";

// 兩個參數 資料庫名稱 資料庫內容
export default defineStore("postStore",{
  // data 資料
  state:() => ({
    URL:'http://localhost:8080/',
    postIdList: [],
    user:10000001,
    postView: false,
    newPostView: false,
    login: true,

  }),
  // computed 顯示在畫面上的臨時變數
  getters: {
      // locationInfo: (state) => `現在的位置是:${state.location}`
  },
  // methods 方法
  actions: {
    switchPost(){
      this.postView = !this.postView
    },
    switchNewPost(){
      this.newPostView = !this.newPostView
    },
    pushList(postlist){
      this.postIdList.push(postlist)
    },
    pushListToFirst(postId){
      this.postIdList.unshift(postId)
    },
    rePostIdList(){
      this.postIdList = []
    }

  }
});

