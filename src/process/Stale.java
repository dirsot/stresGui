package process;

import org.jfree.data.time.TimeSeries;

public class Stale{
    public static double lastValue = 100.0;
    public static TimeSeries series;
    public static int drawingSpeed = 10;
    public static String fileName;
    public static int type=0;
    public static int question1=0;
    public static int question2=0;
    public static int question3=0;
    public static int question4=0;
    public static int question5=0;
          
    public static javax.swing.JTextArea jTextArea1;
    
    public static String[][] answers={
        {"Twoja praca zdecyowanie ma na Ciebie negatywny wpływ. Wiemy, że jesteś o niej do niej przywiązany, ale moze już pora rozejrzeć się za mniej absorbującym zajęciem.",
            "Nawet więźniowie mają więcej wolności niż Ty. Twój kierownik sprawdza nawet ile ołówków łamiesz w ciągu miesiąca? Może czas na zmianę kierownika? Bo któż nadawałby się na to stanowisko lepiej niż Ty?",
            "Czy drżysz w obawie o swój stołek na hasło restrukturyzacja? Pomyśl o zaletach tego nagłego przypływu wolnego czasu. Wreszcie wypoczniesz, wyjedziesz na zasłużony urlop. Jedynym minusem jest to, ze szybko pojawi się kolejne źródło stresu, gdy zaczniesz uciekać przed swoimi wierzycielami.",
            "Jeżeli uważasz, że spełnione godziny są zmarnowane poszukaj innej pracy. W końcu śmieciarz Eugeniusz z bloku obok wykonuje swoją pracę z pasją, moze to droga dla Ciebie?",
            "Nikt Cię w pracy nie zauważa, a Kasia z księgowości, na pytanie o Ciebie odpowiada \"nie kojarzę\", mimo, ze codziennie przynosisz jej stertę papierów? Może wdaj się w romans z koleżanką z pracy, może nie wyjdzie Ci to na dobre, ale jedno jest pewne, na pewno nie pozostaniesz niezauważaly.",
        "Znasz już imiona wszystkich dzieci portiera z nocnej zmiany, a masz problem z zapaiętaniem własnych? Twoje dzieci, jak widzą Cię w domu, uciekają z krzykiem i pytają mamy \" Kim jest ten Pan?\". To wiedz, ze coś się dzieje.",
            "Jeżeli po jednym wypadzie do Biedronki nie masz już połowy swojej pensji, to może najwyższy czas by się odważyć i pójść do szefa z prośbą o podwyzkę. Nawet jak to będzie 10 zł to przecież zawsze 4 piwa więcej.,"}
            
            ,
        {"Codziennie dopada Cię horda głodnych potomków? A może masz jednego małego diabła, który starcza za całą piętnastkę? Niektórzy polecają radykalne rozwiązania (Możesz zaczerpnąć inspirację z filmów, jak \"Teksańska masakra piłą mechaniczną\"), dla mniej zdesperowanych polecamy wywiezienie problemów, wróć kochanych aniołków do dziadków.",
            "Jeżeli żona kolejny raz każe Ci wynieść śmieci, odkurzyć podłogę, podlać kwiatki... a dzieci narzekają, że nigdy nie chodzisz z nimi na boisko, mamy dla Ciebie propozycję. Zgłoś się do programu prototypowych badań na AGH, niech stworzą Twojego klona, który będzie wykonywał za Ciebie wszystkie te zadania, a Ty w końcu będziesz mógł popracować w spokoju.",
            "",
            
            "",
            "",
            "",
            ""},
        {"","","","",""}};
}