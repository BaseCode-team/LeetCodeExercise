# git提交规范
1. 下载安装git commit template 插件
2. 详细说明
```
   <type>(<scope>): <subject>
    <BLANK LINE>
    <body>
    <BLANK LINE>
    <footer>
   // NOTE  注意冒号 : 后有空格
   // 如 feat(miniprogram): 增加了小程序模板消息相关功能
```
   type 必填表示提交类型，值有以下几种：
 ```
    feat - 新功能 feature
    fix - 修复 bug
    merge - 合并分支
    docs - 文档注释
    style - 代码格式(不影响代码运行的变动)
    refactor - 重构、优化(既不增加新功能，也不是修复 bug)
    perf - 性能优化
    test - 增加测试
    chore - 构建过程或辅助工具的变动
    revert - 回退
    build - 打包
 ```
**scope 选填表示 commit 的作用范围，如数据层、视图层，也可以是目录名称。**

**subject 必填用于对 commit 进行简短的描述。**

**Body 部分是对本次 commit 的详细描述，可以分成多行。**

```
   More detailed explanatory text, if necessary.  Wrap it to 
    about 72 characters or so.
    
    Further paragraphs come after blank lines.

   - Bullet points are okay, too
   - Use a hanging indent
```
   有两个注意点:

- 使用第一人称现在时，比如使用change而不是changed或changes。
    
- 永远别忘了第2行是空行
    
- 应该说明代码变动的动机，以及与以前行为的对比。

**Footer 部分只用于以下两种情况：**
- 不兼容变动（如果当前代码与上一个版本不兼容，则 Footer 部分以BREAKING CHANGE开头，后面是对变动的描述、以及变动理由和迁移方法。）
- 关闭 Issue（如果当前 commit 针对某个issue，那么可以在 Footer 部分关闭这个 issue 。）
- Revert（还有一种特殊情况，如果当前 commit 用于撤销以前的 commit，则必须以revert:开头，后面跟着被撤销 Commit 的 Header。）
