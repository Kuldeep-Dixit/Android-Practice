package com.example.whatsappclone;

import static android.R.layout.simple_list_item_1;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ChatFragment extends Fragment {

    String[] arr  = {"One","two" ,"Three","four","five","six","seven","eight","nine","ten","One","two" ,"Three","four","five","six","seven","eight","nine","ten"};

    public ChatFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        ListView listOfItems= view.findViewById(R.id.listOfItems);
        ArrayAdapter listV = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1,arr);
        listOfItems.setAdapter(listV);

        return view;
    }

}