package com.android.nauteam.bullsandcows.model;

public class Turn {

    private Number mNumber;
    private byte mBulls;
    private byte mCows;

    public Turn(String tmp) {
        // Example of tmp is "****/*/*"
        // After this split we have such array
        //  forTurnArr[0] = "****"
        //  forTurnArr[1] = "*"
        //  forTurnArr[2] = "*"
        String [] forTurnArr = tmp.split("/");
        
        String forNumber = forTurnArr[0];
        mNumber = new Number(forNumber);
        
        String forBulls = forTurnArr[1];
        mBulls = Byte.decode(forBulls);
        
        String forCows = forTurnArr[2];
        mCows = Byte.decode(forCows);
    }

    public Turn(Number num) {
        mNumber = num;
        mBulls = 0;
        mCows = 0;
    }

    public void setNumber(Number usrNumber) {
        mNumber = usrNumber;
    }

    public Number getNumber() {
        return mNumber;
    }

    public void setBulls(byte usrBulls) {
        mBulls = usrBulls;
    }

    public byte getBulls() {
        return mBulls;
    }

    public void setCows(byte usrCows) {
        mCows = usrCows;
    }

    public byte getCows() {
        return mCows;
    }

    @Override
    public String toString() {
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