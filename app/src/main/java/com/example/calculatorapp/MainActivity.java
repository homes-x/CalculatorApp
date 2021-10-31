package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView display_text;
    Button zero, one, two, three, four, five, six, seven, eight, nine,
            decimal, equal, add, subtract, multiply, divide;

    float mValueOne, mValueTwo;

    boolean mAddition, mSubtraction, mMultiplication, mDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display_text = findViewById(R.id.display_text);
        ImageButton backspace = findViewById(R.id.backspace);
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        decimal = findViewById(R.id.decimal);
        equal = findViewById(R.id.equal_sign);

        add = findViewById(R.id.addition);
        subtract = findViewById(R.id.subtraction);
        multiply = findViewById(R.id.multiplication);
        divide = findViewById(R.id.division);


        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDisplayText(addDisplayText("0"));
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDisplayText(addDisplayText("1"));
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDisplayText(addDisplayText("2"));
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDisplayText(addDisplayText("3"));
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDisplayText(addDisplayText("4"));
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDisplayText(addDisplayText("5"));
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDisplayText(addDisplayText("6"));
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDisplayText(addDisplayText("7"));
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDisplayText(addDisplayText("8"));
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDisplayText(addDisplayText("9"));
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = display_text.getText().toString();
                if (str.contains(".") == false) {
                    setDisplayText(addDisplayText("."));
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (display_text == null) {
                    display_text.setText("");
                } else {
                     mValueOne = Float.parseFloat(display_text.getText() + "");
                     mAddition = true;
                     display_text.setText(null);
                }
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (display_text == null) {
                    display_text.setText("");
                } else {
                    mValueOne = Float.parseFloat(display_text.getText() + "");
                    mSubtraction = true;
                    setDisplayText(null);
                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (display_text == null) {
                    display_text.setText("");
                } else {
                    mValueOne = Float.parseFloat(display_text.getText() + "");
                    mMultiplication = true;
                    setDisplayText(null);
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (display_text == null) {
                    setDisplayText("");
                } else {
                    mValueOne = Float.parseFloat(display_text.getText() + "");
                    mDivision = true;
                    setDisplayText(null);
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mValueTwo = Float.parseFloat(display_text.getText() + "");

                if (mAddition == true) {
                    setDisplayText(removeTrailingZeros(mValueOne + mValueTwo + ""));
                    mAddition = false;
                }

                if (mSubtraction == true) {
                    setDisplayText(removeTrailingZeros(mValueOne - mValueTwo + ""));
                    mSubtraction = false;
                }

                if (mMultiplication == true) {
                    setDisplayText(removeTrailingZeros(mValueOne * mValueTwo + ""));
                    mMultiplication = false;
                }

                if (mDivision == true) {
                    setDisplayText(removeTrailingZeros(mValueOne / mValueTwo + ""));
                    mDivision = false;
                }
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = display_text.getText().toString();
                if (str.length() > 1) {
                    display_text.setText(str.substring(0, display_text.length() - 1));
                } else if (str.length() <= 1) {
                    display_text.setText("");
                }

            }
        });

        backspace.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                display_text.setText("");
                return true;
            }
        });
    }

    private void setDisplayText(String text) {
        display_text.setText(text);
    }

    private String addDisplayText(String text) {
        return display_text.getText() + text;
    }

    private String removeTrailingZeros(String text) {
        return new DecimalFormat("0.#####").format(Double.valueOf(text));
    }
}