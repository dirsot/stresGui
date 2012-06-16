package process;

import org.jfree.data.time.Millisecond;

public class ReadThread extends Thread {
    
    Stale stale = new Stale();
    public ReadThread(String str) {
	super(str);
    }
    public void run() {
        int i = 0;
        Millisecond start = new Millisecond();
	while(true) {
            i++;
	    //System.out.println(i + " " + stale.lastValue);
            
            
            final double factor = 0.90 + 0.2 * Math.random();
            stale.lastValue = stale.lastValue * factor;
            final Millisecond now = new Millisecond();
            //System.out.println("Now = " + now.toString());
            if(stale.lastValue<3)
                stale.lastValue = 100;
            stale.series.addOrUpdate(new Millisecond(), stale.lastValue);
            
            
            try {
		sleep((int)(Math.random() * 1000/stale.drawingSpeed));
	    } catch (InterruptedException e) {}
	}
    }
}