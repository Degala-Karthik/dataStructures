public class Rough {

    public static String triangleType(int[] nums) {
        
        int a = nums[0] + nums[1];
        int b = nums[1] + nums[2];
        int c = nums[0] + nums[2];

        if(a > nums[2] && b > nums[0] && c > nums[1]) {
            if(nums[0] == nums[1] || nums[1] == nums[2] || nums[2] == nums[0]){
                return "isosceles";
            }else if(nums[0] == nums[1] && nums[1] == nums[2]) {
                return "equilateral";
            }
            return "scalene";
        }

        return "none";
    }
    public static void main(String[] args) {
        int[] tri = {8, 4, 2};
        String val = triangleType(tri);
        System.out.println(val);
    }
}
