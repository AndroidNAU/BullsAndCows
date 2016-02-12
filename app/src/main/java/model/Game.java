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
        Random r = new Random();
        
        int [] tmparr = new int[4];
        
        for (int i = 0; i < 4; i++) 
        {
            if (i == 0)
            {
                tmparr[i] = r.nextInt(9 - 1 + 1) + 1;
            }
            else 
            {
                
                tmparr[i] = r.nextInt(9 - 0 + 1) + 0;
                int j = 0;

                while (j < i) 
                {
                    if (tmparr[i] == tmparr[j])
                    {
                        tmparr[i] = r.nextInt(9 - 0 + 1) + 0;
                        j = 0;
                    }
                    else
                    { 
                        j++;
                    }
                }
            }            
        }
        
        String tmp;
        tmp = Integer.toString(tmparr[0]);
        for(byte i = 1; i < 4; i++)
            tmp += Integer.toString(tmparr[i]);
        
        mSecretNum = new Number(tmp);
    }
    
    public Game(String tmp)
    {
        //"g/****/t/****/*/*t/****/*/*"
        // 1 попытка - 10 символов
        String forSecretNum = tmp.substring(2, 6);
        mSecretNum = new Number(forSecretNum);
        
        String AllTurns = tmp.substring(7);
        //"t/****/*/*t/****/*/*"
        for(int i = 0; i < AllTurns.length(); i+=10)
        {
            String forTurn = AllTurns.substring(i, i+10);
            Turn tmpTurn = new Turn(forTurn);
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
