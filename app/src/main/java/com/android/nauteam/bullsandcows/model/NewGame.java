package com.android.nauteam.bullsandcows.model;

import android.util.Pair;

import java.io.Serializable;

public class NewGame extends Game implements Serializable {

    private boolean mIsFinished;
    private Turn mCurrentTurn;

    public NewGame() {
        mIsFinished = false;
        mCurrentTurn = null;
    }

    public NewGame(String tmp) {
        super(tmp);
        if(tmp.startsWith("f"))
            setIsFinished(true);
        else
            setIsFinished(false);
    }

    public void setIsFinished(boolean tmp) {
        mIsFinished = tmp;
    }
    
    public boolean getIsFinished() {
        return mIsFinished;
    }

    public Turn getCurrentTurn() {
        return mCurrentTurn;
    }

    public Turn createNewTurn(Number num) {
        return new Turn(num);
    }
    
    Pair<Byte, Byte> checkNumber() {
        assert(mCurrentTurn != null);

        Number currNum = mCurrentTurn.getNumber();

        Byte bulls = currNum.getBulls(currNum);
        Byte cows = currNum.getCows(currNum);

        if (bulls == 4)
            setIsFinished(true);

        return new Pair<Byte, Byte>(bulls, cows);
    }
    
    @Override
    public String toString()  {
       String finStr = "";
       if(getIsFinished())
           finStr = "f";

        finStr += super.toString();

       return finStr;
    }
}
