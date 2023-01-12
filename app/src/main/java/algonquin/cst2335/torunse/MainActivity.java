package algonquin.cst2335.torunse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override  //This starts the application
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //loads buttons / text on screen
        setContentView(R.layout.activity_main);
                    //R means res
                    //layout is the folder
                    //activity_main is the file
    }


}