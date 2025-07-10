
import java.util.*;

public class Aray3 {
   
    public static int[] rearrange(int []nums) {
        int []ans = new int[nums.length];
        int p = 0, n = 1;
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                if(nums[i] > 0) {
                    ans[p] = nums[i];
                    p += 2;
                }else{
                    ans[n] = nums[i];
                    n += 2;
                }
            }else{
                if(nums[i] > 0) {
                    ans[p] = nums[i];
                    p += 2;
                }else{
                    ans[n] = nums[i];
                    n += 2;
                }
            }
        }

        
        return ans;
    }
    public static void main(String[] args) {
        int []nums = {3, 1, -2, -5, 2, -4};
        int []res = rearrange(nums);
        System.out.println(Arrays.toString(res));
        
        
    }
    
}
