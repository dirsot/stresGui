package process;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.data.time.Millisecond;

public class ReadThread extends Thread {

    Stale stale = new Stale();
    /**
     * 
     * @param str 
     */
    public ReadThread(String str) {
        super(str);
    }
    /**
     * 
     */
    @Override
    public void run() {
        String strLine;
        double current = 0;
        int count = 0;
        double sum = 0;

        MyEventClass event = new MyEventClass(this);
        Stale.updatePlotEvent(event);
        Stale.min = 1000;
        try {
            while ((strLine = Stale.br.readLine()) != null) {
                current = Double.parseDouble(strLine);
                Stale.series.addOrUpdate(new Millisecond(), current);
                System.out.println(strLine);

                sum += current;
                count++;
                Stale.current = current;
                Stale.max = dwaMiejscaPoPrzecinku((Stale.max < current) ? current : Stale.max);
                Stale.min = dwaMiejscaPoPrzecinku((Stale.min > current) ? current : Stale.min);
                Stale.mean = dwaMiejscaPoPrzecinku(sum / count);


                //if(current > Stale.max || current < Stale.min)
                {
                    Stale.updatePlotEvent(event);
                }


                try {
                    sleep((int) (Math.random() * 1000 / Stale.drawingSpeed));
                } catch (InterruptedException e) {
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ReadThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * 
     * @param d
     * @return 
     */
    public double dwaMiejscaPoPrzecinku(double d) {
        DecimalFormat format = new DecimalFormat("#.##");
        return Double.valueOf(format.format(d));
    }
}
