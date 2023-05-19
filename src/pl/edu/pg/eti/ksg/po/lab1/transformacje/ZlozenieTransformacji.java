package pl.edu.pg.eti.ksg.po.lab1.transformacje;

public class ZlozenieTransformacji implements Transformacja {

    private Transformacja trans[];


    /* KONSTRUKTOR */
    public ZlozenieTransformacji(Transformacja[] tab)
    {
        this.trans = tab;
    }


    public Transformacja[] getTransformacja()
    {
        return this.trans;
    }


    @Override
    public Punkt transformuj(Punkt p)
    {
        for (Transformacja tran : trans)
            p = tran.transformuj(p);

        return p;
    }


    @Override
    public Transformacja getTransformacjaOdwrotna() throws BrakTransformacjiOdwrotnejException
    {
        Transformacja ret[] = new Transformacja[this.trans.length];

       for (int i = this.trans.length - 1, j = 0; i >= 0; i--, j++)
          ret[j] = this.trans[i].getTransformacjaOdwrotna();

       /* Ta niżej nie odwraca kolejnosci */
//        for (int i = 0; i < this.trans.length; i++)
//            ret[i] = this.trans[i].getTransformacjaOdwrotna();

        return new ZlozenieTransformacji(ret);
    }


    @Override
    public String toString()
    {
        String return_string = "Transformacje zlozone o: \n";

        for (int i = 0; i < this.trans.length; i++)
        {
            return_string += "\t" + (i + 1) + ") ";
            return_string += this.trans[i].toString();
            return_string += "\n";
        }
        return return_string;
    }
}
