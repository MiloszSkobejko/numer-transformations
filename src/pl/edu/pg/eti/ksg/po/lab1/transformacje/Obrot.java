package pl.edu.pg.eti.ksg.po.lab1.transformacje;
import static java.lang.Math.*;

public class Obrot implements Transformacja {
    private final double angle;

    public Obrot(double ang) {
        this.angle = ang;
    }

    public double getAngle() {
        return angle;
    }

    @Override
    public Transformacja getTransformacjaOdwrotna() {
        return new Obrot(-angle);
    }

    @Override
    public Punkt transformuj(Punkt p)
    {
        double curr_sin = sin(Math.toRadians(angle));
        double curr_cos = cos(Math.toRadians(angle));

        /* Wyjatki dla poprawnego dzialania */
        if (Math.abs(angle) == 0 || Math.abs(angle) == 180 || Math.abs(angle) == 360)
            curr_sin = 0;

        if (Math.abs(angle) == 90 || Math.abs(angle) == 270)
            curr_cos = 0;

        double newX = (p.getX() * curr_cos) - (p.getY() * curr_sin);
        double newY = (p.getX() * curr_sin) + (p.getY() * curr_cos);

        return new Punkt(newX, newY);
    }

    @Override
    public String toString() {
        return "Obrot wzgledem (0,0) o " + angle + " stopni";
    }
}
