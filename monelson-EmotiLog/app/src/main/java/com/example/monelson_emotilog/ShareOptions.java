// Dear machine gods, please hear my plea: please let my code work well, without errors, and producing the output I wish. I beg of you.

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

    public ShareOptions() {
        // Initialize only once
        if (options.getValue() == null) {
            ArrayList<String> initial = new ArrayList<>();
            initial.add("\uD83D\uDE10");
            initial.add("\uD83D\uDE26");
            initial.add("\uD83D\uDE2C");
            initial.add("\uD83D\uDE27");
            initial.add("\uD83D\uDE28");
            initial.add("\uD83D\uDE2D");
            options.setValue(initial);
        }
    }
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
