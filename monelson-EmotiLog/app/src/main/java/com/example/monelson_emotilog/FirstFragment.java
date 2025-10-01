package com.example.monelson_emotilog;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.monelson_emotilog.databinding.FragmentFirstBinding;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirstFragment extends Fragment {
    private ListView lv;
    private ArrayList<String> logged = new ArrayList<>();
    private FragmentFirstBinding binding;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ShareOptions opts = new ViewModelProvider(requireActivity()).get(ShareOptions.class);

        List fromOpts = opts.getOptions().getValue();
        ShareLog log = new ViewModelProvider(requireActivity()).get(ShareLog.class);

        lv = (ListView) view.findViewById(R.id.emotion_list);
//        ArrayList<String> options = new ArrayList<String>();
//        options.add("\uD83D\uDE10");
//        options.add("\uD83D\uDE26");
//        options.add("\uD83D\uDE2C");
//        options.add("\uD83D\uDE27");
//        options.add("\uD83D\uDE28");
//        options.add("\uD83D\uDE2D");

//        opts.setOptions(options);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, new ArrayList<>());

        lv.setAdapter(arrayAdapter);

        opts.getOptions().observe(getViewLifecycleOwner(), newOptions -> {
            arrayAdapter.clear();
            arrayAdapter.addAll(newOptions);
            arrayAdapter.notifyDataSetChanged();
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem = (String) parent.getItemAtPosition(position);
                log.add(new LoggedEmotion(clickedItem, LocalDateTime.now()));
                Toast.makeText(requireContext(), "Logged: " + clickedItem, Toast.LENGTH_SHORT).show();
            }
        });

        binding.changeButton.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment)
        );
        arrayAdapter.notifyDataSetChanged();
        binding.dayButton.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_ThirdFragment)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}