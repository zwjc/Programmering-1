public class Punkt
{
    int x = 0;
    int y = 0;
    String namn = "";

    public Punkt (String namn, int x, int y){
        this.namn = namn;
        this.x = x;
        this.y = y;
    }

    public Punkt (Punkt p) {
        this.namn = p.namn;
        this.x = p.x;
        this.y = p.y;
    }

    public String toString(){
        String string = "";
        string = "(" + namn + ", " + x + ", " + y + ")";
        return string;
    }

    public String getNamn(){
        return namn;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double avstand(Punkt p2){
        int nyx = p2.x - x;
        int nyy = p2.y - y;
        double avstand = Math.sqrt((Math.pow(nyx, 2) + (Math.pow(nyy, 2))));
        return avstand;
    }

    public boolean equals(Punkt p2){
        if (p2.x == x && p2.y == y)
            return true;
            else
                return false;
    }

    public void setX(int i){
        x = i;
    }

    public void setY(int i){
        y = i;
    }
}
