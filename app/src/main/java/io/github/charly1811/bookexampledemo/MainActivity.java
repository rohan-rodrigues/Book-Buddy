package io.github.charly1811.bookexampledemo;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

   /* private RecyclerView recyclerView;
    private HomeDashboardAdapter adapter;
    private List<Option> mOptionList; */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        HomeFrag homeFrag = new HomeFrag();
        ft.replace(R.id.maincontent, homeFrag).commit();

      /*  recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mOptionList = new ArrayList<>();
        adapter = new HomeDashboardAdapter(this, mOptionList);
        prepareOptions();
        recyclerView.setAdapter(adapter);

        final Button b = adapter.getBeginButton();
        System.out.print("ASDASD");
        if (b != null) {
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
                            OcrFrag ocrFragment2 = new OcrFrag();
                            ft.replace(R.id.maincontent, ocrFragment2).commit();
                    }


                }
            });
        } */
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
     /*   if (id == R.id.action_settings) {
            return true;
        } */

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        if (id == R.id.nav_home) {
            HomeFrag homeFrag = new HomeFrag();
            ft.replace(R.id.maincontent, homeFrag);
        } else if (id == R.id.nav_text) {
            TextToBookFrag textToBookFrag = new TextToBookFrag();
            ft.replace(R.id.maincontent, textToBookFrag);
        } else if (id == R.id.nav_ocr) {
            OcrFrag ocrFragment = new OcrFrag();
            ft.replace(R.id.maincontent, ocrFragment);
        } else if (id == R.id.nav_speech) {
            AchievementsFragment achievementsFragment = new AchievementsFragment();
            ft.replace(R.id.maincontent, achievementsFragment);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        ft.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
