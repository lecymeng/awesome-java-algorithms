package LeetCode.easy.string.lc020_valid_parentheses;

import java.util.Stack;

/**
 * @author Weicools Create on 2018.11.10
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 *
 * desc: https://leetcode-cn.com/problems/valid-parentheses/description/
 * tag: 栈、字符串
 */
class Solution {
  /**
   * 可以用栈来解决这个问题，
   * 当出现左括号的时候入栈，当遇到右括号时，判断栈顶的左括号是否何其匹配，
   * 不匹配的话直接返回 false 即可，最终判断是否空栈即可，
   * 这里我们可以用数组模拟栈的操作使其操作更快，有个细节注意下 top = 1;，
   * 从而省去了之后判空的操作和 top - 1 导致数组越界的错误
   */
  public boolean isValid (String s) {
    char[] stack = new char[s.length() + 1];
    int top = 1;
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '[' || c == '{') {
        stack[top++] = c;
      } else if (c == ')' && stack[--top] != '(') {
        return false;
      } else if (c == ']' && stack[--top] != '[') {
        return false;
      } else if (c == '}' && stack[--top] != '{') {
        return false;
      }
    }

    return top == 1;
  }

  @Deprecated
  public boolean isValidV0 (String s) {
    if (s.isEmpty()) {
      return true;
    } else if (s.length() % 2 != 0) {
      return false;
    }

    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else if (c == ')' && !stack.isEmpty() && stack.pop() != '(') {
        return false;
      } else if (c == ']' && !stack.isEmpty() && stack.pop() != '[') {
        return false;
      } else if (c == '}' && !stack.isEmpty() && stack.pop() != '{') {
        return false;
      }
    }

    return stack.isEmpty();
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    System.out.println(s.isValid("{()}"));
    System.out.println(s.isValid("()[]{}"));
    System.out.println(s.isValid("()[{]}"));
    System.out.println(s.isValid("(({({"));

    System.out.println();

    System.out.println(s.isValidV0("{()}"));
    System.out.println(s.isValidV0("()[]{}"));
    System.out.println(s.isValidV0("()[{]}"));
    System.out.println(s.isValidV0("(({({"));
  }
}
