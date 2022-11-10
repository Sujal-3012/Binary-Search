//To find the rotation count in rotated sorted array . 
public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int p = pivot(arr) + 1;
        System.out.println("Array is rotated : " + p + " times");
    }
    public static int pivot (int[] arr){
        int s = 0;
        int e = arr.length - 1;
        int p = -1;
        while (s <= e){
            int m = s + (e - s) / 2;
            if ((m < e) && (arr[m] > arr[m + 1])){
                p = m;
            }
            if ((m > 0) && (arr[m - 1] > arr[m])){
                p = m - 1;
            }
            if (arr[s] >= arr[m]){
                e = m - 1;
            }
            if (arr[s] < arr[m]){
                s = m + 1;
            }
        }
        return p;
    }
}
