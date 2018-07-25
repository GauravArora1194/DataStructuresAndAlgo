package com.interview.arrays;

public class RearrangePositiveAndNegativeNumbers {
	
	
	
	public static int[] rearrange(int[] arr) {
		
		int[] temp1 =new int[arr.length];
		int[] temp2 =new int[arr.length];
		int i=0,j=0;
		
		for(int k=0;k<arr.length;k++) {
			
			if(arr[k]<0) {
				temp1[i] = arr[k];
				i++;
			}
			else {
				temp2[j] =arr[k];
				j++;
			}
			
		}
		i=0;
		j=0;
		for(int k=0;k<arr.length;k++) {
			
			if(k%2==0 && j<temp2.length) {
				arr[k]=temp2[j];
				j++;
			}
			else {
				arr[k] = temp1[i];
				i++;
			}
			
		}
		
		return arr;
	}
	
	
	
public static String checkForTraceable(String[] magzine, String[] note, int m, int n){
        
        int i, j;
        for( i = 0; i < n ; i++) {
            
            for(j = 0; j < m ; j++) {
                
                if(note[i].equals(magzine[j])){
                     magzine[j] = " ";
                     break;
                }
                
            }
            if(j == m)
                return "No";
        }
        
            return "Yes";
        
    }

   public static void main(String[] args) {
 	
	   String[] magazine = {"give", "me", "one", "grand", "today", "night"};
	   String[] note = {"give", "one", "grand", "today","one"};
	   int m = 6, n=5;
	   System.out.println(checkForTraceable(magazine, note, m, n));
   }

}
