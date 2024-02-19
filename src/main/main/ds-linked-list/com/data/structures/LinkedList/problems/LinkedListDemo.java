package com.data.structures.LinkedList.problems;

import com.data.structures.LinkedList.LinkedList;

public class LinkedListDemo {

    public static void main(String[] args) {
        insertAtTail();

    }

    private static void insertAtHead() {
        LinkedList<Integer> linkedList = new LinkedList();
        linkedList.insertAtHead(10);
        linkedList.insertAtHead(20);
        linkedList.insertAtHead(30);
        linkedList.insertAtHead(40);
        linkedList.insertAtHead(50);

        linkedList.traverse();
    }

    private static void insertAtTail() {
        LinkedList<Integer> linkedList = new LinkedList();
        linkedList.insertAtTail(10);
        linkedList.insertAtTail(20);
        linkedList.insertAtTail(30);
        linkedList.insertAtTail(40);
        linkedList.insertAtTail(50);

        linkedList.traverse();
    }

    public ListNode reverseList(ListNode head) {
        ListNode new_list = null;
        ListNode current = head;

        while (current != null) {
            ListNode next_node = current.next;
            current.next = new_list;
            new_list = current;
            current = next_node;
        }


        return new_list;
    }


    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean Cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        while (head != null && head.val == val) head = head.next;
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}
