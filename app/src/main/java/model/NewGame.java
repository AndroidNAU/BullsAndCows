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
    private Turn mCurrentTurn;
    
    public void setMIsfinished(boolean tmp)
    {
        mIsFinished = tmp;
    }
    
    public boolean getMIsFinished()
    {
        return mIsFinished;
    }
    
    Pair<Byte, Byte> checkNumber()
    {
        Number tmpNumber = mCurrentTurn.getMNumber();
        
        Byte bulls = tmpNumber.getBulls(tmpNumber);
        Byte cows = tmpNumber.getCows(tmpNumber);
        
        if(bulls == 4)
            setMIsfinished(true);
        
        Pair<Byte, Byte> result = new Pair<Byte, Byte>(bulls, cows);
        return result;
    }
    
    public NewGame(String tmp)
    {
        super(tmp);
        if(tmp.startsWith("f"))
            setMIsfinished(true);
        else
            setMIsfinished(false);
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
