package io.github.charly1811.bookexampledemo;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by rohanrodrigues on 6/22/17.
 */

public class AchievementsFragment extends Fragment {

    public static AchievementsFragment newInstance() {
        return new AchievementsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_achievements, container, false);

        GridView gridview = (GridView) rootview.findViewById(R.id.gridview);
        gridview.setAdapter(new AchievementsAdapter(getContext()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        Toast.makeText(getContext(), "Opened First Tutorial",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getContext(), "Completed First Tutorial",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getContext(), "Completed 3 Tutorials",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getContext(), "Completed 5 Tutorials",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getContext(), "Completed Javascript",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(getContext(), "Completed Java",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(getContext(), "Completed Android",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        Toast.makeText(getContext(), "Completed HTML",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        Toast.makeText(getContext(), "Completed CSS",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        Toast.makeText(getContext(), "Completed HTML, CSS, and Javascript",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 10:
                        Toast.makeText(getContext(), "Opened First Test",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 11:
                        Toast.makeText(getContext(), "Aced First Test",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 12:
                        Toast.makeText(getContext(), "Received Above 60% On First Test",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 13:
                        Toast.makeText(getContext(), "Received Above 80% On 3 Tests",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 14:
                        Toast.makeText(getContext(), "Received Above 80% On 5 Tests",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        return rootview;
    }
}
