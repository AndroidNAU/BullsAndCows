/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author Maxim
 */
public class NewGame extends Game{
    private boolean mIsFinished;
    
    public void setMIsfinished()
    {
        ArrayList<Turn> tmpTurns = getMTurns();
        int lastIndex = tmpTurns.lastIndexOf(tmpTurns);
        Turn lastTurn = tmpTurns.get(lastIndex);
        if(lastTurn.getMBulls() == 4)
            mIsFinished = true;
        else
            mIsFinished = false;
    }
    
    public boolean getMIsFinished()
    {
        return mIsFinished;
    }
    
    Pair<Byte, Byte> checkNumber()
    {
        ArrayList<Turn> tmpTurns = getMTurns();
        int lastIndex = tmpTurns.lastIndexOf(tmpTurns);
        Turn lastTurn = tmpTurns.get(lastIndex);
        
        Number tmpNumber = lastTurn.getMNumber();
        
        Byte bulls = tmpNumber.getBulls(tmpNumber);
        Byte cows = tmpNumber.getCows(tmpNumber);
        
        Pair<Byte, Byte> result = new Pair<Byte, Byte>(bulls, cows);
        return result;
    }
    
    public NewGame(String tmp)
    {
        if(tmp.startsWith("f"))
            mIsFinished = true;
        else
            mIsFinished = false;
    }
    
    @Override
    public String toMString()
    {
       String finStr = "";
       if(getMIsFinished() == true)
           finStr = "f";
       finStr += super.toMString();
       return finStr;
    }
}
