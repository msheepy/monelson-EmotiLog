package com.example.monelson_emotilog;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.monelson_emotilog.databinding.FragmentSecondBinding;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SecondFragment extends Fragment implements EditOptionsFragment.EditOptionsDialogListener {
    private FragmentSecondBinding binding;
    private ListView lv;
    private int curCityInd;

    ArrayAdapter arrayAdapter;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ShareOptions opts = new ViewModelProvider(requireActivity()).get(ShareOptions.class);
        List fromOpts = opts.getOptions().getValue();

        lv = (ListView) view.findViewById(R.id.emotion_options_list);

        arrayAdapter = new ArrayAdapter(requireContext(), 0, fromOpts);

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem = (String) parent.getItemAtPosition(position);
                curCityInd = position;
                new EditOptionsFragment().show(getParentFragmentManager(), "Edit options");
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void editOptions(String emoticon) {
        //String toBeModified = (String)arrayAdapter.getItem(curCityInd);

        ShareOptions opts = new ViewModelProvider(requireActivity()).get(ShareOptions.class);
        ArrayList<String> fromOpts = opts.getOptions().getValue();
        assert fromOpts != null;
        fromOpts.set(curCityInd, emoticon);
        opts.setOptions(fromOpts);
        arrayAdapter.notifyDataSetChanged();
    }
}