import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('../views/HomeView.vue'),
      meta: { requiresAuth: true },
      props:true,
    },
    {
      path: '/chat/:currentChatroomId',
      name: 'ChatHome',
      component: () => import('../views/ChatView.vue'),
      meta: { requiresAuth: true },
      props:true,
    },  
    {
      path: '/set',
      name: 'set',
      component: () => import('../views/SetView.vue'),
      meta: { requiresAuth: true },
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/LogInView.vue'),
      meta: { isLogin : true },
    },
    {
      path: '/signup',
      name: 'signup',
      component: () => import('../views/SignUpView.vue'),
    },
    {
      path: '/pwdforgot',
      name: 'pwdforgot',
      component: () => import('../views/PwdForgot.vue'),
    },
    {
      path: '/pwdnew',
      name: 'pwdnew',
      component: () => import('../views/PwdNew.vue'),
    },
  ]
})


export default router


