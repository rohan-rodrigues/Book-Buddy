package io.github.charly1811.bookexampledemo;

import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;

import com.google.api.services.books.model.Volume;

import java.util.ArrayList;
import java.util.List;

import io.github.charly1811.bookexampledemo.databinding.ActivityBookMainBinding;

public class MainBookActivity extends AppCompatActivity implements SearchTask.SearchListener {

    private List<Volume> volumeList;
    private ActivityBookMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_book_main);

        SearchFragment searchFragment = (SearchFragment) getSupportFragmentManager().findFragmentByTag("searchFragment");
        if (searchFragment != null) {
            volumeList = searchFragment.getVolumeList();
            binding.searchView.setQuery(searchFragment.getLatestQuery(), false);
        } else {
            volumeList = new ArrayList<>();
            searchFragment = new SearchFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(searchFragment, "searchFragment")
                    .commit();
        }

        RecyclerView recyclerView = binding.booksGrid;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT ? 2 : 3);
        BookListAdapter adapter = new BookListAdapter(volumeList, gridLayoutManager.getSpanCount());

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                SearchFragment searchFragment = (SearchFragment) getSupportFragmentManager().findFragmentByTag("searchFragment");
                if (searchFragment != null) {
                    searchFragment.searchBooks(query);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    @Override
    public void onSearching() {
        volumeList.clear();
        binding.booksGrid.getAdapter().notifyDataSetChanged();
        binding.loadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onResult(List<Volume> volumes) {
        binding.loadingView.setVisibility(View.GONE);
        volumeList.addAll(volumes);
        binding.booksGrid.getAdapter().notifyDataSetChanged();
    }

}
