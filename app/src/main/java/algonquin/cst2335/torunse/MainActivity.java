package algonquin.cst2335.torunse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import algonquin.cst2335.torunse.data.MainActivityViewModel;
import algonquin.cst2335.torunse.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

private  ActivityMainBinding binding;

    MainActivityViewModel viewModel;
    @Override  //This starts the application
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        binding = ActivityMainBinding.inflate( getLayoutInflater() ); //produces layouts
        //loads buttons / text on screen
        setContentView(  binding.getRoot() ); //load stuff on screen

        viewModel.isSelected.observe(this, newBooleanValue -> {
            binding.mySwitch.setChecked(newBooleanValue);
        });

        binding.theImage.setOnClickListener( imageBtn -> {


        });


        binding.mySwitch.setChecked( viewModel.isSelected.getValue() );
        binding.mySwitch.setOnCheckedChangeListener( (whichButton, isChecked ) -> {

            viewModel.isSelected.postValue( isChecked ); //changes the bool, and notifies observers


            Toast
                    .makeText(MainActivity.this, "the boolean is now:" +isChecked, Toast.LENGTH_SHORT)
                    .show();


        } );

/*
    binding.editText.setText( viewModel.editTextContents );
    binding.textHelloWorld.setText(viewModel.editTextContents);
    binding.button.setText( viewModel.editTextContents  );
*/



        binding.button.setOnClickListener(v -> {
            viewModel.editTextContents.postValue( "You clicked the button" );

            binding.editText.setText( viewModel.editTextContents.getValue() );
            binding.textHelloWorld.setText(viewModel.editTextContents.getValue());
            binding.button.setText( viewModel.editTextContents.getValue()  );
        });

    }
}