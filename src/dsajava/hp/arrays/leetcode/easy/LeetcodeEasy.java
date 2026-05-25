package dsajava.hp.arrays.leetcode.easy;

import java.util.*;

public class LeetcodeEasy {
/*
	1. Two Sum

	Example 1:

	Input: nums = [2,7,11,15], target = 9
	Output: [0,1]
	Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
	
	Example 2:
	Input: nums = [3,2,4], target = 6
	Output: [1,2]
	
	Example 3:
	Input: nums = [3,3], target = 6
	Output: [0,1]
*/
    protected int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++) {
        	for (int j=i+1;j<nums.length;j++) {
        		if(nums[i]+nums[j]==target) {
        			return new int[] {i, j};
        		}
        	}
        }
        return new int[] {};
    }
    protected int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int comp = target - nums[i];
            if(map.containsKey(comp)){
                return new int[]{map.get(comp), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
    protected int[] towPointer(int[] nums, int target) {// only for sorted array
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int currentSum = nums[left] + nums[right];
            
            if (currentSum == target) {
                return new int[] { left, right };
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {};
    }
    
/*
 * 2. Remove Duplicates from Sorted Array
 */
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){return 0;}
        int curr=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[curr] = nums[i];
                curr++;
            }
        }
        return curr;
    }
/*
 * 3. Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
 * Return k. 
 */
    public int removeElement(int[] nums, int val) {
        int curr = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[curr] = nums[i];
                curr++;
            }
        }
        return curr;
    }
    
}
