// HeltalsSekvens.java

//ett program som på olika sätta hanterar en sekvens med heltal

public class HeltalsSekvens
{
    public static void main (String[] args)
    {
        System.out.println("EN SEKVENS MED HELTAL\n\n");

        java.util.Scanner   in = new java.util.Scanner(System.in);
        in.useLocale(java.util.Locale.US);

      int[]  u = new int[10 + 1];
        System.out.println("ange 10 heltal i en rad: ");
        for (int i = 1; i < u.length; i++)
            u[i] = in.nextInt();
        System.out.println();

        int min = u[1];
        int sum = u[1];
        for (int i = 2; i < u.length; i++) {
            if (u[i] < min)
                min = u[i];
            sum += u[i];
            }
        double mean = (double) sum / (u.length - 1);

        System.out.println("minsta heltalet och heltalens medelvarde");
        System.out.printf("%4d | %7.2f\n\n\n", min, mean);
    }
}
