package dsajava.hp.arrays.leetcode.med;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetcodeMed {
/*
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such 
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
    
    public class ThreeSumHashSet {
        public List<List<Integer>> threeSum(int[] nums) {
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
    }
    
    public List<List<Integer>> threeSum1(int[] nums) {
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
}
