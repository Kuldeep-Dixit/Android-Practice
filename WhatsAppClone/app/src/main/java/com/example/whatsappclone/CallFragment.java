package com.example.whatsappclone;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CallFragment extends Fragment {

    String[] arr  = {"One","two" ,"Three","four","five","six","seven","eight","nine","ten","One","two" ,"Three","four","five","six","seven","eight","nine","ten"};

    public CallFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_call, container, false);
        ListView listOfItems= view.findViewById(R.id.listOfItems);
        ArrayAdapter listV = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1,arr);
        listOfItems.setAdapter(listV);
        return view;
    }
}