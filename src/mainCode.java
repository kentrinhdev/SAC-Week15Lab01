import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class mainCode 
{
	public static void main (String[] args) throws InterruptedException
	{
		List<RunnableInterface> workers = new ArrayList<RunnableInterface>();
    
		System.out.println("This is currently running on the main thread, " +
							"the id is: " + Thread.currentThread().getId());
		Date start = new Date();

		// start 5 workers
		for (int i=0; i<5; i++)
		{
			// Call from RunnableInterface
			workers.add(new RunnableInterface()); 
		}
    
		// Force the main thread to wait for all the threads
		//  to finish running before checking how long it
		//  took to complete
		for (RunnableInterface worker : workers)
		{
			while (worker.running)
				{
					Thread.sleep(100);
				}
		}
    
		Date end = new Date();
		long difference = end.getTime() - start.getTime();
		System.out.println ("This whole process took: " + difference/1000 + " seconds.");
	} // end void main
	
			private boolean running;
			@Override
			public void run() 
			{
				this.running = true;
				System.out.println("This is currently running on a separate thread, " +
									"the id is: " + Thread.currentThread().getId());
					try 
					{
						// Pause thread for 5 seconds
						// Note: 5000 is the number of milliseconds to pause
						// Thread.sleep() method throws an InterruptedException
						// try/catch will catch exceptions
						Thread.sleep(5000);
					} 
						catch (InterruptedException e) 
						{
							Thread.currentThread().interrupt();
						}
				
				// Set running value back to false
				this.running = false;
			} // end run method

	
} // class mainCode	