package dsajava.hp.arrays.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestPermutes {
	public static void main(String[] args) {
		int[] a = {1, 2, 3};
//		printAllPermutations(a);
//		printAllPermutationsBT(a);
		
		System.out.println(permuteUltimate(a));
	}
	
	
	// 1
	protected static void printAllPermutationsBT(int[] nums) {
		boolean[] used = new boolean[nums.length];
		backtrack(nums, new ArrayList<>(), used);
	}
	private static void backtrack(int[] nums, List<Integer> curr, boolean[] used) {
		if(curr.size() == nums.length) {
			System.out.println(curr);
			return;
		}
		for(int i=0;i<nums.length;i++) {
			if(used[i]) {continue;}
			
			curr.add(nums[i]);	// 1. choose one element
			used[i] = true;
			
			backtrack(nums, curr, used); // 2. recursion
			
			used[i] = false;
			curr.remove(curr.size()-1); // 3. backtrack (un-choose element)
		}
	}
	
	// 2
	protected static List<List<Integer>> permute(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		
		boolean[] used = new boolean[nums.length];
		
		bkt(nums, new ArrayList<>(), used, res);
		
		return res;
	}
	private static void bkt(int[] nums, ArrayList<Integer> curr, boolean[] used, List<List<Integer>> res) {
		if(curr.size() == nums.length) {
			res.add(new ArrayList<>(curr));
			return;
		}
		for(int i=0;i<nums.length;i++) {
			if(used[i]) {continue;}
			
			used[i] = true;
			curr.add(nums[i]);
			
			bkt(nums, curr, used, res);
			
			used[i] = false;
			curr.remove(curr.size()-1);
		}
	}
	
	// 3
	protected static void printAllPermutations(int[] nums) {
		Arrays.sort(nums);
		while(true) {
			System.out.println(Arrays.toString(nums));
			int i = nums.length - 2;
			while(i>=0 && nums[i]>=nums[i+1]) {
				i--;
			}
			if(i<0) {break;}
			
			int j= nums.length - 1;
			while(nums[j] < nums[i]) {
				j--;
			}
			
			swap(nums, i, j);
			reverse(nums, i+1, nums.length-1);
		}
	}
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i]; nums[i] = nums[j]; nums[j] = temp;
	}
	private static void reverse(int[] nums, int start, int end) {
		while(start < end) {
			swap(nums, start++, end--);
		}
	}
	
	// 4
	protected static List<List<Integer>> permuteOpt1(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		bktOpt(nums, 0, new ArrayList<>(), res);
		return res;
	}
	private static void bktOpt(int[] nums, int mask, List<Integer> curr, List<List<Integer>> res) {
		if(curr.size() == nums.length) {
			res.add(new ArrayList<>(curr));
			return;
		}
		for(int i=0;i<nums.length;i++) {
			if((mask & (1<<i))!=0) {
				continue;
			}
			curr.add(nums[i]);
			bktOpt(nums, mask | (1<<i), curr, res);
			
			curr.remove(curr.size()-1);
		}
	}
	
	// 5
	protected static List<List<Integer>> permuteUltimate(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		bktUlt(nums, 0, res);
		return res;
	}
	private static void bktUlt(int[] nums, int start, List<List<Integer>> res) {
		if(start == nums.length) {
			List<Integer> per = new ArrayList<>(nums.length);
			for(int n:nums) {
				per.add(n);
			}
			res.add(per);
			return;
		}
		for(int i=start; i<nums.length; i++) {
			swap(nums, start, i);
			bktUlt(nums, start+1, res);
			swap(nums, start, i);
		}
	}
	
	
}
