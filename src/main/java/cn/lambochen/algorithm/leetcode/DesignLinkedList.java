package cn.lambochen.algorithm.leetcode;

/**
 * @author lambochen
 * <p>
 * https://leetcode.cn/problems/design-linked-list/
 */
public class DesignLinkedList {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3, 0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        list.get(4);
        list.addAtHead(4);
        list.addAtIndex(5, 0);
        list.addAtHead(6);

    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
    static class MyLinkedList {

        Node head;
        Node tail;
        int len;

        public MyLinkedList() {
            len = 0;
            head = null;
            tail = null;
        }

        public int get(int index) {
            if (index < 0 || index > len - 1) {
                return -1;
            }

            Node current = find(index);
            return current.val;
        }

        private Node find(int index) {
            if (index > (len - 1) / 2) {
                return findFromTail(index);
            }

            return findFromHead(index);
        }

        private Node findFromHead(int index) {
            Node current = head;
            while (--index >= 0) {
                current = current.next;
            }

            return current;
        }

        private Node findFromTail(int index) {
            int findIndex = len - 1 - index;
            Node current = tail;

            while (--findIndex >= 0) {
                current = current.prev;
            }

            return current;
        }

        public void addAtHead(int val) {
            Node newHead = new Node(val, null, head);
            if (null != head) {
                head.prev = newHead;
            }
            head = newHead;

            if (null == tail) {
                tail = head;
            }
            len++;
        }

        public void addAtTail(int val) {
            if (null == tail) {
                addAtHead(val);
                return;
            }

            tail.next = new Node(val, tail, null);
            tail = tail.next;
            len++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > len) {
                // do nothing
                return;
            }

            if (index == 0) {
                addAtHead(val);
            } else if (index == len) {
                addAtTail(val);
            } else {
                Node current = find(index);
                current.prev.next = new Node(val, current.prev, current);
                len++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index > len - 1) {
                // do nothing
                return;
            }

            Node current = find(index);
            if (head == current) {
                head = head.next;
            } else {
                current.prev.next = current.next;
            }
            len--;
        }

        static class Node {
            int val;

            Node prev;
            Node next;

            public Node() {
            }

            public Node(int val) {
                this.val = val;
            }

            public Node(int val, Node prev, Node next) {
                this.val = val;
                this.prev = prev;
                this.next = next;
            }

            // ignore setter/getter
        }
    }
}