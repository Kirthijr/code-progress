//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
class TwoSum {
  public static void main(String args[]){
    int[] arr = new int[]{2,7,11,15};
    System.out.println(twoSum(arr, 9);
  }
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> intmap = new LinkedHashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
          
                if(intmap.containsKey(target-nums[i])){
                res[0] = intmap.get(target-nums[i]);
                res[1] = i;
                if(res[0] != res[1]){
                    return res;
                }
            }
            intmap.put(nums[i],i);
        }
        return res;
    }
}
