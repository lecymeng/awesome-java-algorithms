package LeetCode.other.LinkedList.删除链表中等于给定值;

/**
 * @author Weicools Create on 2018/4/26.
 *
 * desc:
 */
public class Solution {
  public ListNode removeElements (ListNode head, int val) {
    ListNode curr = head;
    while (curr != null) {
      while (curr.next != null && curr.next.val == val) {
        curr.next = curr.next.next;
      }
      curr = curr.next;
    }

    return head;
  }

  public static void main (String[] args) {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(3);
    node.next.next.next = new ListNode(3);
    node.next.next.next.next = new ListNode(4);
    node.next.next.next.next.next = new ListNode(5);
    node.next.next.next.next.next.next = new ListNode(3);

    Solution solution = new Solution();
    solution.removeElements(node, 3);

    while (node != null) {
      System.out.println(node.val);
      node = node.next;
    }
  }
}
