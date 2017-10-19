/*
 * Uses a linked list to implement the sieve of
 * Eratosthenes algorithm for finding prime numbers
 * Typed by David Johnson, October 8, 2017
 * from "Building Java Programs" 4th Edition 
 * for CS211 course, Bellevue College
 */

package sieve;

import java.util.*;

public class Sieve {
    
    /*
     * TODO:
     * Stop when the first element of the numbers list is greater than the
     * square root of the maximum, because any numbers this large cannot have
     * any multiples remaining in the list.
    
     * Initial list of numbers doesn't need to store every integer from 2
     * through the maximum.  It an instead store 2 and each odd integer up
     * to the maximum, because no other even numbers are prime.
    */

    public static void main(String[] args) {
        System.out.println("This program will tell you all prime");
        System.out.println("numbers up to a given maximum.");
        System.out.println();
        
        Scanner console = new Scanner(System.in);
        System.out.print("Maximum number? ");
        int max = console.nextInt();
        
        List<Integer> primes = sieve(max);
        System.out.println("Prime numbers up to " + max + ":");
        System.out.println(primes);
    }
    
    // Returns a list of all prime numbers up to a given max
    // using a sieve of Eratosthenes algorithm.
    public static List<Integer> sieve(int max) {
        List<Integer> primes = new LinkedList<>();
        
        // Add all numbers from 2 to max to a list
        List<Integer> numbers = new LinkedList<>();
        for(int i = 2; i <= max; i++) {
            numbers.add(i);
        }
        
        while(!numbers.isEmpty()) {
            // Removed a prime number form the front of the list
            int front = numbers.remove(0);
            primes.add(front);
            
            // Remove all multiples of this prime number
            Iterator<Integer> itr = numbers.iterator();
            while(itr.hasNext()) {
                int current = itr.next();
                if(current % front == 0) {
                    itr.remove();
                }
            }
        }
        return primes;
    }
    
}
