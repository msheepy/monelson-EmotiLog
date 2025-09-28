package com.example.monelson_emotilog;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShareOptions extends ViewModel {
    private final MutableLiveData<ArrayList<String>> options = new MutableLiveData<>(new ArrayList<String>(Arrays.asList("\uD83D\uDE10", "\uD83D\uDE26", "\uD83D\uDE2C", "\uD83D\uDE27", "\uD83D\uDE28", "\uD83D\uDE2D")));

    public LiveData<ArrayList<String>> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> newOptions) {
        options.setValue(newOptions);
    }

    public void add(String newElem){
        ArrayList<String> currentList = options.getValue();
        currentList.add(newElem);
        options.setValue(currentList);
    }
}
