import java.util.*;


public class Hashing {
    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
       

        String s = scan.nextLine();

        
        int []cHash = new int[26];
        for(int i : cHash) {
            cHash[i] = 0;
        }
        
        for(int i = 0; i < s.length(); i++) {

            cHash[s.charAt(i) - 'a'] ++;
        }

        int qc = scan.nextInt();
        while(qc != 0) {
            char k = scan.next().charAt(0);
            System.out.println(cHash[k - 'a']);
            qc--;
        }


        int n = scan.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        HashMap <Integer, Integer> mp = new HashMap<>();
        int []hash = new int[13];
        for(int i : hash) {
            hash[i] = 0;
        }
        

        System.out.println();
        for(int i = 0; i < n; i++) {
            mp.put(i, arr[i]++);
        }


        int q = scan.nextInt();
        while (q != 0) {
            int num = scan.nextInt();
            System.out.println(mp.get(num));
            q--;
        }
        scan.close();
    }
}
