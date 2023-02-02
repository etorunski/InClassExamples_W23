package algonquin.cst2335.torunse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import algonquin.cst2335.torunse.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";
    @Override  //1 )  This starts the application
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());


        //loads buttons / text on screen
        setContentView(binding.getRoot());
                    //R means res
                    //layout is the folder
                    //activity_main is the file

        SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= prefs.edit();
        String found = prefs.getString("Name", "missing data");

        found = prefs.getString("FGHEUIGFHEU", "feuigfheui");
        editor.putString("Name", "d;fghmjl'kdsnfmhlkdstoilk");

        editor.apply();


        binding.button.setOnClickListener( btn -> {
                                    //1) Where you are, 2) Which activity do you want next



            Intent intent = new Intent( MainActivity.this , SecondActivity.class  );
            String whatWasTyped = binding.editText.getText().toString();
            //pass some data:
            intent.putExtra("Name", whatWasTyped);
            intent.putExtra("Age", 30);

            //actually makes the transition, send the table to SecondActivity
            startActivity( intent );
        }  );

    }

    @Override  // 2)   Activity is now visible
    protected void onStart() {
        super.onStart();

        Log.w(TAG, "Now visible");
        //Your code here
    }

    @Override //  3)  Now responds to touch input
    protected void onResume() {
        super.onResume();


        Log.e(TAG , "Now listens for touch");
    }

    @Override //no longer listening to touches
    protected void onPause() {
        super.onPause();
    }

    @Override  // no longer visible
    protected void onStop() {
        super.onStop();
    }

    @Override  // memory is garbage collected
    protected void onDestroy() {
        super.onDestroy();
    }
}