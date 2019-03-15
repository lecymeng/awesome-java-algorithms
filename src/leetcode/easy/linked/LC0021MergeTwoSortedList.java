package leetcode.easy.linked;

import leetcode.easy.linked.data.ListNode;

/**
 * @author Weicools Create on 2018.08.28
 *
 * 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * desc: https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 * tag: linked
 */
class LC0021MergeTwoSortedList {
  /**
   * 只需要从头开始比较已排序的两个链表，
   * 新链表指针每次指向值小的节点，依次比较下去，
   * 最后，当其中一个链表到达了末尾，我们只需要把
   * 新链表指针指向另一个没有到末尾的链表此时的指针即可
   */
  public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode temp = head;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        temp.next = l1;
        l1 = l1.next;
      } else {
        temp.next = l2;
        l2 = l2.next;
      }

      temp = temp.next;
    }

    temp.next = l1 != null ? l1 : l2;
    return head.next;
  }

  public static void main (String[] args) {
    LC0021MergeTwoSortedList s = new LC0021MergeTwoSortedList();
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(4);
    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);

    ListNode result = s.mergeTwoLists(l1, l2);
    while (result != null) {
      System.out.print(result.val + "-->");
      result = result.next;
    }
  }
}
