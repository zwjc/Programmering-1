import java.util.Scanner;
import static java.lang.System.out;

public class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar
{
    public static void main (String[] args)
    {
        out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRÄNGAR\n");

        // mata in två naturliga heltal
        Scanner in = new Scanner (System.in);
        out.println ("två naturliga heltal: ");
        String tal1 = in.next();
        String tal2 = in.next();
        out.println ();

        // addera heltalen och visa resultatet
        String summa = addera (tal1, tal2);
        visa (tal1, tal2, summa, '+');

        // subtrahera heltalen och visa resultatet
        String differens = subtrahera (tal1, tal2);
        visa (tal1, tal2, differens, '-');
    }

    // addera tar emot två naturliga heltal givna som teckensträngar, och returnerar deras
    // summa somen teckensträng.
    public static String addera (String tal1, String tal2)
    {
        // se till att längre talet är lagrat i tal2, (tal2 > tal 1)
        if (tal1.length() > tal2.length())
        {
            String x = tal1;
            tal1 = tal2;
            tal2 = x;
        }

        // tom sträng för att lagra resultat
        String tal = "";

        // få ut längderna av strängarna
        int n1 = tal1.length();
        int n2 = tal2.length();

        // reversa strängarna
        tal1 = new StringBuilder(tal1).reverse().toString();
        tal2 = new StringBuilder(tal2).reverse().toString();

        int carry = 0;
        for (int i = 0; i < n1; i++)
        {
            // uträkningen + carry, uträkningen fungerar så att talen adderas en åt gången som int
            int summa = ((int)tal1.charAt(i) - '0') + ((int)(tal2.charAt(i)) - '0' + carry);
            tal += (char)(summa % 10 + '0');

            // 10-tal som carry
            carry = summa / 10;
        }

        // lägg till resten av tal2 till summan och en eventuell carry
        for (int i = n1; i < n2; i++)
        {
            int summa = (((int)(tal2.charAt(i)) - '0') + carry);
            tal += (char)(summa % 10 + '0');
            carry = summa / 10;
        }

        // lägg till resten av carry
        if (carry > 0)
            tal += (char)(carry + '0');

        // reverse tillbaks så strängen är åt rätt håll
        tal = new StringBuilder(tal).reverse().toString();

        return tal;
    }
    // subtrahera tar emot två naturliga heltal givna som teckensträngar, och returnerar
    // deras differens somen teckensträng.
    // Det första heltalet är inte mindre än det andra heltalet.

    // tal2 ska vara större än tal1
    static boolean forVillkor(String str1, String str2)
    {
        // längderna av strängarna
        int n1 = str1.length();
        int n2 = str2.length();
        if (n1 < n2)
            return true;
        if (n2 < n1)
            return false;

        for (int i = 0; i < n1; i++)
            if (str1.charAt(i) < str2.charAt(i))
                return true;
            else if (str1.charAt(i) > str2.charAt(i))
                return false;

        return false;
    }
    public static String subtrahera (String tal1, String tal2)
    {
        // tal1 > tal2
        if (forVillkor(tal1, tal2))
        {
            String x = tal1;
            tal1 = tal2;
            tal2 = x;
        }

        // tom sträng för att lagra
        String tal = "";

        // längd av sträng
        int n1 = tal1.length();
        int n2 = tal2.length();

        // reverse strängarna
        tal1 = new StringBuilder(tal1).reverse().toString();
        tal2 = new StringBuilder(tal2).reverse().toString();

        int carry = 0;

        // subtrahera  tal1 - tal2
        for (int i = 0; i < n2; i++)
        {
            int differens = (((int)(tal1.charAt(i)) - '0') - ((int)(tal2.charAt(i)) - '0') - carry);

            // om differens < 0, lägg till 10 och ta carry = 1
            if (differens < 0)
            {
                differens = differens + 10;
                carry = 1;
            }
            else
                carry = 0;

            tal += (char)(differens + '0');
        }
        for (int i = n2; i < n1; i++)
        {
            int differens = (((int)(tal1.charAt(i)) - '0') - carry);

            // om differens < 0, ändra till > 0
            if (differens < 0) {
                differens = differens + 10;
                carry = 1;
            }
            else
                carry = 0;

            tal += (char)(differens + '0');
        }

        // reverse strängen
        return new StringBuilder(tal).reverse().toString();
    }
    // visa visar två givna naturliga heltal, och resultatet av en aritmetisk operation
    // utförd i samband med hetalen
    public static void visa (String tal1, String tal2,String resultat, char operator)
    {
        // sätt en lämplig längd på heltalen och resultatetint
        int len1 = tal1.length ();
        int len2 = tal2.length ();
        int len  = resultat.length ();
        int maxLen = Math.max (Math.max (len1, len2), len);
        tal1 = sattLen (tal1, maxLen - len1);
        tal2 = sattLen (tal2, maxLen - len2);
        resultat = sattLen (resultat, maxLen - len);

        // visa heltalen och resultatet
        out.println (" " + tal1);
        out.println ("" + operator + " " + tal2);
        for (int i = 0; i < maxLen + 2; i++)
            out.print ("-");
        out.println ();
        out.println ("  " + resultat + "\n");
    }
    // sattLen lägger till ett angivet antal mellanslag i början av en given sträng
    public static String sattLen (String s, int antal)
    {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < antal; i++)
            sb.insert (0, " ");

        return sb.toString();
    }
}
