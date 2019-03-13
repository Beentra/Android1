package com.example.tema11;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class F2A2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_f2_a2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Button btn3 = view.findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFrag3();
            }
        });


        Button btn4 = view.findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                Fragment fragDel = fragmentManager.findFragmentByTag("frag1");
                if (fragDel != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.remove(fragDel);
                    fragmentTransaction.commit();
                    Toast.makeText(getActivity(), "F1A2 deleted", Toast.LENGTH_LONG).show();
                }
        }
        });

        Button btn5 = view.findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopActivity();
            }
        });


    }

    void openFrag3(){
        F3A2 nxt = new F3A2();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragments_container, nxt,"frag3")
                .addToBackStack(null)
                .commit();
    }

    void stopActivity() {
        if (getActivity() == null) {
            return;
        }

        getActivity().finish();
    }

}
