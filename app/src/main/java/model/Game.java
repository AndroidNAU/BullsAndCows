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
        String [] secretNumWithTurns = tmp.split("/t");
       
          //  So we will have array secretNumWithTurns, example is:
          //      secretNumWithTurns[0] = "g/****"
          //      secretNumWithTurns[1] = "/****/*/*t/****/*/*"
        
        String forSecretNum = secretNumWithTurns[0].replaceAll("g/", "");
        //After that forSecretNum will look like "****"
        mSecretNum = new Number(forSecretNum);
         
        String [] forAllTurns = secretNumWithTurns[1].split("t");
        
        //    Example of all turns is:
        //        forAllTurns[0] = "/****/*/*"
        //        forAllTurns[1] = "/****/*/*"
        //        forAllTurns[2] = "/****/*/*"
        //        forAllTurns[3] = "/****/*/*"
        
        for(byte i = 0; i < forAllTurns.length; i++)
        {
            Turn tmpTurn = new Turn(forAllTurns[i]);
            mTurns.add(tmpTurn);
        }
        
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
