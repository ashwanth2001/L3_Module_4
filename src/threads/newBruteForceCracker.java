package threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class newBruteForceCracker {
	static long code = (long)(new Random().nextDouble() * 1_000_000_000);
	
	static long startTime;
	static long endTime;
	static float elapsedTime;
	
	public static void main(String[] args) {
		System.out.println("Starting Brute Force Checker");
		ArrayList<Integer> fin = new ArrayList<Integer>(9);
		startTime = System.currentTimeMillis();
		ArrayList<Integer> store = SplitStore(code);
		int check = 0;
		for(int i = 0; i<9; i++) {
			int c1 = store.get(i);
			if(check!=c1) {
				check++;
				i--;
			}
			else {
				fin.add(check);
				check = 0;
			}
		}
		endTime = System.currentTimeMillis();
		elapsedTime = (float)(endTime - startTime);
		elapsedTime /= 1000.f;
		System.out.println("Total time taken: " + elapsedTime + " seconds");
		System.out.print(store);
		System.out.print(fin);
	}
	
	public static ArrayList<Integer> SplitStore(long b) {
		ArrayList<Integer> a = new ArrayList<Integer>(9);
		for(int i = 8; i>-1; i--) {
			int c = (int)(b%10);
			System.out.println(1);
			b/=10;
			a.add(c);
		}
		Collections.reverse(a);
		return a;
	}
}
