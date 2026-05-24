package dsajava.hp.arrays.easy;

import java.util.Arrays;

public class HelloArray {
	protected void printArray(int[] arr) {
		Arrays.stream(arr).forEach(System.out::println);
	}
}
