package final_project;

public class Gurgaon extends Thread {

	TreadLock lock;
	private int gurgaon = 0;

	Gurgaon(TreadLock lock, int gurgaon) {
		this.lock = lock;
		this.gurgaon = gurgaon;
	}

	@Override
	public void run() {
		try {

			synchronized (lock) {
				int i = 1;
				while (i <= gurgaon) {
					
					while (lock.flag == 1) {
						lock.wait();
					}
					System.out.println("Gurgaon to delhi");
					Thread.sleep(1000);
					i++;
					if (!lock.available) {
						lock.flag = 0;
					} else {
						lock.flag = 1;
					}
					if (i > gurgaon) {
						lock.available = false;
					}
					lock.notifyAll();
				}
				// lock.flag = 0;
			}
		} catch (Exception e) {

		}
	}

}
