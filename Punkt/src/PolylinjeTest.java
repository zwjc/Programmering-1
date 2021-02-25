public class PolylinjeTest
{
    public static void main (String[] args) {
        Punkt p0 = new Punkt("A", 4, 6);
        Punkt p1 = new Punkt("B", 3, 4);
        Punkt p2 = new Punkt("C", 2, 2);
        Punkt p3 = new Punkt("D", 1, 0);

        Punkt[] punkt = new Punkt[4];

        punkt[0] = p0;
        punkt[1] = p1;
        punkt[2] = p2;
        punkt[3] = p3;

        Polylinje polylinje = new Polylinje(punkt);
        System.out.println(polylinje);


        // testa laggtillframfor
        polylinje.laggTillFramfor((new Punkt("E", 0, 2)), "C");
        System.out.println(polylinje.toString());

        // testa tabort
        polylinje.taBort("B");
        System.out.println(polylinje.toString());

        // iteratorn
        Polylinje.PolylinjeIterator iterator = polylinje.iterator(); //anropar metoden
        while (iterator.finnsHorn()) {
            System.out.println(iterator.horn());
            iterator.gaFram();
        }
    }
}