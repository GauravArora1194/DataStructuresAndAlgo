package com.interview.arrays.advanced;

import java.util.Stack;

public class LargestRectangularAreaInHistogram {

	
	public static int getMaxArea(int[] arr) {
		
		Stack<Integer> stack = new Stack<>();
		
		int maxArea = 0; // Initialize max area.
		int tp; // To store top of stack
		int areaWithTop; // To store area with top bar as the smallest bar
		
		 // Run through all bars of given histogram
        int i = 0;
        while (i < arr.length)
        {
            // If this bar is higher than the bar on top stack, push it to stack
            if (stack.empty() || arr[stack.peek()] <= arr[i])
                stack.push(i++);
      
            // If this bar is lower than top of stack, then calculate area of rectangle 
            // with stack top as the smallest (or minimum height) bar. 'i' is 
            // 'right index' for the top and element before top in stack is 'left index'
            else
            {
                tp = stack.pop();  // store the top index
                //stack.pop();  // pop the top
      
                // Calculate the area with arr[tp] stack as smallest bar
                areaWithTop = arr[tp] * (stack.empty() ? i : i - stack.peek() - 1);
      
                // update max area, if needed
                if (maxArea < areaWithTop)
                	maxArea = areaWithTop;
            }
        }
      
        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (stack.empty() == false)
        {
            tp = stack.pop();
            //stack.pop();
            areaWithTop = arr[tp] * (stack.empty() ? i : i - stack.peek() - 1);
      
            if (maxArea < areaWithTop)
            	maxArea = areaWithTop;
        }
      
        return maxArea;
 
		
	}
	
	
	public static void main(String[] args) {
		
		
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println("Maximum area is " + getMaxArea(hist));
	}
}
