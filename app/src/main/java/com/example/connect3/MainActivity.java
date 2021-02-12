package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    private TextView sc1 = (TextView) findViewById(R.id.sc1);
//    private TextView sc2 = (TextView) findViewById(R.id.sc2);
    int activePlayer=0;
    int[][] winState = {{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    public void dropIn(View view){
        Button btn = (Button) findViewById(R.id.p_Again);
        TextView sc1 = (TextView) findViewById(R.id.sc1);
        TextView sc2 = (TextView) findViewById(R.id.sc2);
        ImageView tok = (ImageView) view;
        tok.setTranslationY(-1500);
        Log.i("info",tok.getTag().toString());
        int tapped = Integer.parseInt(tok.getTag().toString());
        gameState[tapped] = activePlayer;
        if(activePlayer==0){
            tok.setImageResource(R.drawable.yellow);
            activePlayer=1;
        }
        else{
            tok.setImageResource(R.drawable.red);
            activePlayer=0;
        }
        int cnt1 =0;
        int cnt2=0;
        for(int[] win:winState){
            if(gameState[win[0]]==gameState[win[1]]&&gameState[win[1]]==gameState[win[2]]&&gameState[win[0]]!=2){
                if(activePlayer==1){
                    cnt1=cnt1+1;
                    sc1.setText(String.valueOf(cnt1));
                    Toast.makeText(this,"Player One has Won",Toast.LENGTH_SHORT).show();
                }
                else{
                    cnt2=cnt2+1;
                    sc2.setText(String.valueOf(cnt2));
                    Toast.makeText(this,"Player Two has Won",Toast.LENGTH_SHORT).show();
                }
            }
        }
        tok.animate().translationYBy(1500).setDuration(300);
    }
    public void again(View view){
        Button playAgain = (Button) findViewById(R.id.p_Again);
        GridLayout gameLayout = (GridLayout) findViewById(R.id.gameLayout);
        for(int i=0;i<gameLayout.getChildCount();i++){
            ImageView layout = (ImageView) gameLayout.getChildAt(i);
            layout.setImageDrawable(null);
        }
        for(int j =0;j<gameState.length;j++){
            gameState[j] = 2;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}