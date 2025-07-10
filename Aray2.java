
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Aray2 {

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

    public static int[] twoSumBetter(int[] nums, int target) {
        int [] res = new int[2];
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            target = target - nums[i];
            if(mp.containsKey(target)) {
                res[0] = mp.get(target);
                res[1] = i;
                
            }
            mp.put(nums[i], i);
        }
        return res;
    }

    public static int[] twoSumOpt(int[] nums, int target) {
        Arrays.sort(nums);
        int [] res = new int[2];
        int left = nums[0];
        int right = nums[nums.length - 1];
        int sum = nums[left] + nums[right];
        while (left <= right || sum == target) {
            if(sum < target) {
                left ++;
            }else if(sum > target) {
                right ++;
            }
        }
        res[0] = left;
        res[1] = right;
        return res;
    }

    public static void sortAr(int [] nums) {
        int count0 = 0;
        int count1 = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                count0++;
            }else if(nums[i] == 1) {
                count1++;
            }

        }

        for(int i = 0; i < count0; i++) {
            nums[i] = 0;
        }

        for(int i = count0; i < (count0 + count1); i++) {
            nums[i] = 1;
        }

        for(int i = count0 + count1; i < nums.length ; i++) {
            nums[i] = 2;
        }
    }

    public static void dutchNatFlagAlgo(int [] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            int temp = 0;
            if(nums[mid] == 0) {
                temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else if(nums[mid] == 1){
                mid++;
            }else {
                temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high --;
            }
            
        }

    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int s = 0, e = 0, track = 0, count = 0;
        int maxCount = Integer.MIN_VALUE;
        while(e != (nums.length)) {
            if(nums[e] == nums[s]) {
                count++;
                e++;
            }else {
                if(count > maxCount) {
                    track = nums[s];
                    s = e;
                    maxCount = count;
                }else{
                    s = e;

                }
                
                count = 0;
            }

            if(e == nums.length - 1) {
                count++;
                if(count > maxCount) {
                    track = nums[s];
                    maxCount = count;
                }
            }
        }

        return track;
    }

    public static int majorityElementBetter(int[] nums) {
        HashMap<Integer, Integer> majorElem = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int value = majorElem.getOrDefault(nums[i],0);
            majorElem.put(nums[i], value);
        }

        for(Map.Entry<Integer, Integer> it : majorElem.entrySet()){
            if(it.getValue() > nums.length / 2) {
                return it.getKey();
            }
        }

        
        return -1;
    }

    public static void main(String[] args) {
        int []numstwoSum = {2, 7, 11, 15};
        int [] newres = twoSum(numstwoSum, 9);
        System.out.println(Arrays.toString(newres));

        int []numstwoSumBetter = {2, 6, 5, 8, 11};
        int [] newres2 = twoSum(numstwoSumBetter, 14);
        System.out.println(Arrays.toString(newres2));

        int []numstwoSumOpt = {2, 6, 5, 8, 11};
        int [] newresOpt = twoSum(numstwoSumOpt, 14);
        System.out.println(Arrays.toString(newresOpt));

        int [] sortAr12 = {2,0,2,1,1,0};
        sortAr(sortAr12);
        System.out.println(Arrays.toString(sortAr12));

        int [] sortArDNF = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0};
        dutchNatFlagAlgo(sortArDNF);
        System.out.println(Arrays.toString(sortArDNF));

        // int [] majorityElem = {2, 2, 3, 3, 1, 2, 2};
        int [] majorityElem1 = {1 , 3 , 1, 1, 4, 1, 1, 5, 1, 1, 6, 2, 2};
        // int ans = majorityElement(majorityElem);
        // System.out.println(Arrays.toString(majorityElem));
        // System.out.println(ans);

        int ans1 = majorityElement(majorityElem1);
        System.out.println(Arrays.toString(majorityElem1));
        System.out.println(ans1);
    }
    
}
