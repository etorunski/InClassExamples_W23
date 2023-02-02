package algonquin.cst2335.torunse;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import algonquin.cst2335.torunse.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //ActivitySecondBinding

        ActivitySecondBinding binding = ActivitySecondBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot()); //+Binding


        binding.secondPageButton.setOnClickListener( clk -> {
            //go back:

            //send data to first page:
            Intent dataTable = new Intent();// no directions from/to


            finish(); //returns onpause(), onStop()

        });



        ActivityResultLauncher<Intent> cameraResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override //the camera has disappeared
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData(); // our picture is in here

                            Bitmap thumbnail = data.getParcelableExtra("data");

                            FileOutputStream fOut = null;

                            File file = new File( getFilesDir(), "Picture.png");

                            if(file.exists())
                            {
int i = 0;
                            }

                            try {
                                fOut = openFileOutput("Picture.png", Context.MODE_PRIVATE);

                                thumbnail.compress(Bitmap.CompressFormat.PNG, 100, fOut);

                                fOut.flush();

                                fOut.close();

                            }
                            catch(IOException ioe) {}

                            int i = 0;
                        }
                    }
                }
               );
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        binding.prebuiltIntent.setOnClickListener( click -> {
            //use apps on the phone
            cameraResult.launch(cameraIntent);
            //should return a picture
        });


    }
}