package process;

import org.jfree.data.time.Millisecond;

public class ReadThread extends Thread {
    
    Stale stale = new Stale();
    public ReadThread(String str) {
	super(str);
    }
    public void run() {
	for (int i = 0; i < 10; i++) {
	    System.out.println(i + " " + stale.lastValue);
            
            
            final double factor = 0.90 + 0.2 * Math.random();
            stale.lastValue = stale.lastValue * factor;
            final Millisecond now = new Millisecond();
            System.out.println("Now = " + now.toString());
            stale.series.add(new Millisecond(), stale.lastValue);
            
            
            try {
		sleep((int)(Math.random() * 1000));
	    } catch (InterruptedException e) {}
	}
	System.out.println("DONE! " + getName());
    }
}