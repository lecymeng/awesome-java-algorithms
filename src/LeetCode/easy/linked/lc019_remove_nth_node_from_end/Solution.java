package LeetCode.easy.linked.lc019_remove_nth_node_from_end;

import LeetCode.easy.linked.ListNode;

/**
 * @author Weicools Create on 2018.08.28
 *
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 *
 * desc: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/42/
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
 * tag: linked、双指针
 */
class Solution {
  public ListNode removeNthFromEnd (ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = head;
    ListNode second = head;
    for (int i = 0; i < n; i++) {
      first = first.next;
    }
    while (first != null) {
      first = first.next;
      second = second.next;
    }
    second.next = second.next.next;
    return head;
  }

  public ListNode removeNthFromEnd1(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    int length  = 0;
    ListNode first = head;
    while (first != null) {
      length++;
      first = first.next;
    }
    length -= n;
    first = dummy;
    while (length > 0) {
      length--;
      first = first.next;
    }
    first.next = first.next.next;
    return dummy.next;
  }

  public static void main (String[] args) {

  }
}
