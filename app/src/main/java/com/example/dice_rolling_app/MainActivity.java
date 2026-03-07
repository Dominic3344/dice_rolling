package com.example.dice_rolling_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random randomdice = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
        Button roll =(Button) findViewById(R.id.rollDice);
        TextView result =(TextView) findViewById(R.id.Result);
        ImageView imageView= findViewById(R.id.imageView);
        int[] imageiew= {R.drawable.seven,R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six};



        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int ran= dice();

               // String res = String.valueOf(ran);
               // result.setText(res);
               // int index=0;
                imageView.setImageResource(imageiew[ran]);


            }
        });

    }
    int dice(){
        int rand = randomdice.nextInt(1,6);
        return rand;

    }
}