package io.github.charly1811.bookexampledemo;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rohanrodrigues on 10/21/17.
 */

public class HomeFrag extends Fragment {
    View rootview;
    private RecyclerView recyclerView;
    private HomeDashboardAdapter adapter;
    private List<Option> mOptionList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview =  inflater.inflate(R.layout.home_frag, container, false);

        recyclerView = (RecyclerView) rootview.findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new HomeFrag.GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mOptionList = new ArrayList<>();
        adapter = new HomeDashboardAdapter(getContext(), mOptionList);
        prepareOptions();
        recyclerView.setAdapter(adapter);

        final Button b = adapter.getBeginButton();
       /* if (b != null) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    switch (b.getText().toString()) {
                        case ("Enter Text Now"):
                            OcrFrag ocrFragment = new OcrFrag();
                            ft.replace(R.id.maincontent, ocrFragment).commit();
                            return;
                        case ("b"):
                            AchievementsFragment achievementsFragment = new AchievementsFragment();
                            ft.replace(R.id.maincontent, achievementsFragment).commit();
                    }


                }
            });
        } */


        return rootview;
    }


    private void prepareOptions() {
        int[] covers = new int[]{
                R.drawable.bookspecialty,
                R.drawable.ocrimage,
                R.drawable.achievements};

        Option a = new Option("Text-To-Book Name","Enter Text Now",  covers[0]);
        mOptionList.add(a);

        a = new Option("OCR", "Try Scanning Now", covers[1]);
        mOptionList.add(a);

        a = new Option("Reading Achievements", "See Your Progress", covers[2]);
        mOptionList.add(a);

        adapter.notifyDataSetChanged();
    }

    private ImageView[] getOptionCovers(ArrayList<Item> arrayList) {
        ImageView[] arr = new ImageView[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            arr[i] = arrayList.get(i).getImageView();
        }
        return arr;
    }


    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}