package swordoffer;

import swordoffer.data.ListNode;

/**
 * Created by Weicools on 2018/4/26.
 * <p>
 * desc:
 */
public class SO14ReverseLinkedList {
    public ListNode reverseListNode(ListNode head) {
        // head看作是前一结点，head.next是当前结点，reHead是反转后新链表的头结点  
        if (head == null || head.next == null) {
            return head;// 若为空链或者当前结点在尾结点，则直接还回  
        }
        ListNode reHead = reverseListNode(head.next);// 先反转后续节点head.next
        //head.next.setNext(head);// 将当前结点的指针域指向前一结点
        head.next.next = head;
        //head.setNext(null);// 前一结点的指针域令为null;
        head.next = null;
        return reHead;// 反转后新链表的头结点  
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(5);

        SO14ReverseLinkedList solution = new SO14ReverseLinkedList();
        ListNode newNode = solution.reverseListNode(node);

        while (newNode != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
    }
}
