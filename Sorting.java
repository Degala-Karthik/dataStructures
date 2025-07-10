
import java.util.ArrayList;
import java.util.Arrays;

public class Sorting {

//SELECTION SORT
    
    public static void selectSort(int arr[]) {
           int n = arr.length;

           for(int i = 0; i <= n - 2; i++) {
            int min = i;
            for(int j = i; j <= n -1; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
            
           }
    }

//BUBBLE SORT

    public static void bubbleSort(int arr[]) {
        
        // we check for the largest elem and send it to the last
        int n = arr.length;

        for(int i = n - 1; i >= 0 ; i--) {
            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

//INSERTION SORT

    public static void insertionSort(int [] arr) {
        int n = arr.length;

        for(int i = 0; i <= n - 1 ; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

//MERGE SORT

    public static void mergeSort(int [] arr, int low, int high) {
        if(low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int [] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while(left <= mid && right <= high) {
            if(arr[left] < arr[right]){
                temp.add(arr[left]);
                left ++;
            }else{
                temp.add(arr[right]);
                right ++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left ++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right ++;
        }

        for(int i = low; i <= high ; i++) {
            arr[i] = temp.get(i - low);
        }
    }

// QUICK SORT
    public static void quickSort(int [] arr, int low, int high) {
        if(low < high) {
            int partitionIndex = partitionFunct(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }
    public static int partitionFunct(int []arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        int temp = 0;
        while(i < j) {
            while(arr[i] <= arr[pivot] && i <= high) {
                i++;
            }

            while (arr[j] >= arr[pivot] && j >= low)  {
                j--;
            }
            if(i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }
    public static void main(String[] args) {
        int [] arr = {13, 46, 24, 52, 20, 9};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
        int [] arr1 = {13, 46, 24, 52, 20, 9};
        bubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));
        int [] arr2 = {13, 46, 24, 52, 20, 9};
        insertionSort(arr2);
        System.out.println(Arrays.toString(arr2));
        int [] arr3 = {13, 46, 24, 52, 20, 9};
        mergeSort(arr3, 0, 5);
        System.out.println(Arrays.toString(arr3));
        int [] arr4 = {13, 46, 24, 52, 20, 9};
        mergeSort(arr4, 0, 5);
        System.out.println(Arrays.toString(arr4));
    }
    
}
