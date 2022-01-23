import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/views/Main'
import IndexView from '@/views/mainComponents/IndexView'
import Login from '@/views/login/Login'
import Register from '@/views/login/Register'
import UserInfo from '@/views/mainComponents/UserInfo'
import ClassInfoView from '@/views/classComponents/ClassInfoView'
import ClassClaimView from '@/views/classComponents/ClassClaimView'
import ClassRateStandard from '@/views/classComponents/ClassRateStandard'
import ClassVideoView from '@/views/classComponents/ClassVideoView'
import ClassExamView from '@/views/classComponents/ClassExamView'
import AdminHome from '@/views/adminViews/AdminHome'
import SchoolInfo from '@/views/adminViews/SchoolInfo'
import AdminHomeSpace from '@/views/adminViews/AdminHomeSpace'
import StudentInfo from '@/views/adminViews/StudentInfo'
import TeacherInfo from '@/views/adminViews/TeacherInfo'
import ExamView from '@/views/classComponents/ExamView'
import StuGradesView from '@/views/classComponents/StuGradesView'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',  //首页
      name: 'Main',
      component: Main,
      redirect: '/mainComponents/indexview',
      children: [ //嵌套路由
        {
          path: '/mainComponents/indexview',
          component: IndexView,
          // meta: {
          //   requireAuth: true   //添加字段，表示此路由需要登录才可访问
          // }
        },
        {
          path: '/mainComponents/userinfo',   //个人中心
          component: UserInfo,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/classComponents/ClassInfoView/:id', //课程信息页面
          component: ClassInfoView,
          redirect: '/classComponents/ClassClaimView',
          meta: {
            requireAuth: true
          },
          children: [
            {
              path: '/classComponents/ClassClaimView',  //公告
              component: ClassClaimView,
              meta: {
                requireAuth: true
              }
            },
            {
              path: '/classComponents/ClassRateStandard',  //评分标准
              component: ClassRateStandard,
              meta: {
                requireAuth: true
              }
            },
            {
              path: '/classComponents/ClassVideoView',  //视频课件
              component: ClassVideoView,
              meta: {
                requireAuth: true
              }
            },
            {
              path: '/classComponents/ClassExamView',  //参加考试页面
              component: ClassExamView,
              meta: {
                requireAuth: true
              }
            },
            {
              path: '/classComponents/ExamView',  //考试页面
              component: ExamView,
              meta: {
                requireAuth: true
              }
            },
            {
              path: '/classComponents/StuGradesView',  //学生成绩页面 
              component: StuGradesView,
              meta: {
                requireAuth: true
              }
            }
          ]
        }
      ]
    },
    {
      path: '/login', //登录页面
      name: Login,
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/adminHome', //管理员界面
      name: AdminHome,
      component: AdminHome,
      redirect: '/adminHomeSpace',
      meta: {
        title: '管理员首页'
      },
      children: [
        {
          path: '/schoolInfo',
          name: SchoolInfo,
          component: SchoolInfo
        },
        {
          path: '/adminHomeSpace',
          name: AdminHomeSpace,
          component: AdminHomeSpace
        },
        {
          path: '/studentInfo',
          name: StudentInfo,
          component: StudentInfo
        },
        {
          path: '/teacherInfo',
          name: TeacherInfo,
          component: TeacherInfo
        }
      ]
    }
  ]
})
