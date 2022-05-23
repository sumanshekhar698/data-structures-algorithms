package com.dsa.general;
import java.io.*;
import java.util.*;
public class CandidateCode {
   public static boolean isPrime(int n)
   {
      if(n == 1)
        return false;

      if(n == 2 || n == 3)
        return true;

      if(n%2 == 0 || n%3 == 0)
        return false;

      for(int i=5 ; i*i <= n ; i += 6)
      {
         if(n%i ==0 || n%(i+2) == 0)
           return false;
      }

      return true;
   }
   public static void main(String args[] ) throws Exception {

	//Write code here

    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();

    while(t-- >0)
    {
       int left = sc.nextInt();
       int right = sc.nextInt();
       
       int min = Integer.MAX_VALUE;
       int max = Integer.MIN_VALUE;

       boolean checked = false;

       for(int i= left ; i<= right ; i++)
       {
          if(isPrime(i) == true)
          {
            min = Math.min(min , i);
            max = Math.max(max , i);

            checked = true;
          }
       }

       if(checked == false)
         System.out.println(-1);

       else
         System.out.println(max - min);
    }

   }
}