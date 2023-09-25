import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('../views/HomeView.vue'),
    },
    {
      path: '/chat/:currentChatroomId',
      name: 'ChatHome',
      component: () => import('../views/ChatView.vue'),
      props:true,
    },  
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/LogInView.vue'),
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
