<template>
        <div class="text">1、首先你得输入你想背诵的单词，然后系统会以这个单词为起点（或者是大于这个字符串的）去获取指定数量的单词.</div>
        <div class="text">2、首次出现的单词会展示释义，点击”下一个“按钮会显示下一个需要背诵的单词.</div>
        <div class="text">3、每个单词会重复出现10次，加深印象.</div>
        <div class="text">4、每个单词只记忆它的中文意思，并且每次出现都默念或者读出它的释义</div>
        <div class="text">5、当非首次出现的单词时，释义会隐藏起来，这时候就依靠自己的记忆来默念或者读 <a style="color: red">5 遍 </a>它的释义，当然你忘记的话可以点击“遗忘了点我”按钮来查看意思.</div>
        <div class="text">6、目前只支持作者收集的cet4、cet6单词集，并且只开放了cet4.</div>
        <div class="text">7、后期开发个人旧词回顾功能.</div>
</template>

<script>
    export default {
        name: 'Home',
        data() {
            return {
                activeName: 'first',
            };
        }
    }
</script>
<style>
    .text {
        margin-bottom: 20px;
    }
</style>
