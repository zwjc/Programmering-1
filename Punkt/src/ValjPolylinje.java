import java.util.Random;

public class ValjPolylinje
{
    public static final Random rand = new Random ();
    public static final int ANTAL_POLYLINJER = 10;

    public static void main (java.lang.String[] args)
    {
        // skapa ett antal slumpmässiga polylinjer
        Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];

        for (int i = 0; i < ANTAL_POLYLINJER; i++)
            polylinjer[i] = slumpPolylinje ();

        // visa polylinjerna
        for (int i = 0; i < polylinjer.length; i++) {
            System.out.println("Polylinje " + polylinjer[i] + "langd " + polylinjer[i].langd());
        }

        // bestäm den kortaste av de polylinjer som är gula

        int i = 0;
        while(!polylinjer[i].getFarg().equals("gul")) {
            i++;
        }
        Polylinje kortasteGul = polylinjer[i];

        for (int j = i; j < polylinjer.length; j++) {
            if(kortasteGul.langd() > polylinjer[j].langd() && polylinjer[j].getFarg().equals("gul"))
            {
                kortasteGul = polylinjer[j];
            }
        }

                System.out.println("Kortaste gul är : " + kortasteGul + "Längd: " + kortasteGul.langd());

        // visa den valda polylinjen

    }
    // slumpPunkt returnerar en punkt med ett slumpmässigt namn,som är en stor bokstav i
    // det engelska alfabetet, ochslumpmässiga koordinater.

    public static Punkt slumpPunkt ()
    {
        String    n = "" + (char) (65 + rand.nextInt (26));
        int    x = rand.nextInt (11);
        int    y = rand.nextInt (11);

        return new Punkt (n, x, y);
    }

    // slumpPolylinje returnerar en slumpmässig polylinje, varsfärg är antingen blå, eller röd
    // eller gul. Namn på polylinjens hörn är stora bokstäver i det engelskaalfabetet. Två hörn
    // kan inte ha samma namn.
    public static Polylinje slumpPolylinje ()
    {
        // skapa en tom polylinje, och lägg till hörn till den
        Polylinje polylinje = new Polylinje ();
        int antalHorn = 2 + rand.nextInt (7);
        int antalValdaHorn = 0;
        boolean[] valdaNamn = new boolean[26];

        // ett och samma namn kan inte förekomma flera gånger
        Punkt valdPunkt = null;
        // char valtChar = 0;
        while (antalValdaHorn < antalHorn)
        {
            valdPunkt = slumpPunkt();
            int index = valdPunkt.getNamn().charAt(0) - 65;
            if(valdaNamn[index] == false)
            {
                polylinje.laggTill(valdPunkt);
                valdaNamn[index] = true;
                antalValdaHorn++;
            }
        }
        // sätt färg
            String farger[] = {"gul", "blå", "röd"};
            polylinje.setFarg(farger[rand.nextInt(3)]);
            return polylinje;
    }
}
