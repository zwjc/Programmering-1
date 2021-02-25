import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class BestamDenKortasteVagen
{
    public static void main (String[] args)
    {

        //Skapa Värden
        Scanner in = new Scanner (System.in);
        in.useLocale (Locale.US);

        System.out.println ("Antalet Stationer U: ");
        int U = in.nextInt ();
        System.out.println ("Antalet Stationer V: ");
        int V = in.nextInt ();

        double [] XtoU = new double [U];
        double[] VtoY = new double[V];
        double[][] UtoV = new double[U][V];

        for(int i = 0; i < U; i++)
        {
            System.out.println("Längd mellan X och U: ");
            XtoU[i] = in.nextInt();
            in.nextLine();
        }
        for(int i = 0; i < V; i++)
        {
            System.out.println("Längd mellan V och Y: ");
            VtoY[i] = in.nextInt();
        }
            for(int i = 0; i < U; i++)
            {
            for (int i2 = 0; i2 < V; i2++)
            {
                System.out.println ("Längd mellan U och V: ");
                UtoV[i][i2] =  in.nextInt();
            }
        }

        int [] Vag = DenKortasteVagen.mellanstationer(XtoU, UtoV, VtoY);
        System.out.println("Kortaste Vägen mellan Stationerna är mellan " +"U" +Vag[0] +" och V"+ Vag[1]);
        System.out.println ("Avstånd från X till U: " + Arrays.toString(XtoU) +
                "\nAvstånd från V till Y: " + Arrays.toString(VtoY));
        System.out.println("Den Kortaste Vägen har avståndet: " +DenKortasteVagen.langd(XtoU, UtoV, VtoY));
    }
}
