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
    RouterView
  },
  data() {
    return {
      personView: false,
      setBarView: false,
      friendBarView: false,
      searchBarView: false,
      newsBarView: false,
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
    switchFriendBar() {
      this.friendBarView = !this.friendBarView
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
  <!-- <HomeBar />
  <FriendBar :class="{ hideBar: !friendBarView, showBar: friendBarView }" @click="switchFriendBar" />
  <SearchBar :class="{ hideBar: !searchBarView, showBar: searchBarView }" @click="switchSearchBar" />
  <NewsBar :class="{ hideBar: !newsBarView, showBar: newsBarView }" @click="switchNewsBar" />
  <Post v-if="postView" style="z-index: 10;" />
  <Person :class="{ hideBar: !personView, showBar: personView }" />
  <SetBar :class="{ hideBar: !setBarView, showBar: setBarView }" @click="switchSetBar" /> -->
  <div class="fakediv!! w-400 bg-slate-100 h-screen flex-shrink-0"></div>
  <RouterView class="flex-grow" />
  <NewPost v-if="newPostView" />
  <div
    class="w-20 h-20 rounded-full cursor-pointer select-none bg-cyan-500 fixed bottom-10 right-10 text-center text-6xl pt-1 text-white z-50 shadow-2xl shadow-gray-700 "
    @click="switchNewPost">+</div>
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
