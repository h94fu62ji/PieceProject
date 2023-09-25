<script>
import { RouterLink, RouterView } from 'vue-router'
import Person from './components/Person.vue';
import HomeBar from './components/HomeBar.vue';
import SetBar from './components/SetBar.vue';
import FriendBar from './components/FriendBar.vue';
import SearchBar from './components/SearchBar.vue';
import NewsBar from './components/NewsBar.vue';
import Post from './components/Post.vue';
import NewPost from './components/NewPost.vue'
import ChatList from './components/ChatList.vue';
//pinia
import { mapActions, mapState } from 'pinia'
import indexStore from './stores/counter'


export default {
  components: {
    Person,
    HomeBar,
    SetBar,
    FriendBar,
    SearchBar,
    NewsBar,
    Post,
    NewPost,
    ChatList,
    RouterView
  },
  data() {
    return {
      personView: false,
      setBarView: false,
      chatListView: false,
      searchBarView: false,
      newsBarView: false,
      login: true,
    }
  },
  computed: {
    // 參數 資料庫 要取用的 state / getters
    ...mapState(indexStore, ['postView', 'newPostView']),
  },
  methods: {
    // 參數 資料庫 要取用的 actions(methods)
    ...mapActions(indexStore, ['switchPost', 'switchNewPost', 'randomNum']),
    switchPerson() {
      this.personView = !this.personView
    },
    switchSetBar() {
      this.setBarView = !this.setBarView
    },
    switchChatList() {
      this.chatListView = !this.chatListView
    },
    switchSearchBar() {
      this.searchBarView = !this.searchBarView
    },
    switchNewsBar() {
      this.newsBarView = !this.newsBarView
    },

  },
}
</script>

<template>
  <HomeBar v-if="login" />
  <SearchBar :class="{ hideBar: !searchBarView, showBar: searchBarView }" @click="switchSearchBar" />
  <NewsBar :class="{ hideBar: !newsBarView, showBar: newsBarView }" @click="switchNewsBar" />
  <Post v-if="postView" style="z-index: 10;" />
  <Person :class="{ hideBar: !personView, showBar: personView }" />
  <SetBar :class="{ hideBar: !setBarView, showBar: setBarView }" @click="switchSetBar" />
  <ChatList :class="{ hideBar: !chatListView, showBar: chatListView }" />
  <div v-if="login" class="fakediv!! w-400 bg-slate-100 h-screen flex-shrink-0"></div>
  <RouterView class="flex-grow" :currentUserId="currentUserId" />
  <div
    class="w-20 h-20 rounded-full cursor-pointer select-none bg-cyan-500 fixed bottom-10 right-10 text-center text-6xl pt-1 text-white shadow-2xl shadow-gray-700 "
    @click="switchNewPost">+</div>
  <NewPost v-if="newPostView" />
</template>

<style scoped>
.hideBar {
  transform: translateX(-420px);
  transition: all .5s;
}

.showBar {
  transform: translateX(0);
  transition: all .5s;
}
</style>
