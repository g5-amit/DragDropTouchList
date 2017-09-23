package com.example.amitgupta10.dragdroptouchlist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.DragEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Movie> movieList = null;
    private Context mContext = null;
    private DragNDropSimpleAdapter mAdapter = null;
    private DragNDropListView mListView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        mListView = (DragNDropListView)findViewById(R.id.list);

        movieList = (ArrayList)getMovies();
        mAdapter = new DragNDropSimpleAdapter(mContext, movieList, R.id.handler);

        mListView.setAdapter(mAdapter);
//
//        list.setOnItemDragNDropListener(adapter);

        mListView.setDropListener(mDropListener);
        mListView.setRemoveListener(mRemoveListener);

    }

    private DragNDropListView.DropListener mDropListener =
            new DragNDropListView.DropListener() {
                public void drop(int from, int to) {
//                    Collections.swap(arr, from, to);
                    if(from < to) {
                        Movie fromMovie = movieList.get(from);
                        movieList.remove(from);
                        movieList.add(to,fromMovie);
                    } else {
                        Movie toMovie = movieList.get(to);
                        movieList.remove(to);
                        movieList.add(from,toMovie);
                    }
                    mAdapter.notifyDataSetChanged();
//                    list.invalidateViews();
                }
            };

    private DragNDropListView.RemoveListener mRemoveListener =
            new DragNDropListView.RemoveListener() {
                public void remove(int which) {
                    removeListItem(which);
                }
            };

    private void removeListItem (int which) {
        View v = mListView.getChildAt(which - mListView.getFirstVisiblePosition());
        if (v == null) {
            return;
        }

//        v.setVisibility(View.GONE);
//        mListView.invalidateViews();
        movieList.remove(which);
        mAdapter.notifyDataSetChanged();

//        v.setVisibility(View.VISIBLE);
//        mListView.invalidateViews();
    }

    private List<Movie> getMovies(){
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Harry Potter"));
        movieList.add(new Movie("Twilight"));
        movieList.add(new Movie("Star Wars"));
        movieList.add(new Movie("Star Trek"));
        movieList.add(new Movie("Galaxy Quest"));
        movieList.add(new Movie("Harry Potter1"));
        movieList.add(new Movie("Twilight1"));
        movieList.add(new Movie("Star Wars1"));
        movieList.add(new Movie("Star Trek1"));
        movieList.add(new Movie("Galaxy Quest1"));
        movieList.add(new Movie("Harry Potter2"));
        movieList.add(new Movie("Twilight2"));
        movieList.add(new Movie("Star Wars2"));
        movieList.add(new Movie("Star Trek2"));
        movieList.add(new Movie("Galaxy Quest2"));
        movieList.add(new Movie("Harry Potter3"));
        movieList.add(new Movie("Twilight3"));
        movieList.add(new Movie("Star Wars3"));
        movieList.add(new Movie("Star Trek3"));
        movieList.add(new Movie("Galaxy Quest3"));
        return movieList;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
