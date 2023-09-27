<script>
import { RouterLink, RouterView } from 'vue-router'
import Person from './components/Person.vue';
import HomeBar from './components/HomeBar.vue';
import SetBar from './components/SetBar.vue';
import SearchBar from './components/SearchBar.vue';
import NewsBar from './components/NewsBar.vue';
import Post from './components/Post.vue';
import NewPost from './components/NewPost.vue'
import ChatList from './components/ChatList.vue';
// import Mesg from './components/Mesg.vue';
//pinia
import { mapActions, mapState } from 'pinia'
import indexStore from './stores/counter'


export default {
  components: {
    Person,
    HomeBar,
    SetBar,
    SearchBar,
    NewsBar,
    Post,
    NewPost,
    ChatList,
    // Mesg,
    RouterView,


  },
  provide() {
    return {
      reload: this.reload
    }
  },
  data() {
    return {
      homeBarView: false,
      setBarView: false,
      chatListView: false,
      searchBarView: false,
      newsBarView: false,
      postId: 20000000,
      isRouterAlive: true,
    }
  },
  computed: {
    // 參數 資料庫 要取用的 state / getters
    ...mapState(indexStore, ['postView', 'newPostView', 'login', 'user']),
  },
  methods: {
    // 參數 資料庫 要取用的 actions(methods)
    ...mapActions(indexStore, ['switchPost', 'switchNewPost']),
    switchHomeBar() {
      this.homeBarView = !this.homeBarView
    },
    homeBarClose() {
      this.homeBarView = false
    },
    switchSetBar() {
      this.setBarView = !this.setBarView
      this.switchHomeBar()
    },
    switchChatList() {
      this.chatListView = !this.chatListView
      this.switchHomeBar()
    },
    switchSearchBar() {
      this.searchBarView = !this.searchBarView
      this.switchHomeBar()
    },
    switchNewsBar() {
      this.newsBarView = !this.newsBarView
      this.switchHomeBar()
    },
    changeId(id) {
      this.postId = id
    },
    reload() {
      console.log('reload')
      window.location.reload()
    },



  },
}
</script>

<template>
  <div v-if="login" class="fakediv!! w-400 bg-slate-100 h-screen flex-shrink-0"></div>
  <Person v-if="login" :userId="this.user" :key="$route.fullPath" />
  <HomeBar v-if="login" :class="{ hideBar: !homeBarView, showBar: homeBarView }" />
  <SearchBar v-if="login" :class="{ hideBar: !searchBarView, showBar: searchBarView }" @click="switchSearchBar" />
  <NewsBar v-if="login" :class="{ hideBar: !newsBarView, showBar: newsBarView }" @click="switchNewsBar" />
  <Post v-if="postView" style="z-index: 10;" :postId="postId" />
  <SetBar v-if="login" :class="{ hideBar: !setBarView, showBar: setBarView }" @click="switchSetBar" />
  <ChatList v-if="login" :class="{ hideBar: !chatListView, showBar: chatListView }" />
  <RouterView class="flex-grow" :key="$route.fullPath" @getPostId="changeId" />
  <div v-if="login"
    class="w-20 h-20 rounded-full cursor-pointer select-none bg-cyan-500 fixed bottom-10 right-10 text-center text-6xl pt-1 text-white shadow-2xl shadow-gray-700 "
    @click="switchNewPost">+</div>
  <NewPost v-if="newPostView" />
  <!-- <Mesg v-if="mesgView" /> -->
</template>

<style scoped>
.hideBar {
  transform: translateX(-420px);
  transition: all .6s;
}

.showBar {
  transform: translateX(0);
  transition: all .6s;
}
</style>
