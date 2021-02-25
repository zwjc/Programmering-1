import java.util.UUID;

public class Polylinje
{
    // tom polylinje
    private Punkt[] horn;

    // färgen
    private String farg = "svart";

    // bredden
    private int bredd = 1;

    // skapa en polylinje utan hörn
    public Polylinje()
    {
        this.horn = new Punkt[0];
    }

    // skapar en polylinje med argument

    public Polylinje (Punkt[] horn)
    {
        this.horn = new Punkt[horn.length];
        for (int i = 0; i < horn.length; i++)
            this.horn[i] = new Punkt (horn[i]);
    }

    // konverterar
    public String toString()
    {
        StringBuilder sb = new StringBuilder(" { ");

        for (int i = 0; i < horn.length; i++) {
            sb.append("[" + horn[i] + "]");
        }
        sb.append("], " + farg + "," + bredd + " }");

        return (sb.toString());
    }

    // Inspektor

    // getHorn returnerar hörnen i punkt array

    public Punkt[] getHorn()
    {
        Punkt[] horn = new Punkt[this.horn.length];
        for (int i = 0; i < this.horn.length; i++)
            horn[i] = new Punkt (this.horn[i]);

        return horn;
    }

    // getFarg returnerar färg i sträng
    public String getFarg()
    {
        return farg;
    }

    // getBredd returnerar bredd i integer
    public int getBredd()
    {
        return bredd;
    }

    // Mutatorer

    // setFarg låter användaren ange färg
    public void setFarg(String farg)
    {
        this.farg = farg;
    }

    // setBredd låter användaren ange bredd
    public void setBredd(int bredd)
    {
        this.bredd = bredd;
    }

    // langd räknar längden på polylinjen
    public double langd()
    {
        double langd = 0;
        for (int i = 0; i < horn.length - 1; i++)
            langd = langd + horn[i].avstand(horn[i + 1]);

        return langd;

    }

    // laggtill lägger till en linje vid slutet
    public void laggTill(Punkt horn)
    {
        Punkt[] h = new Punkt[this.horn.length + 1];
        int i = 0;
        for (i = 0; i < this.horn.length; i++)
            h[i] = this.horn[i];
        h[i] = new Punkt(horn);
        this.horn = h;
    }

    // läggtillframför lägger till en linje framför en vald linje
    public void laggTillFramfor(Punkt horn, String hornNamn)
    {
        // hitta new punkt och lägg till
        Punkt[] h = new Punkt[this.horn.length + 1];

        int i = 0;
        int pos = 0;

        while (!hornNamn.equals(this.horn[i].getNamn()))
        {
            i++;
            pos = i;
        }
        for (i = 0; i < pos; i++)
        {
            h[i] = this.horn[i];
        }
        h[pos] = new Punkt(horn);

        for (i = pos + 1; i < h.length; i++)
        {
            h[i] = this.horn[i - 1];
        }
        this.horn = h;
    }

    public void taBort (String hornNamn)
    {
        Punkt[] h = new Punkt[this.horn.length - 1];

        // samma som innan men istället för att lägga till på positionen så tar jag bort
        int i = 0;
        int pos = 0;
        while (!hornNamn.equals(this.horn[i].getNamn()))
        {
            i++;
            pos = i;
        }
        i = 0;
        while (i < pos)
        {
            h[i] = this.horn[i];
            i++;
        }

        for(i = pos; i < h.length; i++){
            h[i] = this.horn[i +1];
        }
        this.horn = h;
    }

    public PolylinjeIterator iterator()
    {
        return new Polylinje.PolylinjeIterator();
    }
    public class PolylinjeIterator
    {
        private int aktuell = -1;

        public PolylinjeIterator()
        {
            if (Polylinje.this.horn.length > 0)
                aktuell = 0;
        }

        public boolean finnsHorn()
        {
            return aktuell != -1;
        }

        public Punkt horn() throws java.util.NoSuchElementException
        {
            if (!this.finnsHorn())
                throw new java.util.NoSuchElementException("slut av iterationen");
            Punkt horn = Polylinje.this.horn[aktuell];
            return horn;
        }

        public void gaFram()
        {
            if (aktuell >= 0 && aktuell < Polylinje.this.horn.length - 1)
                aktuell++;
            else
                aktuell = -1;
        }
    }
}
