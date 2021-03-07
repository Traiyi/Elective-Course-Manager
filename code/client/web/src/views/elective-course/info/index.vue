<template>
  <div class="app-container">
    <el-row type="flex" justify="space-between">
      <el-col :span="6">
        <div class="tag-group">
          <span class="tag-group__title">选修总人数</span>
          <span></span>
          <el-tag effect="dark" size="medium" style="margin-left: 10px">
            {{ total }}
          </el-tag>
        </div>
      </el-col>
            <el-col :span="6">
        <div class="tag-group">
          <span class="tag-group__title">已通过总人数</span>
          <span></span>
          <el-tag effect="dark" size="medium" style="margin-left: 10px">
            {{ passTotal }}
          </el-tag>
        </div>
      </el-col>
            <el-col :span="6">
        <div class="tag-group">
          <span class="tag-group__title">未通过总人数</span>
          <span></span>
          <el-tag effect="dark" size="medium" style="margin-left: 10px">
            {{ noPassTotal }}
          </el-tag>
        </div>
      </el-col>
    </el-row>
    <br />
    <br />

    <el-table
      :data="listPass"
      border
      fit
      highlight-current-row
      style="width: 100%"
    >
      <el-table-column label="已通过学生名单">
        <el-table-column prop="id" label="编号" width="180"> </el-table-column>

        <el-table-column label="学号">
          <template slot-scope="{ row }">
            <span>{{ row.student.studentNumber }}</span>
          </template>
        </el-table-column>
        <el-table-column label="姓名">
          <template slot-scope="{ row }">
            <span>{{ row.student.name }}</span>
          </template>
        </el-table-column>
        <el-table-column label="课程">
          <template slot-scope="{ row }">
            <span>{{ row.electiveCourse.name }}</span>
          </template>
        </el-table-column>
        <el-table-column label="学分">
          <template slot-scope="{ row }">
            <span>{{ row.studentCredit }}</span>
          </template>
        </el-table-column>
      </el-table-column>

      <!-- <el-table-column label="已通过学生名单">
       </el-table-column> -->
    </el-table>

    <el-table
      :data="listNoPass"
      border
      fit
      highlight-current-row
      style="width: 100%"
    >
      <el-table-column label="未通过学生名单">
        <el-table-column prop="id" label="编号" width="180"> </el-table-column>

        <el-table-column label="学号">
          <template slot-scope="{ row }">
            <span>{{ row.student.studentNumber }}</span>
          </template>
        </el-table-column>
        <el-table-column label="姓名">
          <template slot-scope="{ row }">
            <span>{{ row.student.name }}</span>
          </template>
        </el-table-column>
        <el-table-column label="课程">
          <template slot-scope="{ row }">
            <span>{{ row.electiveCourse.name }}</span>
          </template>
        </el-table-column>
        <el-table-column label="学分">
          <template slot-scope="{ row }">
            <span>{{ row.studentCredit }}</span>
          </template>
        </el-table-column>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import {
  electiveTotalElective,
  electiveListElectivePass,
  electiveListElectiveNoPass,
} from "@/api/elective";
import { gradeList } from "@/api/grade";
import { specialtyList } from "@/api/specialty";
import waves from "@/directive/waves"; // waves directive
import { parseTime } from "@/utils";
import Pagination from "@/components/Pagination"; // secondary package based on el-pagination

export default {
  name: "ElectiveCourseInfo",
  components: { Pagination },
  directives: { waves },

  data() {
    return {
      total: undefined,
      passTotal:undefined,
      noPassTotal:undefined,
      listPass: undefined,
      listNoPass: undefined,
    };
  },
  created() {
    this.getList();
  },
  methods: {
    getList() {
      var id = this.$route.query.id;
      console.log("id", id);
      this.listLoading = true;

      electiveTotalElective(id).then((response) => {
        this.total = response.data;
        console.log("total", this.total);
        setTimeout(() => {
          this.listLoading = false;
        }, 0.5 * 1000);
      });
      electiveListElectivePass(id).then((response) => {
        this.listPass = response.data;
        this.passTotal = response.data.length
        console.log("Pass", this.total);
        setTimeout(() => {
          this.listLoading = false;
        }, 0.5 * 1000);
      });
      electiveListElectiveNoPass(id).then((response) => {
        this.listNoPass = response.data;
        this.noPassTotal = response.data.length
        console.log("NoPass", this.listNoPass);
        setTimeout(() => {
          this.listLoading = false;
        }, 0.5 * 1000);
      });
    },
    getSummaries(param) {
      const { columns, data } = param;
      const sums = [];
      columns.forEach((column, index) => {
        if (index === 0) {
          sums[index] = "合计";
          return;
        }
        const values = data.map((item) => Number(item[column.property]));
        if (!values.every((value) => isNaN(value))) {
          sums[index] = values.reduce((prev, curr) => {
            const value = Number(curr);
            if (!isNaN(value)) {
              return prev + curr;
            } else {
              return prev;
            }
          }, 0);
          sums[index] += " 元";
        } else {
          sums[index] = "N/A";
        }
      });

      return sums;
    },
  },
};
</script>
