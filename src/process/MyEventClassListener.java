package process;

import java.util.EventObject;

public interface MyEventClassListener {

    public void loginSucces(EventObject e);

    public void surveySucces(EventObject e);

    public void plotUpdate(EventObject e);
}
