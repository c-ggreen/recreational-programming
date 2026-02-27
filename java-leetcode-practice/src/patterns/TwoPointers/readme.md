# Summary
- The two-pointer technique leverages the fact that the input array is sorted to eliminate the number of pairs we consider from O(n2) down to O(n).
- The two-pointers start at opposite ends of the array, and represent the pair of numbers we are currently considering.
- We repeatedly compare the sum of the current pair to the target, and move a pointer in a way that eliminates unnecessary pairs from our search.

# When to use:
- Finding a pair of items that sum to a given target in an array.
- Finding a triplet of items that sum to 0 in a given array.
- Finding the maximum amount of water that can be held between two array items representing wall heights.