// Given an array of integers numbers that is sorted in non-decreasing order.

// Return the indices (1-indexed) of two numbers, [index1, index2], such that they add up to a given target number target and index1 < index2. Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.

// There will always be exactly one valid solution.

// Your solution must use O(1) additional space.

package patterns.TwoPointers;

public class TwoSumTwo {
    public int[] solution(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;

        while(i < j){
            int sum = numbers[i] + numbers[j];

            // exit case for if current indices equal sum
            if(sum == target){
                return new int[]{i+1, j+1};
            }
            // if the sum is larger than the target, this means we should lower the right pointer
            else if(sum > target){
                j--;
            }else{
                i++;
            }
        }
        return null;
    }
}
