package final_project;

public class Delhi extends Thread {
	
	TreadLock lock;
	private int delhi = 0;
	 
	Delhi(TreadLock lock, int delhi){
        this.lock = lock;
        this.delhi = delhi;
    }
	
	@Override
	public void run() {
		try{
			
		synchronized(lock)
		{
			int i = 1;
			while(i <= delhi) 
	          {
				 while(lock.flag==0)
				 {
					lock.wait();
				 }
	              System.out.println("Delhi to Gurgaon");
	              Thread.sleep(1000);
	              i++;
	              if(!lock.available) {
	            	  lock.flag = 1;
	              }else {
	            	  lock.flag = 0; 
	              }
	              if(i > delhi) {
	            	  lock.available = false;
	              }
	              lock.notifyAll();
	          }
			//lock.flag = 1;
			
		}
		}catch(Exception e){
			
		}
	}
		
		
} 
