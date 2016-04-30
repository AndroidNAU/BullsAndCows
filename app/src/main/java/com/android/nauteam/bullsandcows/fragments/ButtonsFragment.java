package com.android.nauteam.bullsandcows.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.android.nauteam.bullsandcows.R;
import java.util.ArrayList;

public class ButtonsFragment extends Fragment {
 private Button mButton0;
 private Button mButton1;
 private Button mButton2;
 private Button mButton3;
 private Button mButton4;
 private Button mButton5;
 private Button mButton6;
 private Button mButton7;
 private Button mButton8;
 private Button mButton9;
 private Button mButtonDell;
 private Button mButtonOkay;
 private TextView mTextView1;
 private TextView mTextView2;
 private TextView mTextView3;
 private TextView mTextView4;
 private int mNumberOfDigits = 0;
    private ArrayList <String> mDigitsList;

    private boolean isFourthFilled = false;


    private OnNumberReadyListener mCallback;

    public interface OnNumberReadyListener {
        public void onNumberEntered(String number);
    }


    public static ButtonsFragment newInstance() {
        return new ButtonsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDigitsList = new ArrayList<>();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnNumberReadyListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    private void ButtonsManager(String digit, boolean isDigit){

        for (int i = 0; i < mDigitsList.size(); i++) {
            if (mDigitsList.get(i).equals(digit))
                return;
        }

        if( isDigit && mNumberOfDigits < 4){
            mNumberOfDigits++;
            mDigitsList.add(digit);
        }

        switch (mNumberOfDigits){
            case 1:
                mTextView1.setText(digit);
                break;
            case 2:
                mTextView2.setText(digit);
                break;
            case 3:
                mTextView3.setText(digit);
                break;
            case 4:
                if(isDigit && isFourthFilled ) break;

                mTextView4.setText(digit);

                isFourthFilled = isDigit ? true : false;

                break;
            default:
                break;
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_buttons, container, false);

        //mListView = (ListView) view.findViewById(R.id.listView_turnsList);
        mButton1 = (Button) view.findViewById(R.id.button_one);
        mButton2 = (Button) view.findViewById(R.id.button_two);
        mButton3 = (Button) view.findViewById(R.id.button_three);
        mButton4 = (Button) view.findViewById(R.id.button_four);
        mButton5 = (Button) view.findViewById(R.id.button_five);
        mButton6 = (Button) view.findViewById(R.id.button_six);
        mButton7 = (Button) view.findViewById(R.id.button_seven);
        mButton8 = (Button) view.findViewById(R.id.button_eight);
        mButton9 = (Button) view.findViewById(R.id.button_nine);
        mButton0 = (Button) view.findViewById(R.id.button_zero);
        mButtonDell = (Button) view.findViewById(R.id.button_dell);
        mButtonOkay = (Button) view.findViewById(R.id.button_okay);

        mTextView1 = (TextView) view.findViewById(R.id.textView_digit_one);
        mTextView2 = (TextView) view.findViewById(R.id.textView_digit_two);
        mTextView3 = (TextView) view.findViewById(R.id.textView_digit_three);
        mTextView4 = (TextView) view.findViewById(R.id.textView_digit_four);

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonsManager("1", true);
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { ButtonsManager("2", true);
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonsManager("3", true);
            }
        });
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonsManager("4", true);
            }
        });
        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonsManager("5", true);
            }
        });
        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonsManager("6", true);
            }
        });
        mButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonsManager("7", true);
            }
        });
        mButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonsManager("8", true);
            }
        });
        mButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonsManager("9", true);
            }
        });
        mButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonsManager("0", true);
            }
        });
        mButtonDell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonsManager(" ", false);
                if( mNumberOfDigits > 0 ){
                  mNumberOfDigits--;
                  mDigitsList.remove(mNumberOfDigits);
              }
            }
        });
        mButtonOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFourthFilled) {
                    String number = "";
                    for (int i = 0; i < mDigitsList.size(); i++)
                        number += mDigitsList.get(i);

                    mCallback.onNumberEntered(number);
                    Clear();
                }
            }
        });
        return view;
    }

    private void Clear() {
        mTextView1.setText("");
        mTextView2.setText("");
        mTextView3.setText("");
        mTextView4.setText("");

        mDigitsList.clear();
        mNumberOfDigits = 0;

        isFourthFilled = false;
    }
}
