import java.util.Locale;
import java.util.Scanner;

public class Temperaturer
{
    public static void main (String[] args)
    {
        System.out.println("TEMPERATURER\n");

        // inmatningsverktyg
        Scanner in = new Scanner(System.in);
        in.useLocale (Locale.US);

        //mata in uppgifter om antalet veckor och antalet mätningar
        System.out.print ("antalet veckor: ");
        int antalVeckor = in.nextInt ();
        System.out.print ("antalet mätningar per vecka: ");
        int antalMatningarPerVecka = in.nextInt ();

        // plats att lagra temperaturer
        double [][] t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];

        // mata in temperaturerna
        for (int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            System.out.println("temperaturer - vecka " + vecka + ":");
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
                t[vecka][matning] = in.nextDouble();
        }
        System.out.println();

        // visa temperaturerna
        System.out.println("temperaturerna:");
        for (int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
                System.out.println(t[vecka][matning] + " ");
            System.out.println();
        }
        System.out.println();

        // den minsta, den största och medeltemperaturen - veckovis
        double[] minT = new double[antalVeckor + 1];
        double[] maxT = new double[antalVeckor + 1];
        double[] sumT = new double[antalVeckor + 1];
        double[] medelT = new double[antalVeckor + 1];
        // koden ska skrivas här


        // visa minsta, största och medeltemperaturen för varje vecka
        // max min mean value array
        for (int vecka = 1; vecka <= antalVeckor; vecka++)
            {
                for (int matningar = 1; matningar <= antalMatningarPerVecka; matningar++)
                {
                    if (matningar == 1 || t[vecka][matningar] > maxT[vecka])
                    {
                        maxT[vecka] = t[vecka][matningar];
                    }
                    if (matningar == 1 || t[vecka][matningar] < minT[vecka])
                    {
                        minT[vecka] = t[vecka][matningar];
                    }
                    sumT[vecka] += t[vecka][matningar];
                }
                medelT[vecka] = sumT[vecka] / antalMatningarPerVecka;

                System.out.println("Vecka " + vecka + " hade max temperaturen: " + maxT[vecka]);
                System.out.println("Vecka " + vecka + " hade min temperaturen: " + minT[vecka]);
                System.out.println("Vecka " + vecka + " hade total temperaturen: " + sumT[vecka]);
                System.out.println("Vecka " + vecka + " hade medeltemperaturen: " + medelT[vecka]);
                System.out.println();
            }

        // den minsta, den största och medeltemperaturen - hela mätperioden
        double minTemp = minT[1];
        double maxTemp = maxT [1];
        double sumTemp = sumT[1];
        double medelTemp = 0;
        //koden ska skrivas här

        for (int vecka = 2; vecka<=antalVeckor; vecka++)
        {
            if (maxTemp < maxT[vecka])
            {
                maxTemp = maxT[vecka];
            }
            if (minTemp > minT[vecka])
            {
                minTemp = minT[vecka];
            }
            sumTemp += sumT[vecka];
        }
        medelTemp = sumTemp / (antalMatningarPerVecka * antalVeckor);

        //visa minsta, största och medeltemperaturen i hela mätperioden
        //koden ska skrivas här
        System.out.println("Största temperaturen under hela mätperioden var: " + maxTemp);
        System.out.println("Minsta temperaturen under hela mätperioden var: " + minTemp);
        System.out.println("Summan av temperaturerna under hela mätperioden var: " + sumTemp);
        System.out.println("Medeltemperaturen under hela mätperioden var: " + medelTemp);
    }
}

