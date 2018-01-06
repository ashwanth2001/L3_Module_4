package threads;

public class Test {

	public static void main(String[] args) {
		Thread[] thread = new Thread[10];
		thread[0] = new Thread(new Runnable() {
			int check = 0;
			@Override
			public void run() {
				while(!checkCode(check++));
				}
			
		});
		thread[0].start();
	}
	public static boolean checkCode(int p){
		if(p == 10){
			return true;
		}else{
			System.out.println(p);
			return false;
		}
	}
}
