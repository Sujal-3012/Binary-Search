/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
     //We cannot directly apply BS on a mountain array as it is not sorted in one way , so first we have to divide our array in two parts in which either 
     //the order should be ascending or descending , we can do this by using peak element , from start to peak it is ascending and from peak + 1 to end , 
     //it is descending .  Use BS in them separately .  
        int s = 0;
        int e = mountainArr.length() - 1;
        int peak = findPeakElement(mountainArr , s , e);
        int ans = binarySearch(mountainArr , target , s , peak ,true);
        if (ans == -1){
            ans = binarySearch(mountainArr , target , peak + 1 , e , false);
        }
        return ans;
    }

    public int binarySearch(MountainArray mountainArr , int target , int start , int end , boolean orderAsc){
     //This is order agnostic binary search
        if (orderAsc){
            while (start <= end){
                int mid = start + ( end - start ) / 2;
                int middle = mountainArr.get(mid);
                if (middle > target){
                    end = mid - 1;
                } else if (middle < target) {
                    start = mid + 1;
                } else {
                    //ans found
                    return mid;
                }
            }
            return -1; 
        } else {
            while (start <= end){
                int mid = start + ( end - start ) / 2;
                int middle = mountainArr.get(mid);
                if (middle > target){
                    start = mid + 1;
                } else if (middle < target) {
                    end = mid - 1;
                } else {
                    //ans found
                    return mid;
                }
            }
            return -1; 
        }
        
        
    }
    public int findPeakElement(MountainArray mountainArr , int start , int end) {
        while (start < end){
            int mid = start + ( end - start ) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)){
                end = mid;
            } else{
                start = mid + 1; 
            }
        }
        return start;
    }
}
Console
