package leetcode.easy.linked;

import leetcode.easy.linked.data.ListNode;

/**
 * @author Weicools Create on 2018.11.12
 * 203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * desc: https://leetcode-cn.com/problems/remove-linked-list-elements/description/
 * tag: 链表
 */
class LC0203RemoveLinkedListElements {
  /**
   * 如果当前head.val=目标val，就返回head.next
   * 对于head.next同样如此，递归调用
   */
  public ListNode removeElements (ListNode head, int val) {
    if (head == null) {
      return null;
    }

    head.next = removeElements(head.next, val);
    return head.val == val ? head.next : head;
  }

  @Deprecated
  public ListNode removeElementsV0 (ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    while (pre.next != null) {
      if (pre.next.val == val) {
        pre.next = pre.next.next;
      } else {
        pre = pre.next;
      }
    }

    return dummy.next;
  }

  public static void main (String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(2);
    l1.next.next.next = new ListNode(3);
    l1.next.next.next.next = new ListNode(4);

    ListNode res = new LC0203RemoveLinkedListElements().removeElements(l1, 4);
    while (res != null) {
      System.out.print(res.val + "-->");
      res = res.next;
    }
  }
}
