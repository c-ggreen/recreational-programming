// Description
// Given an array heights where each element represents the height of a vertical line, pick two lines to form a container. Return the maximum area (amount of water) the container can hold.
package patterns.TwoPointers;

public class ContainerWithMostWater {
    public int solution(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = 0;
        while (left < right) {
            int width = right - left;
            // The height can only be as tall as the lowest wall since the water would spill out of the bucket
            int height = Math.min(heights[left], heights[right]); 
            int area = width * height;
            if (area > max)
                max = area;
            
            // Whichever wall is lower should be moved up or down
            if (heights[right] > heights[left]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
