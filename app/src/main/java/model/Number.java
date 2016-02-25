package model;

import java.util.Random;

public class Number {

    private byte [] mDigits = new byte[4];

    private final static Random r = new Random();
    private final static byte DIGITS_IN_NUM = 4;

    //This constructor is random generate Number    
    public Number() {
        generateSecretNumber();
    }

    /*
       Here we have to generate mSecretNum.
       For that we use Array of integer numbers.
       But the first element of this array must not be equal to zero.
       It means that boundaries for the first element should be from 1 to 9.
       Also boundaries for other elements should be from 0 to 9.
       And all other elements must not be equals to each other.
       For make boundaries of random generation we use this formula:
           nextInt(max - min + 1) + min
    */
    private void generateSecretNumber() {
        mDigits[0] = generateRandomDigitInRange(1, 9);

        for (byte i = 1; i < DIGITS_IN_NUM; i++)
            mDigits[i] = generateNextDigit();
    }

    private byte generateNextDigit() {
        byte digit;
        do {
            digit = generateRandomDigitInRange(0, 9);
        } while (checkIfDigitExist(digit));

        return digit;
    }

    private byte generateRandomDigitInRange(int min, int max) {
        return (byte) (r.nextInt(max - min + 1) + min);
    }

    private boolean checkIfDigitExist(byte digit) {
        for (byte i = 0; i < DIGITS_IN_NUM; i++)
            if (mDigits[i] == digit)
                return true;

        return false;
    }

    public Number(String strNumber) {
        setNumber(strNumber);
    }

    public void setNumber(String strNumber) {
        char [] tmpArr = strNumber.toCharArray();
        for(byte i = 0; i < DIGITS_IN_NUM; i++)
            mDigits[i] = Byte.decode(String.valueOf(tmpArr[i]));
    }

    public String getDigits() {
        String tmp = "";
        for(byte i = 0; i < DIGITS_IN_NUM; i++)
            tmp += Byte.toString(mDigits[i]);

        return tmp;
    }

    public byte getCows(Number usrNumber) {
        byte cow = 0;
        for (byte i = 0; i < DIGITS_IN_NUM; i++)
            for(byte j = 0; j < DIGITS_IN_NUM; j++)
                if( (this.mDigits[i] == usrNumber.mDigits[j]) && (i != j) )
                    cow++;

        return cow;
    }

    public byte getBulls(Number usrNumber) {
        byte bull = 0;
        for(byte i = 0; i < DIGITS_IN_NUM; i++)
            if(this.mDigits[i] == usrNumber.mDigits[i])
                bull++;

        return bull;
    }
}
