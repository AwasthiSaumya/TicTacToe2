package com.example.saumyaawasthi.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //circle:1, cross:2
    //1st
    //2nd
    //3rd
    
        int player = 1, f = 0;
        int arr[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        ImageView img;

    public void tap(View view)
    {
            img = (ImageView) view;
            Button button = findViewById(R.id.button);
            int tag = Integer.parseInt(img.getTag().toString());
        //
            if (f == 0) {
                if (arr[tag - 1] == 0) {
                    img.setTranslationY(-3500);
                    img.animate().translationYBy(3500).rotation(1800);

                    if (player == 1) {
                        img.setImageResource(R.drawable.circle);
                        arr[tag - 1] = 1;
                        player = 2;
                    } else {
                        img.setImageResource(R.drawable.cross);
                        arr[tag - 1] = 2;
                        player = 1;
                    }
                    int i;
                    for (i = 0; i <= 6; i += 3) {
                        if ((arr[i] == arr[i + 1] && arr[i] == arr[i + 2]) && arr[i] != 0)
                            f = 1;
                    }

                    for (i = 0; i < 3; i++) {
                        if ((arr[i] == arr[i + 3] && arr[i] == arr[i + 6]) && arr[i] != 0)
                            f = 1;
                    }
                }
                if (((arr[0] == arr[4] && arr[0] == arr[8]) && arr[0] != 0) || (arr[2] == arr[4] && arr[2] == arr[6]) && arr[2] != 0)
                    f = 1;
            }
            if (f == 1) {
                if (player == 2) {
                    Toast.makeText(this, "Player 1 is winner", Toast.LENGTH_SHORT).show();
                    button.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(this, "Player 2 is winner", Toast.LENGTH_SHORT).show();
                    button.setVisibility(View.VISIBLE);
                }
            }
            int Draw = 0;
            for (int i = 0; i < 9; i++) {
                if (arr[i] == 0)
                    Draw = 1;
            }
            if (Draw == 0 && f != 1) {
                Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
                button.setVisibility(View.VISIBLE);
            }

    }


    public void play(View view) {
        GridLayout gridLayout = (GridLayout) findViewById(R.id.grid);
        for (int i = 0; i < 9; i++) {
            ImageView img = (ImageView) gridLayout.getChildAt(i);
            img.setImageDrawable(null);
        }
        Button button = findViewById(R.id.button);
        button.setVisibility(View.INVISIBLE);
        f = 0;
        for (int i = 0; i < 9; i++)
            arr[i] = 0;
        player = 1;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setVisibility(View.INVISIBLE);
    }


}
