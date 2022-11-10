class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int p = pivot(nums);
        if (p == -1){
            //perform normal BS
            return BinarySearch(nums , s , e , target);
        }
        if (nums[p] == target){
            return p;
        }
        if (target >= nums[0]){
            //search till pivot - 1 only
            return BinarySearch(nums , s , p - 1 , target);
            //==p is not taken as it would get caught in 2nd case 
        }
        else{
            return BinarySearch(nums , p+1 , e , target);
        }
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
        //process for finding pivot will change due to duplicate elements
        int s = 0;
        int e = arr.length - 1;
        int p = -1;
        while (s <= e){
            int m = s + (e - s) / 2;
            if ((m < e) && (arr[m] > arr[m + 1])){
                p = m;
            }
            if ((m > s) && (arr[m - 1] > arr[m])){
                p = m - 1;
            }
            //If elements at s , m and e are equal , just skip the duplictaes .
            if ((arr[m] == arr[s]) && (arr[m] == arr[e])){
                //skip duplicates 
                //What if elements at s and e are pivot 
                //check if s is pivot 
                if (arr[s] > arr[s + 1]){
                    return s;
                }
                s ++;
                //check if end is pivot 
                if (arr[e] < arr[e - 1]){
                    return e-1;
                }
                e--;
            }
            //left side is sorted so pivot should be on right 
            else if (arr[s] < arr[m] || (arr[s] == arr[m]) && (arr[m] > arr[e])){
                s = m + 1;
            }
            else{
                s = m - 1;
            }
        }
        return -1;
    }
}
