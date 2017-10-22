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

public class OcrFrag extends Fragment {
    View rootview;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview =  inflater.inflate(R.layout.ocr_frag, container, false);

        Button b = (Button)rootview.findViewById(R.id.itemPicSelector);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), CameraMainActivity.class);
                startActivity(i);
            }
        });

        return rootview;
    }
}