package final_project;
import java.util.*;

public class Main {
	
	

	public static synchronized void  main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter Total Person at Gurgaon : ");
    	int gurgaon = sc.nextInt();
    	
    	System.out.println("Enter Total Person at Delhi : ");
    	int delhi = sc.nextInt();  
    	sc.close();
    	
    	TreadLock tl = new TreadLock();
    	
    	if(delhi == 0 && gurgaon == 0) {
    		System.out.println("There is no Persion in either side");
    	}
    	else if(delhi <= 0 && gurgaon > 0) {
    		tl.available = false;
    		tl.flag = 0;
    		Gurgaon gur = new Gurgaon(tl, gurgaon);
    		gur.start();
    	}
    	else if(delhi > 0 && gurgaon <= 0) {
    		tl.available = false;
    		tl.flag = 1;
    		Delhi del = new Delhi(tl, delhi);
    		del.start();
    	}
    	else {
        	Delhi del = new Delhi(tl, delhi);
        	Gurgaon gur = new Gurgaon(tl, gurgaon);
        	del.start();
        	gur.start();
    		
    	}
    	
    	
    	
	}

}
