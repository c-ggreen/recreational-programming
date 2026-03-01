// Description
// Given an integer array nums, write a function to rearrange the array by moving all zeros to the end while keeping the order of non-zero elements unchanged. Perform this operation in-place without creating a copy of the array.
package patterns.TwoPointers;


public class MoveZeroes {

    // [2,0,4,0,9]
    public int[] solution(int[] nums){
        int swapIndex = 0; // Will represent the indices containing a 0 for swapping.
        for (int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[swapIndex];
                nums[swapIndex] = nums[i];
                nums[i] = temp;
                swapIndex++;
            }
        }
        return nums;
    }
}
