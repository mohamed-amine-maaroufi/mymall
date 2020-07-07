package com.example.mymall;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyAccountFragment extends Fragment {

    public MyAccountFragment() {
        // Required empty public constructor
    }
    private Button viewAllAddressBtn;
    public static final int MANAGE_ADDRESS=1;
    private CircleImageView profileView;
    private TextView name,email;
    private LinearLayout layoutContainer;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_account, container, false);

        layoutContainer = view.findViewById(R.id.layout_container);



        viewAllAddressBtn=view.findViewById(R.id.view_all_addresses_btn);
        viewAllAddressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myAddressesIntent=new Intent(getContext(),MyAddressesActivity.class);
                myAddressesIntent.putExtra("MODE",MANAGE_ADDRESS);
                startActivity(myAddressesIntent);
            }
        });

        return view;
    }

}
