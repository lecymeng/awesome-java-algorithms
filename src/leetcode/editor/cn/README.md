# LeetCode plugin

## CodeFileName

默认模板

```
[$!{question.frontendQuestionId}]${question.title}
[$!{question.frontendQuestionId}]${question.titleSlug}
```

自定义模板

```
LC$!velocityTool.leftPadZeros($!{question.frontendQuestionId}, 4)_$!velocityTool.camelCaseName(${question.titleSlug})
```

## CodeTemplate

默认模板

```
${question.content}

${question.code}
```

自定义模板

```
${question.content}
//${question.title}

package leetcode.editor.cn;

class LC$!velocityTool.leftPadZeros($!{question.frontendQuestionId}, 4)_$!velocityTool.camelCaseName(${question.titleSlug}) {
    public static void main(String[] args) {
        Solution solution = new LC$!velocityTool.leftPadZeros($!{question.frontendQuestionId}, 4)_$!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
        // TO TEST
    }

${question.code}
}
```