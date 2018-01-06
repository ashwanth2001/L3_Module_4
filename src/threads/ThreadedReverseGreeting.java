package threads;
public class ThreadedReverseGreeting {
  //Write a program that creates a thread (Thread 1) that creates another thread (Thread 2); 
  //Thread 2 creates Thread 3; and so on, up to Thread 50. 
  //Each thread should print "Hello from Thread <num>!", 
  //but you should structure your program such that the threads print their greetings in reverse order.
	public static void main(String[] args) {
		Thread[] threads = new Thread[51];
		threads[0] = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 50; i>0; i--) {
					int j = i;
					threads[i] = new Thread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							System.out.println("Hello from Thread" + j);
						}
						
					});
					threads[i].start();
				}
			}
		});
		threads[0].start();
	}
}
