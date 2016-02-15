package model;
import java.util.Random;

/**
 * Created by Maxim on 02.02.2016.
 */
public class Number {
    private byte [] mDigits = new byte[4];

    //This constructor is random generate Number    
    public Number(){
        Random r = new Random();
        /*
            Here we have to generate mSecretNum.
            For that we use Array of integer numbers.
            But the first element of this array must not be equel to zero.
            It means that boundaries for the first element should be from 1 to 9.
            Also boundaries for other elements should be from 0 to 9.
            And all other elements must not be equals to each other.
            For make boundaries of random generation we use this formula:
                nextInt(max - min + 1) + min
        */        
        for (int i = 0; i < 4; i++) 
        {
            //Generate the first element 
            if (i == 0)
            {
                final int max = 9;
                final int min = 1;
                mDigits[i] = (byte) (r.nextInt(max - min + 1) + min);
            }
            //Generate other elements 
            else 
            {
                final int max = 9;
                final int min = 0;
                mDigits[i] = (byte) (r.nextInt(max - min + 1) + min);
                
                //If elements are equals we should generate them one more time
                int j = 0;
                while (j < i) 
                {
                    if (mDigits[i] == mDigits[j])
                    {
                        mDigits[i] = (byte) (r.nextInt(max - min + 1) + min);
                        j = 0;
                    }
                    else
                    { 
                        j++;
                    }
                }
            }            
        }
    }

    public void setNumber(String strNumber)
    {
        char [] tmpArr = strNumber.toCharArray();
        for(byte i = 0; i < 4; i++)
            mDigits[i] = Byte.decode(String.valueOf(tmpArr[i]));
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
