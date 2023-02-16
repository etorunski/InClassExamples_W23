package algonquin.cst2335.torunse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import algonquin.cst2335.torunse.data.ChatViewModel;
import algonquin.cst2335.torunse.databinding.ActivityMainBinding;
import algonquin.cst2335.torunse.databinding.RowLayout1Binding;
import algonquin.cst2335.torunse.databinding.RowLayoutBinding;

/** This is a page that simulates a login page
 * @author Eric Torunski
 * @version 1.0
 * @since Version 1.0
 */
public class MainActivity extends AppCompatActivity {

    /** This holds the edit text where the user puts their password **/
    private ArrayList<String> messageList ;
    private RecyclerView.Adapter myAdapter ;
    @Override  //This starts the application
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(
                getLayoutInflater());

        ChatViewModel cvm  = new ViewModelProvider(this).get(ChatViewModel.class);
        messageList = cvm.messages;

        /*loads buttons / text on screen */
        setContentView(binding.getRoot());
                    //R means res
                    //layout is the folder
                    //activity_main is the file

        binding.theRecycleView.setAdapter( myAdapter = new RecyclerView.Adapter<MyRowHolder>() {
            @NonNull
            @Override   //which XML layout for this row? row_layout.xml, comes from below
            public MyRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                if(viewType == 0) {
                    //always inflates row_layout.xml
                    RowLayoutBinding binding = RowLayoutBinding.inflate(getLayoutInflater(),
                            parent, false

                    );
                    View root = binding.getRoot();
                    return new MyRowHolder(root);
                }
                else{
                    RowLayout1Binding binding = RowLayout1Binding.inflate(getLayoutInflater(),
                            parent, false

                    );
                    View root = binding.getRoot();
                    return new MyRowHolder(root);
                }
            }

            @Override  //what are the textViews set to for row POSITION?
            public void onBindViewHolder(@NonNull MyRowHolder holder, int position) {
                    String messageOnThisRow = messageList.get(position);//which string goes in this row?


                holder.messageText.setText(messageOnThisRow);

                SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd-MMM-yyyy hh-mm-ss a");
                String currentDateandTime = sdf.format(new Date());
                holder.timeText.setText(currentDateandTime);
            }

            @Override
            public int getItemCount() { //how big is this list
                return messageList.size();
            }

            @Override   //which layout to load at row position
            public int getItemViewType(int position) {
                //you can return anything to represent a layout
                return position % 2;
            }
        });

        binding.theRecycleView.setLayoutManager(new LinearLayoutManager(this));

        binding.sendButton.setOnClickListener( clk ->{
            String txt =  binding.editText.getText().toString();
            messageList.add(txt);

            //redraw the whole list
            myAdapter.notifyItemInserted( messageList.size() - 1 );

            binding.editText.setText(""); //now will be empty

        });
    }

    class MyRowHolder extends RecyclerView.ViewHolder{

        public TextView messageText;
        public TextView timeText;
        public MyRowHolder(@NonNull View itemView) { //itemView will the the root of the layout, ConstraintLayout
            super(itemView);
            messageText = itemView.findViewById(R.id.message);
            timeText = itemView.findViewById(R.id.time);
        }
    }

}