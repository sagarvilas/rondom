package org.test;

import java.util.HashMap;
import java.util.Map;

public class FreqStack {


	Map<Integer, Integer> frequencies;
	Map<Integer, Stack<Integer>> stack;
	int maxFreq;

	public FreqStack() {
		frequencies = new HashMap<>();
		stack = new HashMap<>();
		maxFreq = 0;
	}

	public void push(int x) {
		int f = frequencies.getOrDefault(x, 0) + 1;
		frequencies.put(x, f);
		if (f > maxFreq)
			maxFreq = f;
		stack.computeIfAbsent(f, z -> new Stack<Integer>()).push(x);
	}

	public int pop() {
		int res = stack.get(maxFreq).pop();
		frequencies.put(res, frequencies.get(res)-1);
		if(stack.get(maxFreq).size() ==0)
			maxFreq--;
		return res;
	}

}
