class Solution {
    //This will not work for duplicate values
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int p = pivot(nums);
        int ans = -1;
        ans = BinarySearch(nums , s , p , target);
        if (ans == -1){
            ans = BinarySearch(nums , p+1 , e , target);
        }
        return ans;
    }
    public int BinarySearch(int[] arr , int start , int end , int target){
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
        return -1;
    }
    public int pivot (int[] arr){
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
Console
