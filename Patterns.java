//import java.util.ArrayList;

public class Patterns {

    public static void print1(int n) {
        int val = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print(val + " ");
                val++;
            }
            System.out.println();
        }

    }


     public static void isPalindromeVoid(String s) {
        String Regex = "[\\s\\p{Punct}]+";
        String []all = s.toLowerCase().split(Regex);
        String sec = new String();
        String last_sec = new String();
        for(int i = 0; i < all.length; i++) {
            sec = sec.concat(all[i]);
        }
        String []div = sec.split("");
        for(int i = 0; i < div.length; i++) {
            last_sec = last_sec.concat(div[div.length - i - 1]);
            
        }

        System.out.println(last_sec);
        //return false;
    }

    public static void reverseArray(int arr[]) {
        // code here
        int n = arr.length;
        int [] temp = new int[n];
        for(int i = 0; i < n - 1; i++) {
            temp[n - 1 - i] = arr[i];
        }
        
        System.out.println(temp.toString());
        
    }

    public static int gcd(int a, int b) {
        // code here
        if( a == 0 || b == 0) {
            if(a == 0)
                return b;
            else
                return a;
        }
        
        if( a < b) {
            return gcd(b % a, a);
        }else{
            return gcd(a % b, b);
        }
    } 
        


    public static int reverse(int x) {
        int revInt = 0;
        int k = 0;
        if(x < 0) {
            x = x * (-1);
            k = 1;
        }
        while(x > 0) {
            int lD = x % 10;
            revInt = (revInt * 10 ) + lD;
            x = x/ 10;
        }
        if(k == 1) 
            return revInt * (-1);
        else
            return revInt;

    }


    public static boolean isPalindrome(String s) {
        String Regex = "[\\s\\p{Punct}]+";
        String []all = s.toLowerCase().split(Regex);
        String sec = new String();
        String last_sec = new String();
        for(int i = 0; i < all.length; i++) {
            sec = sec.concat(all[i]);
            last_sec = last_sec.concat(all[all.length - i - 1]);
        }

        if(sec.equals(last_sec)) {
            return true;
        }else{
            return false;
        }
        
    }
    public static void main(String[] args) {
        //int n = 5;
        //print1(n);
        //int [] arr = {1,2,3,4};
        System.out.println(reverse(534236469));
        System.out.println((964632435 * 10 ) + 1);
        System.out.println(gcd(727454778, 8));
        //reverseArray(arr);;
        isPalindromeVoid("race a car");
        // boolean val = isPalindrome("race a car");
        // System.out.println(val);
    }
}

/*
 * 1
 * 2 3
 * 4 5 6
 * 7 8 9 10
 * 11 12 13 14 15
 * 
 */