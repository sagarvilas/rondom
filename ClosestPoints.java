package org.test;

import java.util.PriorityQueue;

public class ClosestPoints {
	public int[][] kClosest(int[][] points, int K) {

		PriorityQueue<int[]> heap = new PriorityQueue<>(
				(o1, o2) -> o1[0] * o1[0] + o1[1] * o1[1] - o1[0] * o2[0] - o2[1] * o2[1]);
		for(int[] i:points) {
			heap.offer(i);
		}
		
		int res[][]= new int[K][2];
		int i=0;
		while(!heap.isEmpty() && i<=K) {
			res[i] = heap.poll();
			i++;
		}
		return res;

	}
}
