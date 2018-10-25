package LeetCode.easy.linked.lc141_cycle_linked_list;

import LeetCode.easy.linked.ListNode;

/**
 * @author Weicools Create on 2018.08.28
 *
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 进阶：
 * 你能否不使用额外空间解决此题？
 *
 * desc: https://leetcode-cn.com/problems/linked-list-cycle/description/
 * tag: linked、双指针
 */
class Solution {
  /**
   * 使用双指针，一个指针每次移动一个节点，一个指针每次移动两个节点，如果存在环，那么这两个指针一定会相遇。
   */
  public boolean hasCycle (ListNode head) {
    if (head == null) {
      return false;
    }

    ListNode node1 = head, node2 = head.next;
    while (node1.next != null && node2 != null && node2.next != null) {
      if (node1 == node2) {
        return true;
      }

      node1 = node1.next;
      node2 = node2.next.next;
    }

    return false;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    System.out.println(s.hasCycle(null));
  }
}
