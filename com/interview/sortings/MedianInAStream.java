package com.interview.sortings;

import java.util.Scanner;

public class MedianInAStream {
	

	// This gives time limit exceeded exception
public static void heapSort(int[] arr, int count){
        
        int size = count;
        
        for(int i = size/2 - 1; i>=0 ;i--){
            heapify(arr,i,size);
        }
        
        for(int i = size-1; i > 0; i--){
            
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr,0,i);
                
        }
        
    }
    
    
    public static void heapify(int[] arr, int i, int size){
        
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if(left < size && arr[left] > arr[largest])
            largest = left;
        
        if(right < size && arr[right] > arr[largest])
            largest = right;
        
        if(largest != i){
            
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            
            heapify(arr,largest,size);
            
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];
        float median = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            a[i] = aItem;
            count++;
            heapSort(a, count);
            
            if(count%2 == 0){
                int mid = count/2;
                median = (float)(a[mid] + a[mid-1])/2;
            }else{
                median = (float)(a[count/2]);
            }
            
            System.out.println(median);
        }

        scanner.close();
    }

}
