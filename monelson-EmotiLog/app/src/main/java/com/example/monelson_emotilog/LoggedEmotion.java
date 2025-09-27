package com.example.monelson_emotilog;

import java.time.LocalDateTime;

public class LoggedEmotion {
    private String emoji;
    private LocalDateTime time;

    public LoggedEmotion(String emoji, LocalDateTime time){
        this.time = time;
        this.emoji = emoji;
    }

    @Override
    public String toString() {
        String strTime = time.toString();
        String modTime = strTime.replace('T', ' ');
        String cutTime = modTime.substring(0, modTime.length() - 7);
        return "At : " + cutTime + " you felt : " + emoji;
    }
}
