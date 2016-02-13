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
        
        int [] tmpArr = new int[4];
        /*
            Here we have to generate mSecretNum.
            For that we use Array of integer numbers.
            But the first element of this array must not be equel to zero.
            It means that boundaries for the first element should be from 1 to 9.
            Also boundaries for other elements should be from 0 to 9.
            And all other elements must not be equals to each other.
            For make boundaries of random generation we use this formula:
                nextInt(max - min + 1) + min
        */        
        for (int i = 0; i < 4; i++) 
        {
            //Generate the first element 
            if (i == 0)
            {
                final int max = 9;
                final int min = 1;
                tmpArr[i] = r.nextInt(max - min + 1) + min;
            }
            //Generate other elements 
            else 
            {
                final int max = 9;
                final int min = 0;
                tmpArr[i] = r.nextInt(max - min + 1) + min;
                
                //If elements are equals we should generate them one more time
                int j = 0;
                while (j < i) 
                {
                    if (tmpArr[i] == tmpArr[j])
                    {
                        tmpArr[i] = r.nextInt(max - min + 1) + min;
                        j = 0;
                    }
                    else
                    { 
                        j++;
                    }
                }
            }            
        }
        
        String tmp = Integer.toString(tmpArr[0]);
        for(byte i = 1; i < 4; i++)
            tmp += Integer.toString(tmpArr[i]);
        
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
