<template>
  <div class="app-container">
    <el-table
      v-loading="listLoading"
      :data="list"
      border
      fit
      highlight-current-row
      style="width: 100%"
    >
      <el-table-column align="center" label="问题编号" width="80">
        <template slot-scope="{ row }">
          <span>{{ row.id }}</span>
        </template>
      </el-table-column>

      <el-table-column width="120px" align="center" label="学生编号">
        <template slot-scope="{ row }">
          <span>{{ row.studentID }}</span>
        </template>
      </el-table-column>

      <el-table-column width="120px" align="center" label="问题">
        <template slot-scope="{ row }">
          <span>{{ row.question }}</span>
        </template>
      </el-table-column>

      <el-table-column min-width="300px" label="回答">
        <template slot-scope="{ row }">
          <template v-if="row.edit">
            <el-input v-model="row.answer" class="edit-input" size="small" />
            <el-button
              class="cancel-btn"
              size="small"
              icon="el-icon-refresh"
              type="warning"
              @click="cancel编辑(row)"
            >
              cancel
            </el-button>
          </template>
          <span v-else>{{ row.answer }}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="操作" width="120">
        <template slot-scope="{ row }">
          <el-button
            v-if="row.edit"
            type="success"
            size="small"
            icon="el-icon-circle-check-outline"
            @click="confirm编辑(row)"
          >
            Ok
          </el-button>
          <el-button
            v-else
            type="primary"
            size="small"
            icon="el-icon-edit"
            @click="row.edit = !row.edit"
          >
            编辑
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import {
  questionAnswerList,
  questionAnswerAdd,
  questionAnswerDelete,
  questionAnswerGet,
  questionAnswerUpdate,
} from "@/api/question-answer";
import waves from "@/directive/waves"; // waves directive
import { parseTime } from "@/utils";
import Pagination from "@/components/Pagination"; // secondary package based on el-pagination

export default {
  name: "QuestionAnswer",
  components: { Pagination },
  directives: { waves },
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: "success",
        draft: "info",
        deleted: "danger",
      };
      return statusMap[status];
    },
  },
  data() {
    return {
      list: null,
      listLoading: true,
      listQuery: {
        page: 1,
        limit: 10,
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    async getList() {
      this.listLoading = true;
      const { data } = await questionAnswerList(this.listQuery);
      console.log(data);
      // const items = data.items
      // console.log(items)
      this.list = data.map((v) => {
        this.$set(v, "edit", false); // https://vuejs.org/v2/guide/reactivity.html
        v.originalTitle = v.answer; //  will be used when user click the cancel botton
        return v;
      });
      console.log(this.list);
      this.listLoading = false;
    },
    cancel编辑(row) {
      row.answer = row.originalTitle;
      row.edit = false;
      this.$message({
        message: "The title has been restored to the original value",
        type: "warning",
      });
    },
    confirm编辑(row) {
      row.edit = false;
      row.originalTitle = row.answer;

      console.log(row);
      delete row["edit"];
      delete row["originalTitle"];
      console.log(row);
      questionAnswerUpdate(row).then(() => {
        this.$message({
          message: "The title has been edited",
          type: "success",
        });
      });
    },
  },
};
</script>

<style scoped>
.edit-input {
  padding-right: 100px;
}
.cancel-btn {
  position: absolute;
  right: 15px;
  top: 10px;
}
</style>
