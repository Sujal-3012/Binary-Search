**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
 //Here the problem is this solution is making too many calls to get() method of MountainArray interface 
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int s = 0;
        int e = mountainArr.length() - 1;
        int ans1 = -1;
        int ans2 = -1;
        while (s <= e){
            //Left
            int peakindex = findPeakElement(mountainArr , s ,e);
            int peak = mountainArr.get(peakindex);
            if (target > peak){
                ans1 = -1;
                break;
            } 
            if (target < peak){
                e = peakindex - 1;
            }
            else{
                return peakindex;
            }
        }

        s = 0;
        e = mountainArr.length() - 1;

        while (s <= e){
            //Right
            int peakindex = findPeakElement(mountainArr , s ,e);
            int peak = mountainArr.get(peakindex);
            if (target > peak){
                ans2 = -1;
                break;
            } 
            if (target < peak){
                s = peakindex + 1;
            }
            else{
                return peakindex;
            }
        }
        return ans1; //or ans2

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
