import java.util.*;
public class Arays {

    public static void reverse(int []arr, int s, int e) {
        while(s <= e) {
            int temp = arr[e];
            arr[e] = arr[s];
            arr[s] = temp;
            s++;
            e--;
        }
    }
    public static void rotate(int[] nums, int k) {
        // int temp = 0;
        // k = k % nums.length;
        // for(int i = 0; i < k; i++) {
        //     temp = nums[nums.length -  1];
        //     for(int j = (nums.length - 1); j > 0; j--) {
        //         nums[j] = nums[j - 1]; 
        //     } 
        //     nums[0] = temp;
        // }

        reverse(nums, nums.length - k , nums.length - 1);
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, 0, nums.length - 1);

    }

    public static void zeroEnd(int []nums) {
        int count = 0;
        int j = 0;
        for(int i = 0; i < nums.length; i++) {        
                if(nums[i] == 0) {
                    continue;
                }else{
                   nums[j] = nums[i];
                    j++;
                    
                }
        }
        count = nums.length - count;
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }
    public static boolean LinearSearch(int [] arr, int num) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == num) {
                return true;
            }
        }
        return false;
    }
    public static void unionArr(int[] num1, int []num2) {
        //BRUTE FORCE
        Set<Integer> unionset = new HashSet<>();
        for(int i = 0; i < num1.length; i++) {
            unionset.add(num1[i]);
        }
        for(int i = 0; i < num2.length; i++) {
            unionset.add(num2[i]);
        }
        System.out.println(unionset);
        // ArrayList<Integer> res = new ArrayList<>();
        // res = (ArrayList<Integer>) unionset;
        // OPTIMIZED
        
        // int j = 0;
        // for(int i = 1; i < num1.length; i++) {
        //     if(num1[i] != num1[j]) {
        //         num1[j + 1] = num1[i];
        //         j++;
        //     }
        // }
        // int i = 0;
        // while (i < num2.length) {
        //     if(num2[i] == num1[k]) {
        //         continue;
        //     }

        // }
            
    }

    public static int missingNum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum = sum + nums[i];
        }
        int nS = (n * (n + 1))/ 2;
        return (nS - sum);
    }

    // public static ArrayList<Integer> findUnion(int a[], int b[]) {
    //     // add your code here
    //     ArrayList<Integer> finalRes = new ArrayList<>();
    //     int x = 0;
    //     for(int i = 0; i < a.length; i++) {
            
    //     }
    //     return finalRes;
    // }


    public static int[] twoSum(int[] nums, int target) {
        int [] res = new int[2];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum = target - nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                if(sum == nums[j]) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
        int []numZero = {0, 1, 0, 3, 12};
        zeroEnd(numZero);
        System.out.println(Arrays.toString(numZero));
        System.out.println(LinearSearch(nums, 44));
        
        // int [] num1 = {1, 1, 2, 3, 4, 5};
        // int [] num2 = {2, 3, 3, 4, 4, 5, 6};
        // unionArr(num1, num2);

        int [] num4 = {3, 0, 1};
        int k = missingNum(num4);
        System.out.println(k);
        int []numstwoSum = {2, 7, 11, 15};
        int [] newres = twoSum(numstwoSum, 9);
        System.out.println(Arrays.toString(newres));
    }
    
}
