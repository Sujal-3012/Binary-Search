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
        //If you find target then put it as potential ans and search again by reducing search space , because same no. may be present at other locations also .
        //In other two cases follow the same procedure of binary search .
        //If the target is not in the array then the loop will finish and you will never touch the else condition , in that case return -1 (initial ans) .
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
