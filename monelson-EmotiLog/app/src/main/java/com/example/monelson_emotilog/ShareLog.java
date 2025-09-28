package com.example.monelson_emotilog;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ShareLog extends ViewModel {
    LoggedEmotion initLog = new LoggedEmotion("Nothing has been logged yet", LocalDateTime.now());
    private final MutableLiveData<ArrayList<LoggedEmotion>> log = new MutableLiveData<>(new ArrayList<LoggedEmotion>(Arrays.asList(initLog)));

        public LiveData<ArrayList<LoggedEmotion>> getLog() {
            return log;
        }

        public void setLog(ArrayList<LoggedEmotion> newLog) {
            log.setValue(newLog);
        }

        public void add(LoggedEmotion newElem){
            ArrayList<LoggedEmotion> currentList = log.getValue();
            currentList.add(newElem);
            log.setValue(currentList);
        }

}
