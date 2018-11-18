package LeetCode.easy.linked;

/**
 * @author Weicools Create on 2018.11.16
 *
 * desc:
 */
class Solution {
  public void deleteNode (ListNode head, ListNode del) {
    if (del == null) {
      return;
    }

    while (head != null) {
      if (head.next == del) {
        head.next = del.next;
      }

      head = head.next;
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(4);
    l1.next.next.next = new ListNode(3);
    l1.next.next.next.next = new ListNode(8);

    ListNode del = l1.next.next;
    s.deleteNode(l1, del);
    while (l1 != null) {
      System.out.print(l1.val + "->");
      l1 = l1.next;
    }
  }
}
