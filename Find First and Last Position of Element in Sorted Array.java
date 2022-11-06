class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1 , -1};
        int start = searchans(nums , target , true);
        int end = searchans(nums , target , false);

        ans[0] = start;
        ans[1] = end;
        return ans;
    }
    public int searchans(int[] nums , int target , boolean findStart){
        int ans = -1;
        int s = 0;         
        int e = nums.length - 1;         
        while (s <= e){             
            int m = s + (e - s) / 2;             
            if (target < nums[m]){                 
                e = m - 1;             
            }             
            else if (target > nums[m]){                 
                s = m + 1;             
            }             
            else{
                //potential ans found   
                ans = m;              
                if (findStart){                     
                    e = m - 1;                 
                }
                else{
                    s = m + 1;
                }             
            }         
        }         
        return ans;
    }
}
