package model;

/**
 * Created by Maxim on 02.02.2016.
 */
public class Number {
    private byte [] mDigits = new byte[4];

    public void setNumber(String strNumber)
    {
        for(byte i = 0; i < 4; i++)
        {
            String tmp = strNumber.substring(i, i + 1);
            mDigits[i] = Byte.decode(tmp);
        }
    }

    public Number(String strNumber)
    {
        setNumber(strNumber);
    }

    public String getDigits()
    {
        String tmp;
        tmp = Byte.toString(mDigits[0]);
        for(byte i = 1; i < 4; i++)
            tmp += Byte.toString(mDigits[i]);
        return tmp;
    }

    public byte getCows(Number usrNumber)
    {
        byte cow = 0;
        for (byte i = 0; i < 4; i++)
            for(byte j = 0; j < 4; j++)
                if((this.mDigits[i] == usrNumber.mDigits[j])&&(i != j))
                    cow++;
        return cow;
    }

    public byte getBulls(Number usrNumber)
    {
        byte bull = 0;
        for(byte i = 0; i < 4; i++)
            if(this.mDigits[i] == usrNumber.mDigits[i])
                bull++;
        return bull;
    }
}
