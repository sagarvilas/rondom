package org.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KmostFrequent {
	public static class Frequency {
		int num;
		int frequency;

		public Frequency(int a, int b) {
			num = a;
			frequency = b;
		}
	}

	public static List<Integer> topKFrequent(int[] nums, int k) {
		Arrays.sort(nums);

		PriorityQueue<Frequency> heap = new PriorityQueue<>((o1, o2) -> o2.frequency - o1.frequency);
		for (int i = 0; i < nums.length;) {
			int temp = nums[i];
			int freq = 0;
			while (i < nums.length && temp == nums[i]) {
				i++;
				freq++;
			}
			heap.offer(new Frequency(temp, freq));
		}
		List<Integer> res = new ArrayList();
		int i=0;
		while (!heap.isEmpty() && i<k) {
			res.add(heap.poll().num);
			i++;
		}
		return res;
	}

	public static void main(String[] args) {
		int n[] ={1,1,1,2,2,3};
		topKFrequent(n,2).forEach(System.out::print);
	}

}
