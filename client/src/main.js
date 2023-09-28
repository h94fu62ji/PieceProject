import './assets/main.css'
import axios from 'axios'
import { createApp } from 'vue'
import { createPinia } from 'pinia'

import { mapActions, mapState } from 'pinia'
import indexStore from '../src/stores/counter'

import App from './App.vue'
import router from './router'

const app = createApp(App)
app.use(createPinia())
app.use(router)

app.mount('#app')


router.beforeEach((to, from, next) => {
    // console.log("導航守衛啟動")
    if (to.meta.requiresAuth) {  //to表示要進去的那頁
        const user = {
            "account" : localStorage.getItem("account"),
            "pwd" : localStorage.getItem("pwd"),
        }
        const api =  indexStore().URL + "test01";
        axios.post(api, user)
            .then(res => {
            // console.log(res.data.code);
            if (res.data.code == "200" ) {
                indexStore().changeUser(localStorage.getItem("account"))
                next()
            } else {
                indexStore().signOut()
                next("/login")
            }
        });

    } else next()
})

router.beforeEach((to, from, next) => {
    if (to.meta.isLogin) {  //to表示要進去的那頁
        const user = {
            "account" : localStorage.getItem("account"),
            "pwd" : localStorage.getItem("pwd"),
        }
        const api = indexStore().URL + "test01";
        axios.post(api, user)
        .then(res => {
        if (res.data.code == "200" ) {
            indexStore().changeUser(localStorage.getItem("account"))
            next("/")
        } else {
            indexStore().signOut()
            next()
        }

    });


    } else next()
})





// router.beforeEach((to, from, next) => {
//     console.log("導航守衛啟動")
//     if (to.meta.isSet) {  //to表示要進去的那頁
//         const user = {
//             "account" : localStorage.getItem("account"),
//         }
//         const api =  indexStore().URL + "get_user_data";
//         axios.post(api, user)
//             .then(res => {
//                 console.log(res)
//                 if(res.data.userData == 0){
//                     next("set")
//                 }
//             });
//     } else next()
// })


