class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end){
            int mid = start + ( end - start ) / 2;
            if (arr[mid + 1] > arr[mid]){
                start = mid + 1;
            } else if (arr[mid - 1] > arr[mid]) {
                end = mid - 1;
            } else {
                //ans found
                //start and end are always trying to find the max. element in the above two checks , so when they are 
                //pointing to just one element , it means that it is the max one because that is what the checks say .
                return mid;
            }
        }
        return start; ////you can return end also as both are equal at last when search is complete 
    }
}
