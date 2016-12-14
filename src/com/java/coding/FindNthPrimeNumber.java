package com.java.coding;

/**
* Find the 3rd, 58th and 10,001th prime number 
* @author  Ketaki Raste
* @12/12/2016 
*/

public class FindNthPrimeNumber {
     
      public static void main (String [] args){
    	  System.out.println("prime number: " + nthPrime(3));
    	  System.out.println("prime number: " + nthPrime(58));
          System.out.println("prime number: " + nthPrime(10001));
      }
     
      public static int nthPrime(int n) {
          int candidate;
          int count = 0; 
          for(candidate = 1; ; candidate+=2) { // incrementing by 2 since even numbers after 2 are not prime
              if (isPrime(candidate)) {
                  count++;
                  if(count == n){
                	  break;
                  }
              }
          }
          return candidate;
      }
     
      private static boolean isPrime(int n) {
          int sqrt = (int) Math.sqrt(n);
          
          // running loop only till squareroot
          // If n is composite, its smallest divisor is smaller than sqrt(n).
          for (int i = 2; i <= sqrt; i++) {
              if (n % i == 0) {
                  return false;
              }
          }
          return true;
      }
}

