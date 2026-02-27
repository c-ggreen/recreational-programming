// Description
// Given a sorted array of integers nums, determine if there exists a pair of numbers that sum to a given target.
package patterns.TwoPointers;

public class TwoSum {
    public boolean solution(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int sum = nums[left] + nums[right];
            if( sum == target){
                return true;
            }
            else if(sum > target){
                right--;
            }
            else{
                left++;
            }
        }
        return false;
    }
}
