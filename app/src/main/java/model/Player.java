/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Maxim
 */
public class Player {
    private String mName;
    private NewGame mCurrentGame;
    private ArrayList<Game> mAllGames;
    
    public String getMName()
    {
        return mName;
    }
    
    public void setMName(String usrStr)
    {
        this.mName = usrStr;
    }
    
    ArrayList<Game> getMAllGames()
    {
        return mAllGames;
    }
    
    public boolean isGameStarted()
    {
        if(mCurrentGame.getMIsFinished() == false)
            return true;
        else
            return false;
    }
    
    public void startNewGame()
    {
        mCurrentGame = new NewGame();
    }
    
    public void resumeGame(String tmp)
    {
        mCurrentGame = new NewGame(tmp);
    }
    
    public void addCurrentToHistory()
    {
        mAllGames.add(mCurrentGame);
    }
    
    public String toMString()
    {
        String result = getMName();
        result += mCurrentGame.toMString();
        return result;
    }
}
