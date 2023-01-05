class Solution {
  public static void main(String args[]){
  int[] arr = new int[]{1,3,5,6};
    //If the target is not present, return index if it was inserted in ascending order for the target.
    System.out.println(searchInsert(arr, 2)); //1
  }
    public int searchInsert(int[] arr, int target) {
        int low = 0, mid, high = arr.length-1;
        while(low<=high){
            mid = (low+high)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[low] == target){
                return low;
            }else if(arr[high] == target){
                return high;
            }
            else if(target < arr[low]){
                return low;
            }
            else if(target > arr[high]){
                return high+1;
            }
            else if(arr[mid]>arr[high]){
                if(target > arr[low] && target < arr[mid]){
                    high = mid -1;
                }else{
                    low = mid +1;
                }
            }
            else if(target > arr[mid] && target < arr[high]){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
            }
            return -1;
    }
}
