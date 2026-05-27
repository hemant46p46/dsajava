package dsajava.hp.arrays.subarrays;

import java.util.*;

public class SubArrays {
	public static void main(String[] args) {
		int[] a1 = {4, 6, 1};
		int[] a2 = {2, 3, 5};
		System.out.println("For array: " + Arrays.toString(a1));
		generateAllSubArrays(a1);
		System.out.println("For array: " + Arrays.toString(a2));
		generateRecursive(a2, 0, 0);
		
		int[] a3 = {7,8,9};
		System.out.println("For array: " + Arrays.toString(a3));
		System.out.println(getAllSubArrays(a3));
	}
	protected static void generateAllSubArrays(int[] arr) {// basic-way
		int n = arr.length;
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				for(int k=i;k<=j;k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println();
			}
		}
	}
	protected static List<int[]> getAllSubArrays(int[] arr){
		List<int[]> res = new ArrayList<>();
		int n = arr.length;
		
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				int[] sa = Arrays.copyOfRange(arr, i, j+1);
				res.add(sa);
			}
		}
		return res;
	}
	protected static void generateRecursive(int[] arr, int start, int end) {
		if(end == arr.length) {
			return;
		}
		else if (start > end) {
			generateRecursive(arr, 0, end+1);
		}else {
			for(int i=start;i<=end;i++) {
				System.out.print(arr[i] + (i==end ? "" : ","));
			}
			System.out.println();
			generateRecursive(arr, start+1, end);
		}
	}
}
