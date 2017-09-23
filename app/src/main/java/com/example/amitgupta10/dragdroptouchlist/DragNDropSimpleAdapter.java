package com.example.amitgupta10.dragdroptouchlist;

/**
 * Created by amit.gupta10 on 07/04/16.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
//import android.widget.SimpleAdapter;
import android.widget.TextView;

public class DragNDropSimpleAdapter extends BaseAdapter /*implements DragNDropAdapter*/ {
//    private int mPosition[];
//    private int mHandler;
    private ArrayList<Movie> dataList;

    public DragNDropSimpleAdapter(Context context, ArrayList<Movie> data, int handler) {
//        super(context, data, resource, from, to);

//        mHandler = handler;
        dataList = data;
//        setup(data.size());
    }

//    private void setup(int size) {
//        mPosition = new int[size];
//
//        for (int i = 0; i < size; ++i)
//            mPosition[i] = i;
//    }

//    @Override
//    public View getDropDownView(int position, View view, ViewGroup group) {
//        return super.getDropDownView(mPosition[position], view, group);
//    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

//    @Override
//    public int getItemViewType(int position) {
//        return super.getItemViewType(mPosition[position]);
//    }

    @Override
    public long getItemId(int position) {
        return position;
    }

//    @Override
//    public View getView(int position, View view, ViewGroup group) {
//        return super.getView(mPosition[position], view, group);
//    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder vh;

        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            view = convertView;
            vh = (ViewHolder) view.getTag();
        }

        vh.movieNameTextView.setText((CharSequence) dataList.get(position).getName());

        return view;
    }

    public static class ViewHolder {

        public TextView movieNameTextView;
//        public float lastTouchedX;
//        public float lastTouchedY;

        public ViewHolder(View view){
            movieNameTextView = (TextView) view.findViewById(R.id.text);
        }

//        public void bindMovie(Movie movie){
//            this.movieNameTextView.setText(movie.getName());
//        }
    }

//    @Override
//    public boolean isEnabled(int position) {
//        return super.isEnabled(mPosition[position]);
//    }

//    @Override
//    public void onItemDrag(DragNDropListView parent, View view, int position, long id) {
//
//    }

//    @Override
//    public void onItemDrop(DragNDropListView parent, View view, int startPosition, int endPosition, long id) {
//        int position = startPosition;//mPosition[startPosition];
//        Movie startMovie = dataList.get(startPosition);
//
//        if (startPosition < endPosition)
//            for (int i = startPosition; i < endPosition; ++i){
////                mPosition[i] = mPosition[i + 1];
//                dataList.set(i, dataList.get(i + 1));
//            }
//
//        else if (endPosition < startPosition)
//            for (int i = startPosition; i > endPosition; --i) {
////                mPosition[i] = mPosition[i - 1];
//                dataList.set(i, dataList.get(i + 1));
//            }
//
////        mPosition[endPosition] = position;
//        dataList.set(endPosition, startMovie);
//    }

    @Override
    public int getCount() {
        return dataList.size();
    }

//    @Override
//    public void notifyDataSetChanged() {
////        setup(dataList.size());
//        super.notifyDataSetChanged();
//    }

//    @Override
//    public int getDragHandler() {
//        return mHandler;
//    }
}
