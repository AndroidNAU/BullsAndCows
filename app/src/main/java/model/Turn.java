package model;

/**
 * Created by Shady on 12.02.2016.
 */
public class Turn {

    private Number mNumber;
    private byte mBulls;
    private byte mCows;

    public Turn(String tmp){
        String forNumber = tmp.substring(2, 6);
        mNumber = new Number(forNumber);

        String forBulls = tmp.substring(7, 8);
        mBulls = Byte.decode(forBulls);

        String forCows = tmp.substring(9);
        mCows = Byte.decode(forCows);
    }

    public void setMNumber(Number usrNumber){
        mNumber = usrNumber;
    }

    public Number getMNumber(){
        return mNumber;
    }

    public void setMBulls(byte usrBulls){
        mBulls = usrBulls;
    }

    public byte getMBulls(){
        return mBulls;
    }

    public void setMCows(byte usrCows){
        mCows = usrCows;
    }

    public byte getMCows(){
        return mCows;
    }

    public String toMString()
    {
        String tmp;
        tmp = "t/";
        tmp += mNumber.getDigits();
        tmp += "/";
        tmp += Byte.toString(mBulls);
        tmp += "/";
        tmp += Byte.toString(mCows);
        return tmp;
    }

}