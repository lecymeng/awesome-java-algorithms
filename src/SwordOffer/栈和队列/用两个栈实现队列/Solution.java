package SwordOffer.栈和队列.用两个栈实现队列;

import java.util.Stack;

/**
 * Created by Weicools on 2018/4/21.
 * <p>
 * desc: 用两个栈来实现一个队列，完成队列的Push和Pop操作
 * 队列中的元素为int类型
 */
public class Solution {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() throws Exception {
        if (out.isEmpty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }

        if (out.isEmpty()) {
            throw new Exception("queue is empty");
        }

        return out.pop();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        try {
            System.out.println(s.pop() + "");
            System.out.println(s.pop() + "");
            System.out.println(s.pop() + "");
            System.out.println(s.pop() + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
