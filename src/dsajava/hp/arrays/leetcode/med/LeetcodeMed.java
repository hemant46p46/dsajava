package dsajava.hp.arrays.leetcode.med;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dsajava.hp.utility.Utility;

public class LeetcodeMed {
/*
 * 1. Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such 
 * that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 */
    protected List<List<Integer>> threeSum(int[] num) {
    	Set<List<Integer>> uniqueTrip = new HashSet<>();
    	int n = num.length;
    	for(int i=0;i<n-2;i++) {
    		for(int j=i+1;j<n-1;i++) {
    			for(int k=j+1;k<n;k++) {
    				if(num[i] + num[j] + num[k] == 0) {
    					List<Integer> trip = Arrays.asList(num[i], num[j], num[k]);
    					Collections.sort(trip);
    					uniqueTrip.add(trip);
    				}
    			}
    		}
    	}
    	return new ArrayList<>(uniqueTrip);
    }
    protected List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> uniqueTriplets = new HashSet<>();
        Set<Integer> duplicatedFirstElements = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!duplicatedFirstElements.add(nums[i])) continue;
            
            Set<Integer> seen = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int complement = -nums[i] - nums[j];
                
                if (seen.contains(complement)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                    Collections.sort(triplet);
                    uniqueTriplets.add(triplet);
                }
                seen.add(nums[j]);
            }
        }
        return new ArrayList<>(uniqueTriplets);
    }
    protected List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
        	if (nums[i] > 0) break; 
            
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
            
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    while (left < right && nums[left] == nums[left + 1]) left++;
                
                    while (left < right && nums[right] == nums[right - 1]) right--;                    
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
   
/*
 * 2.Given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 */
    protected int maxArea(int[] height) {
    	int left=0, right=height.length-1, maxWater=0;
    	while(left < right) {
    		int width = right - left;
    		int currHeight = Math.min(height[left], height[right]);
    		int currWater = currHeight * width;
    		
    		maxWater = Math.max(maxWater, currWater);
    		
    		if(height[left] < height[right]) {
    			left++;
    		}else {
    			right--;
    		}
    	}
    	return maxWater;
    }
    protected int maxAreaOptimized(int[] height) {// It bypasses the overhead of recalculating width, height, and maximums for lines that mathematically cannot yield a larger volume.
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            maxWater = Math.max(maxWater, minHeight * width);            
            if (height[left] < height[right]) {
                int currentLeftHeight = height[left];
                while (left < right && height[left] <= currentLeftHeight) {
                    left++;
                }
            } else {
                int currentRightHeight = height[right];
                while (left < right && height[right] <= currentRightHeight) {
                    right--;
                }
            }
        }
        return maxWater;
    }
    
/*
 * 3. Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */
    protected boolean containsNearbyDuplicate(int[] nums, int k) {
    	Set<Integer> set = new HashSet<>();
    	for(int i=0;i<nums.length;i++) {
    		if(set.contains(nums[i])) {
    			return true;
    		}
    		set.add(nums[i]);
    		if(set.size() > k) {
    			set.remove(nums[i-k]);
    		}
    	}
        return false;
    }
    

/*
 * 4. Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */
    protected List<List<Integer>> permute(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		bktUlt(nums, 0, res);
		return res;
	}
	private void bktUlt(int[] nums, int start, List<List<Integer>> res) {
		if(start == nums.length) {
			List<Integer> per = new ArrayList<>(nums.length);
			for(int n:nums) {
				per.add(n);
			}
			res.add(per);
			return;
		}
		for(int i=start; i<nums.length; i++) {
			Utility.swap(nums, start, i);
			bktUlt(nums, start+1, res);
			Utility.swap(nums, start, i);
		}
	}
}
