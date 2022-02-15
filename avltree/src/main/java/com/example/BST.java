package com.example;

import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E>> {
    private class Node {
        public E data;
        public Node left;
        public Node right;

        public Node(E data) { this.data = data; }
    }

    // root of BST
    private Node root;
    // size (# of nodes) of BST
    private int size;

    // constructor
    public BST() {
        this.root = null;
    }

    // insert
    public void insert(E data) {
        Node newData = new Node(data);
        if (this.size == 0) { 
            this.root = newData;
            this.size++;
        } else {
            boolean inserted = false;
            Node currentNode = this.root;
            while (!inserted) {
                int comparison = data.compareTo(currentNode.data);
                if (comparison <= 0) {
                    if (currentNode.left == null) {
                        currentNode.left = newData;
                        this.size++;
                        inserted = true;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = newData;
                        this.size++;
                        inserted = true;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
           
        }
    }

    // Delete a node containing given data.
    public void delete(E data) {
        // find node
        boolean found = false;
        Node currentNode = this.root;
        Node parentNode = null;
        while (!found && currentNode != null) {
            if (data.compareTo(currentNode.data) == 0) {
                found = true;
            } else if (data.compareTo(currentNode.data) <= 0) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else {
                parentNode = currentNode;
                currentNode = currentNode.right;
            }
        }

        if (found) {
            // case 1: node is a leaf
            if (currentNode.left == null && currentNode.right == null) {
                // case 1.1 currentNode is root
                if (parentNode == null) {
                    this.root = null;
                    this.size = 0;
                }
                // case 1.2 currentNode is not root
                else {
                    // case 1.2.1 currentNode is a left child
                    if (data.compareTo(parentNode.data) <= 0) {
                        parentNode.left = null;
                        this.size--;
                    }
                    // case 1.2.2 currentNode is a right child
                    else {
                        parentNode.right = null;
                        this.size--;
                    }
                }
            }
            // case 2: node has a single child
            else if (currentNode.left == null || currentNode.right == null) {
                Node replacement = currentNode.left != null ? currentNode.left : currentNode.right;
                // case 2.1 currentNode is root
                if (parentNode == null) {
                    this.root = replacement;
                    this.size--;
                }
                // case 2.1 currentNode is not root
                else {
                    if (parentNode.left == currentNode) {
                        parentNode.left = replacement;
                        this.size--;
                    } else {
                        parentNode.right = replacement;
                        this.size--;
                    }
                }
            }
            // case 3: node has two children
            else {
                // retrieve direct predecessor in order to replace removed node
                Node subTreeRoot = currentNode.left;
                Node predecessor = subTreeRoot;
                while (predecessor.right != null) {
                    subTreeRoot = predecessor;
                    predecessor = predecessor.right;
                }
                // replace predecessor node if necessary
                // else set subtree root right child to null
                if (predecessor.left != null) {
                    subTreeRoot.right = predecessor.left;
                } else {
                    subTreeRoot.right = null;
                }
                // case 3.1 replace root
                if (parentNode == null) {
                    predecessor.left = predecessor != this.root.left ? this.root.left : null;
                    predecessor.right = predecessor != this.root.right ? this.root.right : null;
                    this.root = predecessor;
                    this.size--;
                }
                // case 3.2 replace non-root
                else {
                    if (data.compareTo(parentNode.data) <= 0) {
                        parentNode.left = predecessor;
                        predecessor.left = predecessor != currentNode.left ? currentNode.left : null;
                        predecessor.right = predecessor != currentNode.right ? currentNode.right : null;
                        this.size--;
                    } else {
                        parentNode.right = predecessor;
                        predecessor.left = predecessor != currentNode.left ? currentNode.left : null;
                        predecessor.right = predecessor != currentNode.right ? currentNode.right : null;
                        this.size--;
                    }
                }
            }
        }
        
    }

    // TODOS
    // balance tree

    // DFS
    public boolean DFS(E data) {
        boolean found = false;
        Node currentNode = root;

        while (currentNode != null && !found) {
            int comparision = data.compareTo(currentNode.data);

            if (comparision == 0) { found = true; }
            else if (comparision < 0) { currentNode = currentNode.left; }
            else { currentNode = currentNode.right; }
        }

        return found;
    }

    // BFS - obviously in a BST this makes no sense, but hey, practice.
    public boolean BFS(E data) {
        boolean found = false;
        if (this.root != null) {
            Queue<Node> unvisited = new LinkedList<Node>();
            unvisited.add(this.root);

            while (!found && unvisited.peek() != null) {
                Node currentNode = unvisited.remove();

                if (data.compareTo(currentNode.data) == 0) { found = true; }
                else { 
                    if (currentNode.left != null) { unvisited.add(currentNode.left); }
                    if (currentNode.right != null) { unvisited.add(currentNode.right); }
                }
            }
        }
        return found;
    }
}
