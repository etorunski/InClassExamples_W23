package algonquin.cst2335.torunse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/** This is a page that simulates a login page
 * @author Eric Torunski
 * @version 1.0
 * @since Version 1.0
 */
public class MainActivity extends AppCompatActivity {


    /** This holds the edit text where the user puts their password **/
    private EditText thePasswordText;

    @Override  //This starts the application
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*loads buttons / text on screen */
        setContentView(R.layout.activity_main);
                    //R means res
                    //layout is the folder
                    //activity_main is the file

       thePasswordText = findViewById(R.id.editText);
       Button btn = findViewById(R.id.button);

       btn.setOnClickListener( clk -> {
            String password = thePasswordText.getText().toString();

            //looking for Uppercase, lowercase, numbber, and special character

           if(verifyPassword(password))
           {
               //password has an uppercase character
               Toast.makeText(this, "I found an upper case!", Toast.LENGTH_SHORT).show();
           }

       });
    }

    /** This function scans the string to see if it is complex enough
     *
     * @param pw The string to verify
     * @return True if pw has uppercase, otherwise false
     */
   public boolean verifyPassword(String pw){
        boolean isComplexEnough = false;

        for(int i = 0; i < pw.length(); i++)
        {
            char c = pw.charAt(i);

            if(Character.isUpperCase(c))
                isComplexEnough = true;
        }
        return isComplexEnough;
    }



}