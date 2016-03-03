package com.android.nauteam.bullsandcows.model;

import java.util.ArrayList;

public class Game {
    
    private ArrayList<Turn> mTurns;
    private Number mSecretNum;

    public Game() {
        mSecretNum = new Number();
        mTurns = new ArrayList<Turn>();
    }

    public Game(String info) {
        //Example of info is "g/****/t/****/*/*t/****/*/*/..."
        //  Split it and we will have array splitedStrArray, example is:
        //      splitedStrArray[0] = "g/****/"
        //      splitedStrArray[1] = "****/*/*"
        //      splitedStrArray[1] = "****/*/*"
        String [] splitedStrArray = info.split("t/");

        // This is regular expressions. Means: \D - not digits, + one or more times.
        // So the full meaning is to replays all not digits to ""
        String secretNumStr = splitedStrArray[0].replaceAll("\\D+","");
        mSecretNum = new Number(secretNumStr);

        for(byte i = 1; i < splitedStrArray.length; i++)
            mTurns.add(new Turn(splitedStrArray[i]));
    }
    
    public ArrayList<Turn> getTurns() {
        return mTurns;
    }
    
    public Number getSecretNum() {
        return mSecretNum;
    }
    
    public String getLevel() {
        int level = mTurns.size();
        String strLevel;
        switch (level) {
            case 1:
                strLevel = "SUPERMEGAFARMER";
            case 2:
                strLevel = "Expert";
            case 3:
                strLevel = "Big Boss";
            case 4:
                strLevel = "Elect";
            case 5:
                strLevel = "Pretty Boy";
            case 6:
                strLevel = "Senior";
            case 7:
                strLevel = "CowBoy";
            case 8:
                strLevel = "Advansed";
            case 9:
                strLevel = "Pick-up Wizard";
            case 10:
                strLevel = "Skillful";
            case 11:
                strLevel = "Talented";
            case 12:
                strLevel = "50 / 50";
            case 13:
                strLevel = "Lucky Devil";
            case 14:
                strLevel = "Budding";
            case 15:
                strLevel = "Intermediate";
            case 16:
                strLevel = "Junior";
            case 17:
                strLevel = "School Child";
            case 18:
                strLevel = "Mother's Darling";
            case 19:
                strLevel = "Baby";
            default:
                strLevel = "Newbie";
        }

        return strLevel;
    }

    @Override
    public String toString() {
        String tmp = "g/";
        tmp += mSecretNum.getDigits();
        tmp += "/";
        
        for(byte i = 0; i < mTurns.size(); i++)
            tmp += mTurns.get(i).toString();
        
        return tmp;
    }
}
