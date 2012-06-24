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
            "Jeżeli dzieci zaczynają Cię uczyć skąd się biorą dzieci, i już szósty raz w tym tygodniu, do Twojej żony wpada stary kumpel z podstawówki, to znak, że musisz znaleźć sobie dobrą korepetytorkę, żeby się szybko podciągnąć z tego tematu.",
            "Twoja żna narzeka, ze znowu nie ma pieniędzy na nową sukienkę. Przejdź się do parku i kup od przydrożnego \"Kierowniku dorzucisz się złotóweczkę\" jego płaszcz za 20zł, przynieś do domu i powiedz ,że to najnowsza kolekcja Versace. Na pewno uwierzy.",
            "Twoja córka ma wytatuowane imię już 15 miłości życia na ramieniu, a syn mówi, że chyba jest uwięziony w obcym ciele? Zamuruj się w piwnicy z dużym zapasem jedzenia i wyjdź za 2 lata, wszystko wróci do normy.",
            "Nie ruszasz się z domu bez kasku, kompletu ochraniaczy i paralizatora? Wszędzie widzisz czychające na Ciebie niebezpieczeństwo? Pamiętaj, że 90% wypadków zdarza się w domu, wystarczy, że tylko tego miejsca będziesz unikał.",
            "Jeżeli masz już dość narzekania cteściowej Gieni, że za mało zarabiasz, jej córka zmarnowała z Tobą życie, a dzieci odziedziczyły brak iteligencji po tatusiu. Stań się dilerem, zmień żonę i adoptuj nowe dzieci, albo po prostu przestań odwiedzać \"ukochaną\" mamusię."
            
        },
        {
            "Twoi znajomi z trudem rozpoznają Cię na zdjęciach na Facebooku, po na ogół widują Cię zza chmury dymu? Na pewno są pozytywy tego rozwiązania - jak już będziesz sławny, paparazzi na pewno Cię nie dopadną (chyba, ze zaopatrzeni w maski gazowe), my jednak polecamy nieco ograniczyć zasłonę dymną.",
            "Postać Jacka Sparowa została stworzona na podstawie historii Twojego życia? Gdybyś miał spędzić życie na bezludnej wyspie i miałbyś zabrać trzy rzeczy byłaby to beczka rumu, beczka rumu i beczka rumu? Pamietaj o tym, ze tam akcja toczyła się na Karaibach, w naszym mroźnym klimacie polecamy raczej spirytus, szczególnie takim koneserom jak Ty. Stąd już prosta droga do degustacji innych orientalnych trunków na czele z denaturatem.",
            "No proszę, gratulujemy, cieszymy się, że są osoby, które dbają o swoje zdrowie, bo jak wiadomo \"w zdrowym ciele, zdrowy duch\", chyba, że miałeś na myśli, ze z niezrównaną prędkością i szybkością zmieniasz kanały w telewizorze ćwicząc zręczność palców. Dla takich osób zalecamy wyrzucenie pilota przez okno, 2 kroki do telewizory by zmienić kanał - 2 kalorie mniej.",
            "Tutaj ostrzegamy, częte wyjazdy na wakacje znacząco wpływają na podwyższenie poziomu stresu - zazdrosnych sąsiadów. My również zazdrościmy .",
            "Świeżym jak świeżym, badałeś skażenie środowiska na swoim terenie? Nie? To skąd ta pewność? Ale dobrze, nawet jak nie zwież to można złapać trochę witaminy D ze słońca albo mikroelementów powszechnie unoszących się w naszej atmosferze, samo zdrowie!",
            "Oj, oj łakomczuszek? Nieładnie. Uwielbiasz hamburgery z Mc'Donalds i Burger Kinga? Pamiętaj, że symbolizują one kształt, w który niebawem się zamienisz. Im więcej tłuszczyku, tym więcej stresu w nim pływa. Pamiętaj, że jesteś tym co jesz. Na pewno chcesz być okrągłą, ociekającą tłuszczem bułą? A może wolisz jędrną marcheweczkę? Dla ekstremalnych wielbicieli fastfodów polecamy hot dogi, zawsze trochę bardziej pociągłe.",
            "Wszystko zaznaczasz w kalendarzu? Wrzesień - rutynowy przegląd samochodu, Październik - dentysta, a w listopadzie kontrola u kardiologa? Super, gratulujemy, masz duży wpływ na rozwój polskiej gospodarki, a szczególnie branży medycznej, tak trzymać!"
        }
    };
}