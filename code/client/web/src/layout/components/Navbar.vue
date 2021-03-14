<template>
  <div class="navbar">
    <el-row type="flex" class="row-bg" justify="space-between">
      <el-col :span="6"
        ><hamburger
          :is-active="sidebar.opened"
          class="hamburger-container"
          @toggleClick="toggleSideBar"
        />
        <breadcrumb class="breadcrumb-container" />
      </el-col>
      <el-col :span="6">
        <div><img :src="img1" class="index-avater" /></div>
      </el-col>

      <el-col :span="6">
        <div><h3>选修课管理系统</h3></div>
      </el-col>

      <el-col :span="6">
        <div class="right-menu">
          <el-dropdown class="avatar-container" trigger="click">
            <div class="avatar-wrapper">
              <img :src="img2" class="user-avatar" />
              <i class="el-icon-caret-bottom" />
            </div>
            <el-dropdown-menu slot="dropdown" class="user-dropdown">
              <router-link to="/">
                <el-dropdown-item> Home </el-dropdown-item>
              </router-link>

              <el-dropdown-item divided @click.native="logout">
                <span style="display: block">Log Out</span>
              </el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import Breadcrumb from "@/components/Breadcrumb";
import Hamburger from "@/components/Hamburger";

export default {
  components: {
    Breadcrumb,
    Hamburger,
  },
  computed: {
    ...mapGetters(["sidebar", "avatar"]),
  },
  data() {
    return {
      img1: require("@/assets/shot/1.jpg"),
      img2: require("@/assets/shot/2.jpg"),
    };
  },
  methods: {
    toggleSideBar() {
      this.$store.dispatch("app/toggleSideBar");
    },
    async logout() {
      await this.$store.dispatch("user/logout");
      this.$router.push(`/login?redirect=${this.$route.fullPath}`);
    },
  },
};
</script>

<style lang="scss" scoped>
.navbar {
  height: 50px;
  overflow: hidden;
  position: relative;
  background: #fff;
  box-shadow: 0 1px 4px rgba(0, 21, 41, 0.08);

  .hamburger-container {
    line-height: 46px;
    height: 100%;
    float: left;
    cursor: pointer;
    transition: background 0.3s;
    -webkit-tap-highlight-color: transparent;

    &:hover {
      background: rgba(0, 0, 0, 0.025);
    }
  }

  .breadcrumb-container {
    float: left;
  }

  .index-avater {
    float: top;
    width: 200px;
    height: 50px;
  }

  .right-menu {
    float: right;
    // height: 100%;
    // line-height: 50px;

    // &:focus {
    //   outline: none;
    // }

    // .right-menu-item {
    //   display: inline-block;
    //   padding: 0 8px;
    //   height: 100%;
    //   font-size: 18px;
    //   color: #5a5e66;
    //   vertical-align: text-bottom;

    //   &.hover-effect {
    //     cursor: pointer;
    //     transition: background 0.3s;

    //     &:hover {
    //       background: rgba(0, 0, 0, 0.025);
    //     }
    //   }
    // }

    .avatar-container {
      // margin-right: 30px;

      .avatar-wrapper {
        // margin-top: 5px;
        // position: relative;

        .user-avatar {
          // cursor: pointer;
          width: 40px;
          height: 40px;
          // border-radius: 10px;
        }

        // .el-icon-caret-bottom {
        //   cursor: pointer;
        //   position: absolute;
        //   right: -20px;
        //   top: 25px;
        //   font-size: 12px;
        // }
      }
    }
  }
}
</style>
