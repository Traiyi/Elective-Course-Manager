import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  // {
  //   path: '/elective-course/info',
  //   component: () => import('@/views/elective-course/info/index'),
  //   hidden: true
  // },


  {
    path: '/elective-course/info',
    component: Layout,
    children: [
      {
        path: 'index',
        name: 'ElectiveCourseInfo',
        component: () => import('@/views/elective-course/info/index'),


        // meta: { title: 'xx管理', icon: 'form' }
      }
    ],
    // hidden: true
  },

  {
    path: '/student/info',
    component: Layout,
    children: [
      {
        path: 'index',
        name: 'StudentInfo',
        component: () => import('@/views/student/info/index'),


        // meta: { title: 'xx管理', icon: 'form' }
      }
    ],
    // hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: '主页', icon: 'dashboard' }
    }]
  },

  {
    path: '/grade',
    component: Layout,
    children: [
      {
        path: 'index',
        name: 'Grade',
        component: () => import('@/views/grade/index'),
        meta: { title: '年级管理', icon: 'list' }
      }
    ]
  },
  {
    path: '/specialty',
    component: Layout,
    children: [
      {
        path: 'index',
        name: 'Specialty',
        component: () => import('@/views/specialty/index'),
        meta: { title: '专业管理', icon: 'tree-table' }
      }
    ]
  },
  {
    path: '/elective-course',
    component: Layout,
    children: [
      {
        path: 'index',
        name: 'ElectiveCourse',
        component: () => import('@/views/elective-course/index'),
        meta: { title: '选修课管理', icon: 'education' }
      }
    ]
  },
  {
    path: '/elective',
    component: Layout,
    children: [
      {
        path: 'index',
        name: 'Elective',
        component: () => import('@/views/elective/index'),
        meta: { title: '选修管理', icon: 'edit' }
      }
    ]
  },
  {
    path: '/student',
    component: Layout,
    children: [
      {
        path: 'index',
        name: 'student',
        component: () => import('@/views/student/index'),
        meta: { title: '学生管理', icon: 'peoples' }
      }
    ]
  },
  {
    path: '/question-answer',
    component: Layout,
    children: [
      {
        path: 'index',
        name: 'QuestionAnswer',
        component: () => import('@/views/question-answer/index'),
        meta: { title: '问答管理', icon: 'email' }
      }
    ]
  },


  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
