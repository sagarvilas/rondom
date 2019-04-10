package org.test;

public class LargestRectangle {
	public static int largestRectangleArea(int[] heights) {
		if (heights.length < 1)
			return 0;

		class Point {
			int x, y;

			public Point(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}

		Stack<Point> stack = new Stack();
		int area = 0;
		int maxArea = 0;
		for (int i = 0; i <= heights.length; i++) {
			int h = (i == heights.length ? 0 : heights[i]);
			if (stack.isEmpty() || h >= stack.peek().y) {
				stack.push(new Point(i, h));
			} else {
				area = (i - stack.peek().x) * stack.peek().y;
				stack.pop();
				if (area > maxArea) {
					maxArea = area;
				}
				i--;
			}
		}
		/*
		 * while(!stack.isEmpty()) { area = (i-stack.peek().x)*stack.peek().y;
		 * stack.pop(); if(area>maxArea) { maxArea= area; } }
		 */
		return maxArea;

	}

	public static void main(String[] args) {
		int h[] = { 2,1,2 };
		System.out.println(largestRectangleArea(h));
	}
}
