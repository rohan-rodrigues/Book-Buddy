package io.github.charly1811.bookexampledemo;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by rohanrodrigues on 10/21/17.
 */

public class TextToBookFrag extends Fragment {
    View rootview;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview =  inflater.inflate(R.layout.text_to_book_frag, container, false);

        Button bookIntent = (Button)rootview.findViewById(R.id.book_intent);
        bookIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), MainBookActivity.class);
                startActivity(i);
            }
        });

        return rootview;
    }
}