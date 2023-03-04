/*
Given an array of distinct integers candidates and a target integer target, return a list of all 
unique combinations of candidates where the chosen numbers sum to target. 
You may return the combinations in any order.

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findSum(candidates, result, new ArrayList<Integer>(), target, 0);
        return result;
    }

    public void findSum(int[] candidates, List<List<Integer>> result, List<Integer> list, int target, int index) 
    {
        if(index >= candidates.length){
            if(target == 0){
                result.add(new ArrayList<Integer>(list));
            }
            return;
        }
        if(candidates[index] <= target){
            list.add(candidates[index]);
            findSum(candidates, result, list, target-candidates[index], index);
            list.remove(list.size()-1);
        }
        findSum(candidates, result, list, target, index+1);
        
    }
}
