package SwordOffer.链表.链表中倒数第k个结点;

/**
 * Created by Weicools on 2018/4/22.
 * <p>
 * desc: 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution {
    /*
    设链表的长度为 N。设两个指针 P1 和 P2，
    先让 P1 移动 K 个节点，则还有 N - K 个节点可以移动。
    此时让 P1 和 P2 同时移动，可以知道当 P1 移动到链表结尾时，
    P2 移动到 N - K 个节点处，该位置就是倒数第 K 个节点
    */
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode p1, p2;
        p1 = p2 = head;

        while (p1 != null && k-- > 0) {
            p1 = p1.next;
        }

        if (k > 0) {
            return null;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }
}
