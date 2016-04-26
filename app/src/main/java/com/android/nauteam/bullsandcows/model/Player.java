package com.android.nauteam.bullsandcows.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {

    private static Player instance;

    private String mName;
    private NewGame mCurrentGame;
    private ArrayList<Game> mAllGames;

    private Player() {
        mCurrentGame = null;
        mAllGames = new ArrayList<Game>();
    }

    public static Player getInstance() {
        if (instance == null)
            instance = new Player();

        return instance;
    }

    public void restore(String info) {
        String [] splitedStrArray = info.split("/pg/");

        mName = splitedStrArray[0];

        String [] gamesStr = splitedStrArray[1].split("g/");

        int startWith = 0;
        if (!gamesStr[0].startsWith("f")) {
            mCurrentGame = new NewGame(gamesStr[0]);
            startWith = 1;
        }

        for(int i = startWith; i < gamesStr.length; i++)
            mAllGames.add(new Game(gamesStr[i]));
    }
    
    public String getName() {
        return mName;
    }
    
    public void setName(String usrStr) {
        this.mName = usrStr;
    }

    public NewGame getCurrentGame() {
        return mCurrentGame;
    }
    
    public ArrayList<Game> getAllGames() {
        return mAllGames;
    }
    
    public boolean isGameStarted() {
        return mCurrentGame != null;
    }
    
    public void startNewGame() {
        mCurrentGame = new NewGame();
    }
    
    public void resumeGame(String tmp) {
        mCurrentGame = new NewGame(tmp);
    }
    
    public void addCurrGameToHistory() {
        mAllGames.add(mCurrentGame);
    }

    @Override
    public String toString() {
        // Player is packed in string like this:
        //  USER_NAME/pg/PACKED_GAMEfg/FINISHED_GAME1fg/FINISHED_GAME2...
        String result = getName();
        result += "/p";

        if (mCurrentGame != null)
            result += mCurrentGame.toString();

        for (int i = 0; i < mAllGames.size(); i++)
            result += mAllGames.get(i).toString();

        return result;
    }
}
