package com.interview.multithreadingAndconcurrency;


public class VisibilityWithVolatileKeyword {
	
	
	private static boolean flag = true;
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		new Task1().start();
		new Task2().start();
	}
	
	
	static class Task1 extends Thread {

		@Override
		public void run() {
			
			boolean localFlag = flag;
			System.out.println(Thread.currentThread().getName() + " flag value : " + localFlag);
			while(localFlag) {
				
				//System.out.println(Thread.currentThread().getName() + " flag value in loop: " + flag);
				
				System.out.println(Thread.currentThread().getName() + " is running.");
				
					
				localFlag = flag;
				
			}
			
		}
		
	}
	
	
	static class Task2 extends Thread {

		
		@Override
		public void run() {
			
			boolean localFlag = flag;
			System.out.println(Thread.currentThread().getName() + " flag value : " + localFlag);
		
			localFlag = false;
			flag = localFlag;
			
			//System.out.println(Thread.currentThread().getName() + " flag value after changing : " + flag);
			
			System.out.println("Flag set to false by " + Thread.currentThread().getName());
			
		}
		
		
	}


	
}

/*class VolatileThread implements Runnable {
	
	private static boolean flag = true;
	int number;
	
	public VolatileThread(int number) {
		this.number = number;
	}
	
	
	@Override
	public void run() {
		
		
		if(number%2 == 1) {
			
			while(flag) {
				
				System.out.println(Thread.currentThread().getName() + " is running");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}else {
			
			flag = false;
			System.out.println("flag set to false by thread " + Thread.currentThread().getName());
		}
		
	}
}*/
