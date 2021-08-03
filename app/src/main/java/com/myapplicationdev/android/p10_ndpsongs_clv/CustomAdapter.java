package com.myapplicationdev.android.p10_ndpsongs_clv;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Song> songList;

    public CustomAdapter(Context context, int resource,
                         ArrayList<Song> objects){
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        songList = objects;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvYear = rowView.findViewById(R.id.tvYear);
        TextView tvStars = rowView.findViewById(R.id.tvStars);
        TextView tvSinger = rowView.findViewById(R.id.tvSinger);
        ImageView imgView = rowView.findViewById(R.id.imageView);

        Song currentSong = songList.get(position);

        tvTitle.setText((currentSong.getTitle()));
        tvYear.setText(currentSong.YeartoString());
        tvStars.setText(currentSong.StarstoString());
        tvSinger.setText(currentSong.getSingers());

        if (currentSong.getYearReleased()>=2019){
            imgView.setImageResource(R.drawable.newicon);
        } else {
            imgView.setVisibility(View.INVISIBLE);
        }

        return rowView;
    }
}
