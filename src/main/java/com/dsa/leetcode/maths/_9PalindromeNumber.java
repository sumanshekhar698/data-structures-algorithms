package com.dsa.leetcode.maths;

public class _9PalindromeNumber {
    //    https://leetcode.com/problems/palindrome-number
    public static void main(String[] args) {
        System.out.println(isPalindromeSlightChange(121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)//negative numbers can never be palindrome
            return false;
        if (x <= 9)//all single digit numbers are palindrome
            return true;

        //Using the concept of reversing the number using log
        int length = (int) (Math.log10(x) + 1);//number of digits
        length -= 1;//for the loop to work well, decrease by one
        int temp = x, digit, result = 0, counter = 0;
        while (temp > 0) {
            digit = temp % 10;//extract the digit
            temp /= 10;//update the temp
            result += digit * (int) Math.pow(10, length--);//update the result via placing the last number at first
        }
        return result == x;

    }


    public static boolean isPalindromeSlightChange(int x) {
        if (x < 0)//negative numbers can never be palindrome
            return false;
        if (x <= 9)//all single digit numbers are palindrome
            return true;

        int result = 0, temp = x, digit;
        //Using the concept of reversing the number using mathematics

        while (temp > 0) {
            digit = temp % 10;
            result = result * 10 + digit;
            temp /= 10;
        }

        return result == x;

    }


    public boolean isPalindrome2(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0))
            return false;

        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);

        /*The reason why the function checks if x is equal to rev divided by 10 is because there are some palindromes that have a leading 0. For example, 0101 is a palindrome, but the function would not return true for this number if it only checked if x is equal to rev.

When the function divides rev by 10, it is essentially removing the leading 0 from rev. This allows the function to check if the number is equal to the reversed version of itself, even if the number has a leading 0.

Here is an example of how the function would work for a number with a leading 0:

int x = 0101;
boolean isPalindrome = isPalindrome(x);

System.out.println(isPalindrome); // true
In this case, the function would return true because 0101 is a palindrome. The function is able to do this because it checks if x is equal to rev divided by 10, which is 101.*/
    }
}
