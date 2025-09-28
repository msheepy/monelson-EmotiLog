package com.example.monelson_emotilog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.monelson_emotilog.databinding.FragmentFirstBinding;
import com.example.monelson_emotilog.databinding.FragmentThirdBinding;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ThirdFragment extends DialogFragment {

    private ListView lv;
    private FragmentThirdBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ShareLog log = new ViewModelProvider(requireActivity()).get(ShareLog.class);

       lv = (ListView) view.findViewById(R.id.logged_emotions);

        List<LoggedEmotion> fromLog = log.getLog().getValue();
        ArrayAdapter<String> arrayAdapter = new LoggedEmotionArrayAdapter(getContext(), fromLog);

        lv.setAdapter(arrayAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}