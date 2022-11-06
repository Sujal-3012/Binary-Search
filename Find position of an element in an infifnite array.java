//To find the position of an element in an infinite rray of sorted elements
public class Q2 {
    public static void main(String[] args) {
        int[] arr = {3 , 5 , 7 , 9 , 10 , 90 , 100 , 130 , 140 , 160 , 170};
        int target = 10;
        System.out.println("index of target is " + ans(arr , target));
    }

    static int ans(int [] arr , int target){
        //first find range
        //first take a box of two
        int s = 0;
        int e = 1;

        //If target is greater than end then you will not find the element in range hence
        //change the range and double its size
        while (target > arr[e]){
            int newStart = e + 1;
            //here I can't directly say s = e + 1 as I have to use the value of s later
            //double the size of box
            e = e + (e - s + 1) * 2;
            s = newStart;
        }

        return binary_search(arr , target , s , e);
    }

    static int binary_search(int [] arr , int target , int start , int end){
        //In this BS start and end we will take from main fn .
        while (start <= end){
            int mid = start + ( end - start ) / 2;
            if (arr[mid] > target){
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                //ans found
                return mid;
            }
        }
        return -1; // This lne will only execute when nothing has been returned till now
    }
}
