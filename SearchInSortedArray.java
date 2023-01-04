class SearchInSortedArray {
  public static void main(String args[]){
    int[] arr = new arr[]{2,3,6,8,9,12};
    System.out.println(search(arr, 6));
  }
  public static int search(int[] nums, int target) {
        int low = 0, high = nums.length-1, res = -1, mid;
        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] == target)
                return mid;
            
            else if(nums[mid] > nums[high]){
                 if (target >= nums[low] && target <= nums[mid]) {
                      high = mid - 1;
                    } else {
                      low = mid + 1;
                    }
                        }
            else if (target >= nums[mid] && target <= nums[high]) {
                low = mid + 1;
              } else {
                high = mid - 1;
              }
        }
        return res;
    }
}
