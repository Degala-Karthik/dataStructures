
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

    public static int longestConsecutive(int[] nums) {
        //Optimal Approach
        // Using hashSets
        if (nums.length == 0) {
            return 0;
        }
        HashSet <Integer> seq = new HashSet<>();
        int longest = 1;
        for(int i = 0; i < nums.length; i++) {
            seq.add(nums[i]);
        }
        
        for(int i : seq) {
            if(!seq.contains(i - 1)){
                //If n - 1 is not in the set, then n will be the start of the sequence
                int count = 1;
                int x = i;
                while (seq.contains(x + 1)) {
                    
                    x = x + 1;
                    count = count + 1;
                }
                longest = Math.max(longest, count);
            }

        }
        return longest;
    }

//Set Matrix Zeroes
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        HashSet<Integer> trackRows = new HashSet<>();
        HashSet<Integer> trackCols = new HashSet<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    trackRows.add(i);
                    trackCols.add(j);
                    
                } 
            }
        }

        for(int rr : trackRows) { // for the coloumns
            for(int k = 0; k < n; k++) {
                matrix[rr][k] = 0;
                System.out.println(rr + " " + k);
            }
        }

        for(int cc : trackCols) { // for the rows
            for(int k = 0; k < m; k++) {
                matrix[k][cc] = 0;
                System.out.println(cc + " " + k);
            }
        }
    }

    public static void setZeroesOpt(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int col0 = 1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;

                    if(j != 0) {
                        matrix[0][j] = 0;
                    } else{
                        col0 = 0;
                    }
                }
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(matrix[i][j] != 0) {
                    if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if(matrix[0][0] == 0) {
            for(int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        if(col0 == 0) {
            for(int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void rotate(int[][] matrix) {
        int [][] result = new int[matrix.length][matrix.length];

        for(int i = 0; i < matrix.length; i++) { 
            for(int j = 0; j < matrix.length; j++) {
                result[j][matrix.length - 1 - i] = matrix[i][j];
            }
            
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++){
                System.out.print(result[i][j] + " ") ;
            }
            System.out.println();
        }
    }

    public static void rotateOpt(int[][] matrix) {
        int n = matrix.length;
        // Reversing each Column
        for(int i = 0; i < n; i++) { 
            for(int j = 0; j <n / 2; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[n - 1- j][i];
                matrix[n - 1 - j][i] = temp;
                
            }
        }
        // We just need to swap elements from lower triangle to upper triangle
        for(int i = 0; i < n; i++) { 
            for(int j = 0; j < n ; j++) {
                if(i != j && i < j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }else{
                    continue;
                }
            }
        }

        for(int i = 0; i < n; i++) { 
            for(int j = 0; j <n; j++) {
                System.out.print(matrix[i][j] + "   ") ;
            }
            System.out.println();
        }
    }


    public static void spiralOrder(int[][] matrix) {
        

        int m = matrix.length - 1;
        int n = matrix[0].length - 1;;
        int left = 0, top = 0;
        int bottom = m, right = n;
        while (right >= left) {
            for(int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + ", ");
            }
            top ++;
            for(int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + ", ");
            }
            right --;
            if(top <= bottom){ // to ensure the top hasn't exceeded bottom
                for(int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + ", ");
                }
                bottom --;
            }
            if(left <= right){ //to ensure the left hasn't exceeded right
                for(int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + ", ");
                }
                left ++;
            }
        }   

    }
    public static void main(String[] args) {
        int []nums = {3, 1, -2, -5, 2, -4};
        int []res = rearrange(nums);
        System.out.println(Arrays.toString(res));
        
        int[] a = {100, 200, 1, 2, 3, 4};
        int ans = longestConsecutive(a);
        System.out.println(ans);

        int [][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        int [][] matrix1 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroesOpt(matrix1);
        for(int i = 0; i < matrix1.length; i++) {
            for(int j = 0; j < matrix1[i].length; j++){
                System.out.print(matrix1[i][j] + " ") ;
            }
            System.out.println();
        }
        System.out.println();
        int [][] mat90 = {{1,2,3}, {4,5,6}, {7,8,9}};
        rotate(mat90);
        System.out.println();
        int [][] mat904 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        rotateOpt(mat904);

        int [][] matSpiral = {{1,2,3}, {4,5,6}, {7,8,9}};
        spiralOrder(matSpiral);
        
        int [][] matSpir1 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        System.out.println();
        spiralOrder(matSpir1);
        //1,2,3,4,8,12,11,10,9,5,6,7

    }
    
}
