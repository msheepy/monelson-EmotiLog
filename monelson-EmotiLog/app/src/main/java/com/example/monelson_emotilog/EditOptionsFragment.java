package com.example.monelson_emotilog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class EditOptionsFragment extends DialogFragment {
    interface EditOptionsDialogListener {
        void editOptions(String emoticon);
    }

    private EditOptionsDialogListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof EditOptionsDialogListener){
            listener = (EditOptionsDialogListener) context;
        } else {
            throw new RuntimeException(context + "must implement AddCityDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_edit_options, null);
        EditText editEmojiText = view.findViewById(R.id.edit_emoji);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        return builder
                .setView(view)
                .setTitle("Edit an Option")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Edit", (dialog, which) ->{
                    String newEmo = editEmojiText.getText().toString();

                    listener.editOptions(newEmo);
                })
                .create();
    }
}
