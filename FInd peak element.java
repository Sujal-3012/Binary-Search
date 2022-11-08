class Solution {
    //This is more accurate solution for finding peak element in mountain array 
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            int mid = start + ( end - start ) / 2;
            if (nums[mid] > nums[mid + 1]){
                //you are in descending part 
                //this may be the ans but look at lest 
                //hence end != mid - 1
                end = mid;
            } else{
                start = mid + 1; //because we know that mid + 1 element > mid element 
            }
        }
        return start;
        //you can return end also as both are equal at last when search is complete 
        //In the end start == end and pointing to the same number because of the two checks 
        //when only one elemnt is remaining , that is the best possible ans 
    }
}
Console
