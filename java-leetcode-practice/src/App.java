import java.util.Arrays;

import patterns.TwoPointers.ContainerWithMostWater;
import patterns.TwoPointers.MoveZeroes;
import patterns.TwoPointers.TwoSum;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new TwoSum().solution(new int[]{1,3,4,6,8,10,13}, 13));
        System.out.println(new ContainerWithMostWater().solution(new int[]{3,4,1,2,2,4,1,3,2}));
        System.out.println(Arrays.toString(new MoveZeroes().solution(new int[]{2,0,4,0,9})));
    }
}
