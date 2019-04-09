package org.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RainWater {
	
    public static int trap(int[] height) {
    	if(height.length<3)
    		return 0;
    	List<Integer> heights = Arrays.stream(height).boxed().collect(Collectors.toList());
    	int maxHeight = Collections.max(heights);
    	int maxHeightIndex = heights.indexOf(maxHeight);
    	int totalWater = 0;
    	int left = 0;
    	int right = height.length-1;
    	int water = 0;
    	int localHeight = 0;
    	while(left<maxHeightIndex) {
    		localHeight = height[left];
    		if(localHeight>0) {
    			while(height[++left]<localHeight) {
    				water = water+localHeight-height[left];
    			}
    			totalWater += water;
    			water = 0;
    		}else {
    			++left;
    		}
    	}
    	while(right>maxHeightIndex) {
    		localHeight = height[right];
    		if(localHeight>0) {
    			while(height[--right]<localHeight) {
    				water = water+localHeight-height[right];
    			}
    			totalWater += water;
    			water=0;
    		}else {
    			--right;
    		}
    	}
    	
		return totalWater;
        
    }
    
    public static void main(String[] args) {
		int[] h = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(h));
	}

}
