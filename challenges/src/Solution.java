package com.hackerrank;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * QHEAP1 solution
 */
public final class Solution {
    private int[] elements;
    private int size;

    private Solution() {
    }

    private Solution(int queries) {
        this.elements = new int[queries];
        this.size = 0;
    }

    private void insert(int data) {
        if (this.size == 0) {
            this.elements[this.size] = data;
        } else {
            // add element to the end of array 
            this.elements[this.size] = data;
            // while heap property not satisfied, bubble data upwards
            int childIndex = this.size;
            int parentIndex = Math.floorDiv(childIndex, 2);
            
            while (this.elements[parentIndex] > data) {
                this.elements[childIndex] = this.elements[parentIndex];
                this.elements[parentIndex] = data;
                parentIndex = Math.floorDiv(childIndex, 2);
            }
        }

        this.size++;
    }

    private void remove(int data) {
        // elements in heap are unique (this is by assumption)
        // find element
        int index = 0;
        for (; index < this.size && this.elements[index] != data; index++) {}
        // move other elements up a position
        int dest = index;
        int src = dest+1;
        while (src < this.size) {
            this.elements[dest++] = this.elements[src++];
        }
        this.size--;
        // heapify remaining elements
        for (int current = this.size; current > 0; current--) {
            int parent = Math.floorDiv(current, 2);
            if (this.elements[current] < this.elements[parent]) {
                // swap
                int temp = this.elements[parent];
                this.elements[parent] = this.elements[current];
                this.elements[current] = temp;
            }
        }
    }

    private int peek() { return this.elements[0]; }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        
        // declare scanner 
        Scanner in = new Scanner(System.in);
        try {
            int queries = in.nextInt();
            // initializeHeap(queries);
            Solution heap = new Solution(queries); // initialize the heap
            // for the number of queries, parse and carry out each query
            for (int i = 0; i < queries; i++) {
                String query = in.nextLine().trim();
                switch (query.substring(0, 1)) {
                    case "1":
                        int insertData = Integer.valueOf(query.substring(2));
                        heap.insert(insertData);
                        break;
                    case "2":
                        // deletes element
                        int deleteData = Integer.valueOf(query.substring(2));
                        heap.remove(deleteData);
                        break;
                    case "3":
                        // print min
                        System.out.println(heap.peek());
                        break;
                    default:
                        break;
                }
            }
        } catch (NoSuchElementException nsee) {
            System.out.println("No such element exception ocurred.");
        }  catch (IndexOutOfBoundsException ie) {
            System.out.println("Index out of bounds exception ocurred.");
        }
        in.close();
    }
}
