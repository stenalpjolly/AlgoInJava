package com.stenal.pp;

/*
Author: Stenal P Jolly
Problem:
5. Find the kth element from last in a linked list in O(N) complexity.
Input: Head node in the linked list and the value of “k”
Output: Value of Kth node
 */

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }

    public Node append(int new_data) {
        next = new Node(new_data);
        return next;
    }
}

public class KLastNode {

    Integer getNthFromLast(Node head, int n) {
        if (n <= 0) return null;

        Node mainPtr = head;
        Node refPtr = head;
        if (head != null) {
            for (int count = 0; count < n; count++) {
                if (refPtr == null) {
                    return null;
                }
                refPtr = refPtr.next;
            }
            while (refPtr != null) {
                mainPtr = mainPtr.next;
                refPtr = refPtr.next;
            }
            return mainPtr.data;
        }
        return null;
    }


    public static void main(String[] args) {
        Test test = new Test();
        if (test.runTest()) {
            System.out.println("All test passed");
        }else {
            System.out.println("Tests failed");
        }
    }

    static class Test {
        boolean runTest(){
            boolean result = true;
            result &= test();
            result &= test2();
            result &= test3();
            result &= test4();
            return result;
        }

        boolean test(){
            KLastNode kLastNode = new KLastNode();
            Node root = new Node(12);
            root.append(20).append(4).append(15).append(35);
            return kLastNode.getNthFromLast(root, 1) == 35;
        }

        boolean test2(){
            KLastNode kLastNode = new KLastNode();
            Node root = new Node(12);
            root.append(20).append(4).append(15).append(35);
            return kLastNode.getNthFromLast(root, 0) == null;
        }

        boolean test3(){
            KLastNode kLastNode = new KLastNode();
            Node root = new Node(12);
            root.append(20).append(4).append(15).append(35);
            return kLastNode.getNthFromLast(root, 100) == null;
        }

        boolean test4(){
            KLastNode kLastNode = new KLastNode();
            Node root = new Node(12);
            root.append(20).append(4).append(15).append(35);
            return kLastNode.getNthFromLast(root, 4) == 20;
        }
    }
}
