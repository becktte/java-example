package com.leaf.datastructure;

public class Node {
    public Node nextNode;
    public int value;

    public Node(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        addValue(node);
        printNode(node);
        Node tenode = resverse2(node);
        printNode(tenode);

    }

    public static Node resverse2(Node node) {
        if(node.nextNode == null)
            return node;
        Node next = node.nextNode;
        node.nextNode = null;
        Node re = resverse2(next);
        next.nextNode = node;
        return re;
    }


    public static Node resverse(Node node) {
        Node prev = null;
        Node now = node;
        while (now != null) {
            Node next = now.nextNode;
            now.nextNode = prev;
            prev = now;
            now = next;
        }

        return prev;
    }

    public static void printNode(Node node) {
        if (node.nextNode == null) {
            System.out.print(node.value);
            return;
        } else {
            System.out.print(node.value + "->");
        }
        printNode(node.nextNode);
    }

    public static void addValue(Node node) {
        node.nextNode = new Node(node.value + 1);
        if (node.value == 4) {
            return;
        }
        addValue(node.nextNode);
    }
}
