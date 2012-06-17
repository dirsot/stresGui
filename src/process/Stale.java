package process;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jfree.data.time.TimeSeries;

public class Stale {

    public static double lastValue = 100.0;
    public static TimeSeries series;
    public static int drawingSpeed = 1;
    public static String fileName = "___";
    public static double min = 0;
    public static double max = 0;
    public static double mean = 0;
    public static double current = 0;
    public static String login;
    public static boolean isLogin = false;
    public static int type = 0;
    public static int question1 = 0;
    public static int question2 = 0;
    public static int question3 = 0;
    public static int question4 = 0;
    public static int question5 = 0;
    public static int question6 = 0;
    public static int question7 = 0;
    public static BufferedReader br;
    public static javax.swing.JTextArea jTextArea1;
    public static List _listeners = new ArrayList();

    public static synchronized void addEventListener(MyEventClassListener listener) {
        _listeners.add(listener);
    }

    public static synchronized void removeEventListener(MyEventClassListener listener) {
        _listeners.remove(listener);
    }

    public static void fireLoginEvent(MyEventClass event) {

        Iterator i = Stale._listeners.iterator();
        while (i.hasNext()) {
            ((MyEventClassListener) i.next()).loginSucces(event);
        }
    }

    public static void fireSurveyEvent(MyEventClass event) {
        Iterator i = Stale._listeners.iterator();
        while (i.hasNext()) {
            ((MyEventClassListener) i.next()).surveySucces(event);
        }
    }

    public static void updatePlotEvent(MyEventClass event) {
        Iterator i = Stale._listeners.iterator();
        while (i.hasNext()) {
            ((MyEventClassListener) i.next()).plotUpdate(event);
        }
    }
    public static String[][] answers = {
        {
            "Twoja praca zdecyowanie ma na Ciebie negatywny wpływ. Wiemy, że jesteś o niej do niej przywiązany, ale moze już pora rozejrzeć się za mniej absorbującym zajęciem.\n",
            "Nawet więźniowie mają więcej wolności niż Ty. Twój kierownik sprawdza nawet ile ołówków łamiesz w ciągu miesiąca? Może czas na zmianę kierownika? Bo któż nadawałby się na to stanowisko lepiej niż Ty?\n",
            "Czy drżysz w obawie o swój stołek na hasło restrukturyzacja? Pomyśl o zaletach tego nagłego przypływu wolnego czasu. Wreszcie wypoczniesz, wyjedziesz na zasłużony urlop. Jedynym minusem jest to, ze szybko pojawi się kolejne źródło stresu, gdy zaczniesz uciekać przed swoimi wierzycielami.\n",
            "Jeżeli uważasz, że spełnione godziny są zmarnowane poszukaj innej pracy. W końcu śmieciarz Eugeniusz z bloku obok wykonuje swoją pracę z pasją, moze to droga dla Ciebie?\n",
            "Nikt Cię w pracy nie zauważa, a Kasia z księgowości, na pytanie o Ciebie odpowiada \"nie kojarzę\", mimo, ze codziennie przynosisz jej stertę papierów? Może wdaj się w romans z koleżanką z pracy, może nie wyjdzie Ci to na dobre, ale jedno jest pewne, na pewno nie pozostaniesz niezauważaly.\n",
            "Znasz już imiona wszystkich dzieci portiera z nocnej zmiany, a masz problem z zapaiętaniem własnych? Twoje dzieci, jak widzą Cię w domu, uciekają z krzykiem i pytają mamy \" Kim jest ten Pan?\". To wiedz, ze coś się dzieje.\n",
            "Jeżeli po jednym wypadzie do Biedronki nie masz już połowy swojej pensji, to może najwyższy czas by się odważyć i pójść do szefa z prośbą o podwyzkę. Nawet jak to będzie 10 zł to przecież zawsze 4 piwa więcej.\n"
        },
        {
            "Codziennie dopada Cię horda głodnych potomków? A może masz jednego małego diabła, który starcza za całą piętnastkę? Niektórzy polecają radykalne rozwiązania (Możesz zaczerpnąć inspirację z filmów, jak \"Teksańska masakra piłą mechaniczną\"), dla mniej zdesperowanych polecamy wywiezienie problemów, wróć kochanych aniołków do dziadków.\n",
            "Jeżeli żona kolejny raz każe Ci wynieść śmieci, odkurzyć podłogę, podlać kwiatki... a dzieci narzekają, że nigdy nie chodzisz z nimi na boisko, mamy dla Ciebie propozycję. Zgłoś się do programu prototypowych badań na AGH, niech stworzą Twojego klona, który będzie wykonywał za Ciebie wszystkie te zadania, a Ty w końcu będziesz mógł popracować w spokoju.\n",
            "",
            "",
            "",
            "",
            ""
        },
        {
            "",
            "",
            "",
            "",
            ""
        }
    };
}