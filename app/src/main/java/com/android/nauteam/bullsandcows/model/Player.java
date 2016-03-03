package com.android.nauteam.bullsandcows.model;

import java.util.ArrayList;

public class Player {

    private String mName;
    private NewGame mCurrentGame;
    private ArrayList<Game> mAllGames;

    public Player() {
        mName = new String();
        mCurrentGame = null;
        mAllGames = new ArrayList<Game>();
    }

    public Player(String info) {
        String [] splitedStrArray = info.split("/p");

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
