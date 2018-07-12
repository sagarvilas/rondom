package org.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ArrayGetNext {

	static Queue<Integer>[] x;
	static int marker = -1;
	static int size = 0;

	public static void init(Integer a[][]) {
		size = a.length;
		x = new LinkedList[size];
		for (int i = 0; i < a.length; i++) {
			x[i] = new LinkedList();
			x[i].addAll(Arrays.asList(a[i]));
		}
	}

	public static Integer getNext() {
		if (checkEmpty())
			return null;
		incrementMarker();
		if (x[marker].peek() != null)
			return x[marker].poll();
		else {
			return getNext();
		}
	}

	public static boolean checkEmpty() {
		for (int i = 0; i < size; i++) {
			if (x[i].peek() != null) {
				return false;
			}
		}
		return true;
	}

	public static void incrementMarker() {
		if (marker == size - 1)
			marker = 0;
		else
			marker++;
	}

	public static void main(String a[]) {
		Integer i[][] = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8, 9 }, { 10, 11 } };
		init(i);
		System.out.println(getNext());
		System.out.println(getNext());
		System.out.println(getNext());
		System.out.println(getNext());
		System.out.println(getNext());
		System.out.println(getNext());
		System.out.println(getNext());
		System.out.println(getNext());
		System.out.println(getNext());
		System.out.println(getNext());
		System.out.println(getNext());
		System.out.println(getNext());
	}

}
