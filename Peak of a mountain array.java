class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + ( end - start ) / 2;
            if (arr[mid + 1] > arr[mid]){
                start = mid + 1;
            } else if (arr[mid - 1] > arr[mid]) {
                end = mid - 1;
            } else {
                //ans found
                return mid;
            }
        }
        return -1;
    }
}
