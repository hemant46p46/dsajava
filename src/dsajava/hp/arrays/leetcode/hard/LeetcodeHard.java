package dsajava.hp.arrays.leetcode.hard;

public class LeetcodeHard {
/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 */
	protected int trap(int[] height) {
		if(height==null || height.length==0) {
			return 0;
		}
		int left=0, right=height.length-1, leftMax=0, rightMax=0, totalWater=0;
		
		while(left < right) {
			if(height[left] < height[right]) {
				if(height[left] >= leftMax) {
					leftMax = height[left];
				}else {
					totalWater += leftMax - height[left];
				}
				left++;
			}
			
			else {
				if(height[right] >= rightMax) {
					rightMax = height[right];
				}else {
					totalWater += rightMax - height[right];
				}
				right--;
			}
		}
		
		return totalWater;
	}

	protected int trapDP(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int totalWater = 0;
        
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            totalWater += waterLevel - height[i];
        }
        
        return totalWater;
    }
	

}
