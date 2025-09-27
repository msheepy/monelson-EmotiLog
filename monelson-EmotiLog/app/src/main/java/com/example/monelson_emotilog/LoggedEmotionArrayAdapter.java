package com.example.monelson_emotilog;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class LoggedEmotionArrayAdapter extends ArrayAdapter {

    public LoggedEmotionArrayAdapter(@NonNull Context context, List<LoggedEmotion> emotions) {
        super(context, android.R.layout.simple_list_item_1, emotions);
    }
}
