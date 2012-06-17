package process;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.data.time.Millisecond;

public class ReadThread extends Thread {
    
    Stale stale = new Stale();
    public ReadThread(String str) {
	super(str);
    }
    public void run() {
        String strLine;
        int current=0;
        MyEventClass event = new MyEventClass(this);
        Stale.updatePlotEvent(event);
        try {
            while((strLine = Stale.br.readLine())!=null){
                current = Integer.parseInt(strLine);
                   stale.series.addOrUpdate(new Millisecond(), current);
                   System.out.println(strLine);
                   
                   Stale.current = current;
                   Stale.max = (Stale.max<current)?current:Stale.max;
                   Stale.min = (Stale.min>current)?current:Stale.min;
                   
                   
                   //if(current > Stale.max || current < Stale.min)
                   {
                       Stale.updatePlotEvent(event);
                   }
                   
                   
                   try {
		sleep((int)(Math.random() * 1000/stale.drawingSpeed));
	    } catch (InterruptedException e) {}
                }
        } catch (IOException ex) {
            Logger.getLogger(ReadThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}  