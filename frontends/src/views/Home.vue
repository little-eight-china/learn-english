<template>
  <el-row :gutter="20">
    <el-col :span="8"></el-col>
    <el-col :span="8">
      <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="单词选择" name="first">
          <word-select/>
        </el-tab-pane>
<!--        <el-tab-pane label="旧词回顾" name="second"></el-tab-pane>-->
        <el-tab-pane label="使用帮助" name="three">
          <help/>
        </el-tab-pane>
      </el-tabs>
    </el-col>
    <el-col :span="8">
    </el-col>
  </el-row>
</template>

<script>
import Help from "@/views/Help";
import WordSelect from "@/views/WordSelect";
export default {
  name: 'Home',
  components: {
    WordSelect,Help
  },
  data() {
    return {
      activeName: 'first',
      numbers: [{
        value: 50,
        label: '50'
      }, {
        value: 100,
        label: '100'
      }],
      number: ''
    };
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    }
  }
}
</script>
