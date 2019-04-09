package org.test;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

	PriorityQueue<Double> maxHeap, minHeap;

	/** initialize your data structure here. */
	public MedianFinder() {
		Comparator<Double> c = Comparator.reverseOrder();
		maxHeap = new PriorityQueue<>(c);
		minHeap = new PriorityQueue<>();
	}

	public void addNum(int num) {
		if (maxHeap.peek() != null && num > maxHeap.peek()) {
			maxHeap.add((double) num);
		} else {
			minHeap.add((double) num);
		}
	}

	public double findMedian() {
		if (maxHeap.size() == minHeap.size()) {
			return (maxHeap.poll() + minHeap.poll()) / 2.0;
		} else if (maxHeap.size() > minHeap.size()) {
			return maxHeap.poll();
		}
		return minHeap.poll();
	}
}
