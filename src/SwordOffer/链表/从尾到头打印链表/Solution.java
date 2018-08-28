package SwordOffer.链表.从尾到头打印链表;

import SwordOffer.链表.ListNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by Weicools on 2018/4/21.
 * <p>
 * desc: 输入链表的第一个节点，从尾到头反过来打印出每个结点的值
 * 1-->2-->3
 * 3-->2-->1
 */
public class Solution {

    /**
     * 使用栈 printListFromTailToHead
     */
    public ArrayList<Integer> byStack(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }


    /**
     * 使用递归 printListFromTailToHead
     */
    public ArrayList<Integer> byRecursive(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if(listNode != null) {
            result.addAll(byRecursive(listNode.next));
            result.add(listNode.val);
        }
        return result;
    }

    /**
     * 使用集合反转 printListFromTailToHead
     */
    public ArrayList<Integer> byCollections(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        while (listNode != null) {
            result.add(listNode.val);
            listNode = listNode.next;
        }

        Collections.reverse(result);
        return result;
    }

    /**
     * 使用头插法构建逆序链表 printListFromTailToHead
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // 头插法构建逆序链表
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode temp = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = temp;
        }

        // 构建 ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        head = head.next;
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        System.out.println(solution.byStack(listNode).toString());
    }
}
