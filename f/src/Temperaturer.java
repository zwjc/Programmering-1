public class Temperaturer
{
    public static void main (String[] args){System.out.println ("TEMPERATURER\n");// inmatningsverktygScanner    in = new Scanner (System.in);in.useLocale (Locale.US);// mata in uppgifter om antalet veckor och antaletmätningarSystem.out.print ("antalet veckor: ");int    antalVeckor = in.nextInt ();System.out.print ("antalet mätningar per vecka: ");int    antalMatningarPerVecka = in.nextInt ();// plats att lagra temperaturerdouble[][]    t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];// mata in temperaturernafor (int vecka = 1; vecka <= antalVeckor; vecka++){System.out.println ("temperaturer -vecka " + vecka+ ":");for (int matning = 1;matning <= antalMatningarPerVecka; matning++)t[vecka][matning] = in.nextDouble ();}System.out.println ();// visa temperaturernaSystem.out.println ("temperaturerna:");for (int vecka = 1; vecka <= antalVeckor; vecka++){for (int matning = 1;matning <= antalMatningarPerVecka; matning++)System.out.print (t[vecka][matning] + " ");System.out.println ();}System.out.println ();// den minsta,den största och medeltemperaturen–veckovisdouble[]    minT = new double[antalVeckor + 1];double[]    maxT = new double[antalVeckor + 1];




}
