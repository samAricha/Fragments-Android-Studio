package com.teka.fragmentsintro;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment2 extends Fragment {
    Fragment2Listener fragment2Listener;
    private EditText editTxt;
    private Button confirmBtn;

    //interface for communicating with the MainActivity
    //this interface is going to be implemented in the MainActivity
    public interface Fragment2Listener{
        void onInput2Sent(CharSequence input);//CharSequence is used because it is more broader
        //but you can use any variable type i.e String, int etc
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //inflating the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        //initiliazing our variables
        editTxt = view.findViewById(R.id.edit_txt);
        confirmBtn = view.findViewById(R.id.confirm_btn);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence input = editTxt.getText();
                fragment2Listener.onInput2Sent(input);//any activity that implements this method will receive the
                //input value once button is clicked.
            }
        });

        return view;
    }

    public void updateEditText(CharSequence newText){
        editTxt.setText(newText);
    }



    //this method is used in order to initialize the Fragment1Listener because
    //although it is used in the on Click it is only declared not initialized
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Fragment1.Fragment1Listener){//checking if the activity has implementd the Fragment1Listener
            fragment2Listener = (Fragment2.Fragment2Listener) context;//initializing the fragment 1 listener
        }else{
            throw new RuntimeException(context.toString() + "must implement Fragment1Listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragment2Listener = null;//setting the listener to null when fragment is detatched from activity
    }
}