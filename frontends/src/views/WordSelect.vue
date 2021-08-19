<template>
    <el-row :gutter="20" v-show="showSelect">
        <el-col :span="8">
            <el-input v-model="selectWord" placeholder="请输入开始的单词"></el-input>
        </el-col>
        <el-col :span="8">
            <el-select v-model="number" placeholder="请选择单词量" style="width: 147px">
                <el-option
                        v-for="item in numbers"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                </el-option>
            </el-select>
        </el-col>
        <el-col :span="8">
            <el-button type="primary" @click="start">确认开始</el-button>
        </el-col>
    </el-row>
    <el-row :gutter="20">
        <el-col :span="12">
            {{ word }}
        </el-col>
        <el-col :span="6">
            <el-button type="warning" @click="lookComment">遗忘了点我</el-button>
        </el-col>
        <el-col :span="6">
            <el-button type="primary" @click="next">下一个</el-button>
        </el-col>
    </el-row>
    <el-row v-show="showComment">
        <el-input
                disabled="true"
                type="textarea"
                :autosize="{ minRows: 2, maxRows: 20}"
                placeholder=""
                v-model="comment">
        </el-input>
    </el-row>
</template>


<script>
    import * as dictionaryApi from '@/api/dictionary'
    export default {
        name: 'WordSelect',
        data() {
            return {
                activeName: 'first',
                numbers: [{
                    value: 5,
                    label: '5'
                }, {
                    value: 50,
                    label: '50'
                }, {
                    value: 100,
                    label: '100'
                }],
                selectWord: '',
                word: '',
                number: 50,
                words:[],
                readWords:[],
                sortedWords:[],
                sortedIndex: 1,
                commentMap: new Map(),
                comment: '',
                showComment: true,
                showSelect: true,
            };
        },
        methods: {
            start() {
                dictionaryApi.getDictionaryList(this.selectWord, this.number).then(data => {
                    this.words = data.data
                    let tempSortedWords = []
                    let index = 0
                    console.log('this.words', this.words)
                    for(let tempword of this.words) {
                        tempSortedWords.push(tempword.dictionarySpell)
                        index = index + 1;
                        if(index > this.number-1) {
                            this.sortedWords = this.sortedWords.concat(tempSortedWords.slice(index - 10, index))
                        } else {
                            this.sortedWords = this.sortedWords.concat(tempSortedWords)
                        }

                        this.commentMap.set(tempword.dictionarySpell, tempword.dictionaryComment);
                    }
                    let tempIndex = 0;
                    console.log('this.words', this.words)
                    while (tempIndex < this.number-1) {
                        tempSortedWords.push(this.words[tempIndex].dictionarySpell)
                        index = index + 1;
                        this.sortedWords = this.sortedWords.concat(tempSortedWords.slice(index - 10, index))
                        tempIndex++
                    }
                    this.word = this.words[0].dictionarySpell
                    this.readWords.push(this.word)
                    this.comment = this.commentMap.get(this.word)
                    this.showSelect = false
                })
            },
            lookComment() {
                this.comment = this.commentMap.get(this.word)
                this.showComment = true
            },
            next() {
                if(this.sortedWords.length === this.sortedIndex - 1) {
                    this.$message.success("已经学习完毕，可再次进行选择。")
                    this.showSelect = true
                    this.init()
                    return
                }
                this.showComment = false
                this.word = this.sortedWords[this.sortedIndex];
                this.comment = this.commentMap.get(this.word)
                this.sortedIndex = this.sortedIndex + 1;
                if(this.readWords.indexOf(this.word) === -1) {
                    this.readWords.push(this.word)
                    this.showComment = true
                } else {
                    this.showComment = false
                }
            },
            init() {
                this.selectWord = ''
                this.word = ''
                this.number = 50
                this.words = []
                this.readWords = []
                this.sortedWords = []
                this.sortedIndex = 1
                this.commentMap = new Map()
                this.comment = ''
            }
        }
    }
</script>
<style scoped>
    .el-row {
        margin-bottom: 20px;
    }
</style>
