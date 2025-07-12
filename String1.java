public class String1 {
    public static String largestOddNumber(String num) {
        for(int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if((c - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
        

        //a substring ending with an odd number is always odd, so we are looking for the index that will be odd.

        
    }

    public static String longestCommonPrefix(String[] strs) {

        /*
         * 
         * strs = ["flower","flow","flight"]
         * "fl"
         */

        for(int i = 0; i < strs.length; i++) {
            // strs[i].split(0, i);
        }
        return "";
        
    }
    public static void main(String[] args) {
        String res = largestOddNumber("56204");
        System.out.println(res);

        
    }
    
}
