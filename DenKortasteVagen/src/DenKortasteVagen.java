

public class DenKortasteVagen
{
    /** mellanstationer returnerar en vektor med de mellanstationer som finns på den kortaste
     vägen. Ordningsnummer av den första mellanstationen finns på index 1, och ordningsnummer
     av den andra mellanstationen på index 2 i vektorn
     * @return**/
    public static int[] mellanstationer (double[] XtoU, double[][] UtoV, double[] VtoY)
    {
        double min = UtoV[0][0] + XtoU[0] + VtoY[0];
        double U = XtoU.length;
        double V = VtoY.length;
        // String Vag = "U1 och V1";
        int [] Vag = new int[2];
        Vag [0] = 0;
        Vag [1] = 0;
        for (int i = 0; i < U; i++)
        {
            for (int j = 0; j < V; j++)
            {
                double KortasteVagen = UtoV[i][j] + XtoU[i] + VtoY[j];
                System.out.println("U" + (i+1) + " + V" + (j+1) + " = " + KortasteVagen);
                if (KortasteVagen < min)
                {
                    min = KortasteVagen;
                    // Vag = "U" + (i+1) + " + V" + (j+1);
                    Vag[0] = (i+1);
                    Vag[1] = (j+1);
                }
            }
            System.out.println();
        }
        return Vag;
    }

    // langd returnerar längden av den kortaste vägen.

    public static double langd (double[] XtoU, double[][] UtoV, double[] VtoY)
    {
        double U = XtoU.length;
        double V = VtoY.length;
        double min = XtoU[0] + UtoV[0][0] + VtoY[0];
        for (int i = 0; i < U; i++)
        {
            for (int i2 = 0; i2 < V; i2++)
            {
                double KortasteVagen = UtoV[i][i2] + XtoU[i] + VtoY[i2];
                if (KortasteVagen < min)
                {
                    min = KortasteVagen;
                }
            }
        }
        return min;
    }
}

