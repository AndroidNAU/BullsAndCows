package model;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Maxim
 */
public class Game {
    
    private ArrayList<Turn> mTurns;
    private Number mSecretNum;
    
    public ArrayList<Turn> getMTurns(){
        return mTurns;
    }
    
    public Number getMSecretNum(){
        return mSecretNum;
    }
    
    public Game(){
        mSecretNum = new Number();
    }
    
    public Game(String tmp)
    {
        //Example of tmp is "g/****/t/****/*/*t/****/*/*"
        String [] secretNumWithTurns = tmp.split("t/");
       
          //  So we will have array secretNumWithTurns, example is:
          //      secretNumWithTurns[0] = "g/****/"
          //      secretNumWithTurns[1] = "****/*/*"
          //      secretNumWithTurns[1] = "****/*/*"
        
        String forSecretNum = secretNumWithTurns[0].replaceAll("g/", "");
        forSecretNum = forSecretNum.replaceAll("/", "");
        //After that forSecretNum will look like "****"
        mSecretNum = new Number(forSecretNum);
        
        for(byte i = 1; i < secretNumWithTurns.length; i++)
        {
           Turn tmpTurn = new Turn(secretNumWithTurns[i]);
           mTurns.add(tmpTurn);
        }
        
    }
    
    public String getLevel()
    {
        int level = mTurns.size();
        String strLevel;
        switch (level){
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
 
    public String toMString()
    {
        String tmp = "g/";
        tmp += mSecretNum.getDigits();
        tmp += "/";
        
        for(byte i = 0; i < mTurns.size(); i++)
            tmp += mTurns.get(i).toMString();
        
        return tmp;
    }
}
