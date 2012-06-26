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
        Millisecond lastMili = new Millisecond();
        int i = 10;
        double sumOf10Last = 0D;
        try {
            while ((strLine = Stale.br.readLine()) != null) {
                current = Double.parseDouble(strLine);
                

                Stale.series.getSeries(0).addOrUpdate(new Millisecond(), current);
                
                //System.out.println(strLine);

                sum += current;
                count++;
                Stale.current = current;
                Stale.max = dwaMiejscaPoPrzecinku((Stale.max < current) ? current : Stale.max);
                Stale.min = dwaMiejscaPoPrzecinku((Stale.min > current) ? current : Stale.min);
               Stale.mean = dwaMiejscaPoPrzecinku(sum / count);

                
                if((i%10) != 0){
                    sumOf10Last += current;
                    i++;
                }else{
                    i=1;
                    sumOf10Last += current;
                    Stale.series.getSeries(1).addOrUpdate(lastMili, sumOf10Last/10);
                    lastMili = new Millisecond();
                    Stale.series.getSeries(1).addOrUpdate(lastMili, sumOf10Last/10);
                    
                
                
                Stale.ourScaleStress = (int)((sumOf10Last/10 - Stale.min)/(Stale.max - Stale.min)*100);
                
                System.out.println(Stale.ourScaleStress);
                if(Stale.ourScaleStress<20){
                    Stale.ourScaleStress = 0;
                }else if(Stale.ourScaleStress<40){
                    Stale.ourScaleStress = 2;
                }else if(Stale.ourScaleStress<60){
                    Stale.ourScaleStress = 3;
                }else if(Stale.ourScaleStress<80){
                    Stale.ourScaleStress = 4;
                }else{
                    Stale.ourScaleStress = 5;
                }
                
                sumOf10Last = 0;
                }
                
                System.out.println(Stale.ourScaleStress);
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
     * @param 
     * @return 
     */
    public double dwaMiejscaPoPrzecinku(double d) {
        DecimalFormat format = new DecimalFormat("#.##");
        try{
        return Double.valueOf(format.format(d));
        }catch(Exception e){
        System.out.println("error " + e);
        }
        return 10;
    }
}
