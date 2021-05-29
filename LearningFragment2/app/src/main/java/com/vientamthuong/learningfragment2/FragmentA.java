package com.vientamthuong.learningfragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {

    private TextView textView;
    private EditText editText;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        textView = view.findViewById(R.id.textViewFragmentA);
        editText = view.findViewById(R.id.editTextFragmentA);
        button = view.findViewById(R.id.buttonFragmentA);
        button.setOnClickListener(v -> {
            TextView textView = getActivity().findViewById(R.id.textViewMain);
            textView.setText(editText.getText().toString());
        });
        Bundle bundle = getArguments();
        textView.setText(bundle.getString("name"));
        return view;
    }

    public void changeText(String dsfSsdfsdf) {
        textView.setText(dsfSsdfsdf);
    }
}
