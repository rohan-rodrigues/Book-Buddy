package io.github.charly1811.bookexampledemo;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.model.Volume;
import com.google.common.primitives.Ints;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by cloubao on 1/20/16.
 */
public class SearchTask extends AsyncTask<String, Void, List<Volume>> {

    private SearchListener searchListener;

    public void setSearchListener(SearchListener searchListener) {
        this.searchListener = searchListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        searchListener.onSearching();
    }

    @Override
    protected List<Volume> doInBackground(String... params) {

        String query = params[0];

        // If the query seems to be an ISBN we add the isbn special keyword https://developers.google.com/books/docs/v1/using#PerformingSearch
        if (Ints.tryParse(query) != null && (query.length() == 13 || query.length() == 10)) {
            query = query.concat("+isbn:" + query);
        }

        // Creates the books api client
        Books books = new Books.Builder(AndroidHttp.newCompatibleTransport(), AndroidJsonFactory.getDefaultInstance(), null)
                .setApplicationName(BuildConfig.APPLICATION_ID)
                .build();

        try {
            // Executes the query
            Books.Volumes.List list = books.volumes().list(query).setProjection("LITE");
            return list.execute().getItems();
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    protected void onPostExecute(List<Volume> volumes) {
        super.onPostExecute(volumes);
        searchListener.onResult(volumes == null ? Collections.<Volume>emptyList() : volumes);
    }

    public interface SearchListener {
        void onSearching();

        void onResult(List<Volume> volumes);
    }

}
