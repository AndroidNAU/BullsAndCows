/**
 * Created by Maxim on 02.02.2016.
 */
public class Number {
    private byte [] mDigits = new byte[4];

    public void setNumber(String strNumber)
    {
        mDigits = strNumber.getBytes();
    }

    public Number(String strNumber)
    {
        setNumber(strNumber);
    }

    public String getDigits()
    {
        return mDigits.toString();
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
