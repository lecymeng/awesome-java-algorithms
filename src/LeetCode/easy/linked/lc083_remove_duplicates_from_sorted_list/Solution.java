package LeetCode.easy.linked.lc083_remove_duplicates_from_sorted_list;

import LeetCode.easy.linked.ListNode;

/**
 * @author Weicools Create on 2018.11.12
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * desc: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 * tag: 链表
 */
class Solution {
  /**
   * 遇到链表中相邻元素相同时，把当前指针指向下下个元素即可。
   */
  public ListNode deleteDuplicates (ListNode head) {
    ListNode t = head;
    while (t != null && t.next != null) {
      if (t.val == t.next.val) {
        t.next = t.next.next;
      } else {
        t = t.next;
      }
    }

    return head;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(2);
    l1.next.next.next = new ListNode(4);
    l1.next.next.next.next = new ListNode(4);

    ListNode res = s.deleteDuplicates(l1);
    while (res != null) {
      System.out.println(res.val + "-->");
      res = res.next;
    }
  }
}
