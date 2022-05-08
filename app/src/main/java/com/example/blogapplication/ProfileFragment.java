package com.example.blogapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class ProfileFragment extends Fragment {

    View view;

    public ProfileFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_profile, container, false);

        TextView name=(TextView) view.findViewById(R.id.nameText);
        TextView fullname=(TextView) view.findViewById(R.id.name);
        TextView email=(TextView) view.findViewById(R.id.emailId);

        SharedPreferences sharedPreferences= getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String emailId=sharedPreferences.getString("email","defaultValue");
        Log.i("shared ",emailId);
        String fullname1=sharedPreferences.getString("fullname","defaultValue");
        Log.i("shared ",fullname1);
        fullname.setText(fullname1);
        name.setText(fullname1);
        email.setText(emailId);
        Button logout=(Button) view.findViewById(R.id.signout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FirebaseAuth auth=FirebaseAuth.getInstance();
                FirebaseAuth.getInstance().signOut();
                Intent i=new Intent(getActivity(),MainActivity.class);
                startActivity(i);
            }
        });
   return view;
    }
}