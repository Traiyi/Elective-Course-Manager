<template>
  <div class="dashboard-container">
    <br />
    <br />
    <br />
    <div class="dashboard-text" style="text-align: center">
      <h1>欢迎来到选修课管理系统</h1>
      <br />
      <h2>管理员{{ name }}先生</h2>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "Dashboard",
  computed: {
    ...mapGetters(["name"]),
  },
};
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    // margin: 30px;
    height: 600px;
    background-color: red; /* 浏览器不支持的时候显示 */
    background-image: radial-gradient(
      circle,
      rgb(59, 137, 218),
      rgb(35, 97, 173),
      rgb(38, 55, 77),
    ); /* 标准的语法（必须放在最后） */
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
