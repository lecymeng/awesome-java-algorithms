package swordoffer;

import java.util.Stack;

/**
 * Created by Weicools on 2018/4/21.
 * <p>
 * desc: 用两个栈来实现一个队列，完成队列的Push和Pop操作
 * 队列中的元素为int类型
 *
 * link: https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class SO05ImplQueueByTwoStack {
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
        SO05ImplQueueByTwoStack s = new SO05ImplQueueByTwoStack();
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
