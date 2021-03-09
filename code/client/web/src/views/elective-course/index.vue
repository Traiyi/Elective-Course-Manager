<template>
  <div class="app-container">
    <div class="filter-container">
      <el-input
        v-model="listQuery.name"
        placeholder="Title"
        style="width: 200px"
        class="filter-item"
        @keyup.enter.native="handleFilter"
      />

      <el-select
        v-model="listQuery.sort"
        style="width: 140px"
        class="filter-item"
        @change="handleFilter"
      >
        <el-option
          v-for="item in sortOptions"
          :key="item.key"
          :label="item.label"
          :value="item.key"
        />
      </el-select>

      <el-button
        v-waves
        class="filter-item"
        type="primary"
        icon="el-icon-search"
        @click="handleFilter"
      >
        搜索      </el-button>

      <el-button
        class="filter-item"
        style="margin-left: 10px"
        type="primary"
        icon="el-icon-edit"
        @click="handleCreate"
      >
        添加
      </el-button>
      <el-button
        v-waves
        :loading="downloadLoading"
        class="filter-item"
        type="primary"
        icon="el-icon-download"
        @click="handleDownload"
      >
        导出Excel      </el-button>
    </div>

    <el-table
      :key="tableKey"
      v-loading="listLoading"
      :data="list"
      border
      fit
      highlight-current-row
      style="width: 100%"
      @sort-change="sortChange"
    >
      <el-table-column
        label="选修课编号"
        prop="id"
        sortable="custom"
        align="center"
        width="80"
        :class-name="getSortClass('id')"
      >
        <template slot-scope="{ row }">
          <span>{{ row.id }}</span>
        </template>
      </el-table-column>

      <el-table-column label="年级名" width="110px" align="center">
        <template slot-scope="{ row }">
          <span>{{ row.grade.name }}</span>
        </template>
      </el-table-column>

      <el-table-column label="专业名" width="110px" align="center">
        <template slot-scope="{ row }">
          <span>{{ row.specialty.name }}</span>
        </template>
      </el-table-column>

      <el-table-column label="选修课名" width="110px" align="center">
        <template slot-scope="{ row }">
          <span>{{ row.name }}</span>
        </template>
      </el-table-column>

      <el-table-column label="学分" width="110px" align="center">
        <template slot-scope="{ row }">
          <span>{{ row.credit }}</span>
        </template>
      </el-table-column>

      <el-table-column label="学生数量" width="110px" align="center">
        <template slot-scope="{ row }">
          <span>{{ row.studentQuantity }}</span>
        </template>
      </el-table-column>

      <el-table-column
        label="操作"
        align="center"
        width="330"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="{ row, $index }">
          <el-button type="primary" size="mini" @click="handleUpdate(row)">
            编辑
          </el-button>

          <el-button
            v-if="row.status != 'deleted'"
            size="mini"
            type="danger"
            @click="handleDelete(row, $index)"
          >
            删除          </el-button>

          <el-button type="info" size="mini" @click="handleInfo(row)">
            课程详情
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="listQuery.page"
      :limit.sync="listQuery.limit"
      @pagination="getList"
    />

    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
      <el-form
        ref="dataForm"
        :rules="rules"
        :model="temp"
        label-position="left"
        label-width="70px"
        style="width: 400px; margin-left: 50px"
      >
        <el-form-item label="年级名" prop="grade.name">
          <!-- <el-input v-model="temp.grade.name" /> -->
          <el-select
            v-model="temp.gradeID"
            class="filter-item"
            placeholder="年级名"
          >
            <el-option
              v-for="item in listGrade"
              :key="item.id"
              :label="item.name"
              :value="item.id"
            />
          </el-select>
        </el-form-item>

        <el-form-item label="专业名" prop="specialty.name">
          <!-- <el-input v-model="temp.grade.name" /> -->
          <el-select
            v-model="temp.specialtyID"
            class="filter-item"
            placeholder="专业名"
          >
            <el-option
              v-for="item in listSpecialty"
              :key="item.id"
              :label="item.name"
              :value="item.id"
            />
          </el-select>
        </el-form-item>

        <el-form-item label="选修课名" prop="name">
          <el-input v-model="temp.name" />
        </el-form-item>
        <el-form-item label="学分" prop="name">
          <el-input v-model="temp.credit" />
        </el-form-item>
        <el-form-item label="学生数量" prop="name">
          <el-input v-model="temp.studentQuantity" />
        </el-form-item>
      </el-form>

      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false"> 关闭</el-button>
        <el-button
          type="primary"
          @click="dialogStatus === 'create' ? createData() : updateData()"
        >
          确认
        </el-button>
      </div>
    </el-dialog>

    <el-dialog :visible.sync="dialogPvVisible" title="Reading statistics">
      <el-table
        :data="pvData"
        border
        fit
        highlight-current-row
        style="width: 100%"
      >
        <el-table-column prop="key" label="Channel" />
        <el-table-column prop="pv" label="Pv" />
      </el-table>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogPvVisible = false"
          >确认</el-button
        >
      </span>
    </el-dialog>
  </div>
</template>

<script>
import {
  electiveCourseListAll,
  electiveCourseAdd,
  electiveCourseDelete,
  electiveCourseGet,
  electiveCourseUpdate,
} from "@/api/elective-course";
import { gradeList } from "@/api/grade";
import { specialtyList } from "@/api/specialty";
import waves from "@/directive/waves"; // waves directive
import { parseTime } from "@/utils";
import Pagination from "@/components/Pagination"; // secondary package based on el-pagination

export default {
  name: "ElectiveCourse",
  components: { Pagination },
  directives: { waves },

  data() {
    return {
      tableKey: 0,
      list: null,
      listGrade: null,
      listSpecialty: null,
      total: 0,
      listLoading: true,
      listQuery: {
        page: 1,
        limit: 20,
        name: undefined,
        sort: "+id",
      },
      sortOptions: [
        { label: "ID Ascending", key: "+id" },
        { label: "ID Descending", key: "-id" },
      ],
      temp: {
        id: undefined,
        name: "",
        gradeID: undefined,
        specialtyID: undefined,
        credit: undefined,
        studentQuantity: undefined,
        grade: {
          id: undefined,
          name: "",
        },
        specialty: {
          id: undefined,
          gradeID: undefined,
          name: "",
        },
      },

      dialogFormVisible: false,
      dialogStatus: "",
      textMap: {
        update: "编辑",
        create: "添加",
      },
      dialogPvVisible: false,
      pvData: [],
      rules: {
        type: [
          { required: true, message: "type is required", trigger: "change" },
        ],
        timestamp: [
          {
            type: "date",
            required: true,
            message: "timestamp is required",
            trigger: "change",
          },
        ],
        title: [
          { required: true, message: "title is required", trigger: "blur" },
        ],
      },
      downloadLoading: false,
    };
  },
  created() {
    this.getList();
  },
  methods: {
    getList() {
      this.listLoading = true;
      electiveCourseListAll(this.listQuery).then((response) => {
        this.list = response.data;
        this.total = response.data.length;

        console.log(this.list);
        // Just to simulate the time of the request
        setTimeout(() => {
          this.listLoading = false;
        }, 0.5 * 1000);
      });
      gradeList(this.listQuery).then((response) => {
        this.listGrade = response.data;

        console.log(this.list);
        // Just to simulate the time of the request
        setTimeout(() => {
          this.listLoading = false;
        }, 0.5 * 1000);
      });
      specialtyList(this.listQuery).then((response) => {
        this.listSpecialty = response.data;

        console.log(this.list);
        // Just to simulate the time of the request
        setTimeout(() => {
          this.listLoading = false;
        }, 0.5 * 1000);
      });
    },
    handleFilter() {
      this.listQuery.page = 1;
      this.getList();
    },

    sortChange(data) {
      const { prop, order } = data;
      if (prop === "id") {
        this.sortByID(order);
      }
    },
    sortByID(order) {
      if (order === "ascending") {
        this.listQuery.sort = "+id";
      } else {
        this.listQuery.sort = "-id";
      }
      this.handleFilter();
    },
    resetTemp() {
      this.temp = {
        id: undefined,
        name: "",
        gradeID: undefined,
        specialtyID: undefined,
        credit: undefined,
        studentQuantity: undefined,
        grade: {
          id: undefined,
          name: "",
        },
        specialty: {
          id: undefined,
          gradeID: undefined,
          name: "",
        },
      };
    },
    handleCreate() {
      this.resetTemp();
      this.dialogStatus = "create";
      this.dialogFormVisible = true;
      this.$nextTick(() => {
        this.$refs["dataForm"].clearValidate();
      });
    },
    createData() {
      this.$refs["dataForm"].validate((valid) => {
        if (valid) {
          electiveCourseAdd(this.temp).then(() => {
            // this.list.unshift(this.temp);
            this.dialogFormVisible = false;

            this.getList();
            this.$notify({
              title: "Success",
              message: "创建成功",
              type: "success",
              duration: 2000,
            });
          });
        }
      });
    },
    handleUpdate(row) {
      this.temp = Object.assign({}, row); // copy obj
      // this.temp.timestamp = new Date(this.temp.timestamp);
      this.dialogStatus = "update";
      this.dialogFormVisible = true;
      this.$nextTick(() => {
        this.$refs["dataForm"].clearValidate();
      });
    },
    updateData() {
      this.$refs["dataForm"].validate((valid) => {
        if (valid) {
          // const tempData = Object.assign({}, this.temp);
          // tempData.timestamp = +new Date(tempData.timestamp); // change Thu Nov 30 2017 16:41:05 GMT+0800 (CST) to 1512031311464
          electiveCourseUpdate(this.temp).then(() => {
            const index = this.list.findIndex((v) => v.id === this.temp.id);
            this.list.splice(index, 1, this.temp);
            this.dialogFormVisible = false;
            this.$notify({
              title: "Success",
              message: "更新成功",
              type: "success",
              duration: 2000,
            });
          });
        }
      });
    },
    handleDelete(row, index) {
      electiveCourseDelete(row.id).then(() => {
        this.getList();
        this.$notify({
          title: "Success",
          message: "删除成功",
          type: "success",
          duration: 2000,
        });
      });
    },

    handleInfo(row) {
      console.log(row);
      this.loading = true;

      this.$router.push({
        path: this.redirect || "/elective-course/info/index",
        // name: "ElectiveCourseInfo",
        query: { id: row.id },
        // 暂弃, credit: row.credit
        // params: { electiveCourse: row },
      });
      this.loading = false;
    },

    handleDownload() {
      this.downloadLoading = true;
      import("@/vendor/Export2Excel").then((excel) => {
        const tHeader = ["name"];
        const filterVal = ["name"];
        const data = this.formatJson(filterVal);
        excel.export_json_to_excel({
          header: tHeader,
          data,
          filename: "table-list",
        });
        this.downloadLoading = false;
      });
    },
    formatJson(filterVal) {
      return this.list.map((v) =>
        filterVal.map((j) => {
          if (j === "timestamp") {
            return parseTime(v[j]);
          } else {
            return v[j];
          }
        })
      );
    },
    getSortClass: function (key) {
      const sort = this.listQuery.sort;
      return sort === `+${key}` ? "ascending" : "descending";
    },
  },
};
</script>
