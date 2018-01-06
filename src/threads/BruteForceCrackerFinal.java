
package threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BruteForceCrackerFinal {
	static long code = (long)(new Random().nextDouble() * 1_000_000_000);
	
	static long startTime;
	static long endTime;
	static float elapsedTime;
	ArrayList<Integer> fin = new ArrayList<Integer>(9);
	
	public static void main(String[] args) {
		System.out.println("Starting Brute Force Checker");
		System.out.print("Cracked code: ");
		
		startTime = System.currentTimeMillis();
		
		ArrayList<Integer> store = SplitStore(code);
		Thread[] thread = new Thread[9];
		
		for(int i = 0; i<9; i++) {
			int k = i;
			thread[i] = new Thread(new Runnable() {
				int j = k;
				int check = 0;
				int c1 = store.get(j);
				
				@Override
				public void run() {
					 //TODO Auto-generated method stub
					while(!checkCode(check++, c1));
					endTime = System.currentTimeMillis();
					elapsedTime = (float)(endTime - startTime);
					elapsedTime /= 1000.f;
				}
			
			});
		}
		//startTime = System.currentTimeMillis();
		for(int i= 0; i<9; i++) {
			thread[i].start();
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\nActual code: " + code);
		System.out.println("Total time taken: " + elapsedTime + " seconds");
		
	}
	
	public static ArrayList<Integer> SplitStore(long b) {
		ArrayList<Integer> a = new ArrayList<Integer>(9);
		for(int i = 8; i>-1; i--) {
			int c = (int)(b%10);
			b/=10;
			a.add(c);
		}
		Collections.reverse(a);
		return a;
	}
	
	public static boolean checkCode(int p, int c){
		if(p == c){
			System.out.print(p);
			return true;
		}else{
			return false;
		}
	}
}

