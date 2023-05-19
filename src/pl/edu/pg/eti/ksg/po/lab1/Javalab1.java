package pl.edu.pg.eti.ksg.po.lab1;
import pl.edu.pg.eti.ksg.po.lab1.transformacje.*;

public class Javalab1 {
        public static void main(String[] args) {

                int blok_err = 1;

                System.out.println("\n******** TEST TRANSORMACJI ZŁOŻONYCH *********\n");

                try {
                        Punkt p1 = new Punkt(3, 5);
                        System.out.println(p1);

                        Transformacja [] transformacje = new Transformacja[3];
                        transformacje[0] = new Obrot(180);
                        transformacje[1] = new Skalowanie(4,8);
                        transformacje[2] = new Translacja(10, 10);

                        Transformacja zlozona = new ZlozenieTransformacji(transformacje);
                        System.out.println(zlozona);


                        /* Operacje: */
                        Punkt p2 = zlozona.transformuj(p1);
                        System.out.println(p2);

                        Transformacja zlozona_inv = zlozona.getTransformacjaOdwrotna();
                        System.out.println(zlozona_inv);

                        Punkt p3 = zlozona_inv.transformuj(p2);
                        System.out.println(p3);


                } catch (BrakTransformacjiOdwrotnejException ex)
                {
                        System.out.println("Znaleziono wyjatek w bloku " + blok_err);
                        ex.printStackTrace();
                }

                System.out.println();
                System.out.println("\n******** TEST OBROTU  *********\n");
                blok_err++;

                try {
                        Punkt p1 = new Punkt(0, 5);
                        System.out.println(p1);
                        Transformacja obr1 = new Obrot(90);
                        System.out.println(obr1);
                        Punkt p2 = obr1.transformuj(p1);
                        System.out.println(p2);
                        Transformacja obr2 = obr1.getTransformacjaOdwrotna();
                        System.out.println(obr2);
                        Punkt p3 = obr2.transformuj(p2);
                        System.out.println(p3);


                } catch (BrakTransformacjiOdwrotnejException ex)
                {
                        System.out.println("Znaleziono wyjatek w bloku " + blok_err);
                        ex.printStackTrace();
                }

                System.out.println();
                System.out.println("\n******** TEST TRANSLACJI  *********\n");
                blok_err++;

                try {
                        Punkt p1 = Punkt.E_X;
                        System.out.println(p1);
                        Transformacja tr = new Translacja(5, 6);
                        System.out.println(tr);
                        Punkt p2 = tr.transformuj(p1);
                        System.out.println(p2);
                        Transformacja trr = tr.getTransformacjaOdwrotna();
                        System.out.println(trr);
                        Punkt p3 = trr.transformuj(p2);
                        System.out.println(p3);
                } catch (BrakTransformacjiOdwrotnejException ex)
                {
                        System.out.println("Znaleziono wyjatek w bloku " + blok_err);
                        ex.printStackTrace();
                }

                System.out.println();
                System.out.println("\n******** TEST SKALOWANIA  *********\n");
                blok_err++;

                try {
                        Punkt p1 = new Punkt(2, 2);
                        System.out.println(p1);
                        Transformacja tr2 = new Skalowanie(5, 4);
                        System.out.println(tr2);
                        Punkt p2 = tr2.transformuj(p1);
                        System.out.println(p2);
                        Transformacja trr2 = tr2.getTransformacjaOdwrotna();
                        System.out.println(trr2);
                        Punkt p3 = trr2.transformuj(p2);
                        System.out.println(p3);
                } catch (BrakTransformacjiOdwrotnejException ex)
                {
                        System.out.println("Znaleziono wyjatek w bloku " + blok_err);
                        ex.printStackTrace();
                }

                System.out.println();
                System.out.println("\n******** TEST SKALOWANIA PRZEZ 0 *********\n");
                blok_err++;

//                try {
//                        Punkt p1 = new Punkt(2, 2);
//                        Transformacja tr2 = new Skalowanie(5, 0);
//                        System.out.println(tr2);
//                        System.out.println(p1);
//                        Punkt p2 = tr2.transformuj(p1);
//                        System.out.println(p2);
//                        Transformacja trr2 = tr2.getTransformacjaOdwrotna();
//                        System.out.println(trr2);
//                        Punkt p3 = trr2.transformuj(p2);
//                        System.out.println(p3);
//                } catch (BrakTransformacjiOdwrotnejException ex)
//                {
//                        System.out.println("Znaleziono wyjatek w bloku " + blok_err);
//                        ex.printStackTrace();
//                }
//                System.out.println();
        }
}
