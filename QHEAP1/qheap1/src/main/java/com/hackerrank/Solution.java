package com.hackerrank;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Hello world!
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
        }

        this.size++;
    }

    private void remove(int data) {}

    private int peek() { return -1; }

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
