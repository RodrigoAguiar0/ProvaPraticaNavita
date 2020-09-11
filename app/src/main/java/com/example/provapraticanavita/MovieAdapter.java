package com.example.provapraticanavita;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends ArrayAdapter <Movie>{

    private Context movieAdapterContext;
    private List<Movie> moviesList;
    private TextView movieTitle;
    private TextView releaseDate;
    private ImageView poster;

    public MovieAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<Movie> list) {
        super(context, 0, list);
        movieAdapterContext = context;
        moviesList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null){
            listItem = LayoutInflater.from(movieAdapterContext)
                    .inflate(R.layout.list_movies, parent, false);
            Movie currentMovie = moviesList.get(position);
        }
        poster = (ImageView) listItem.findViewById(R.id.movie_poster);
        Picasso.get().load("https://image.tmdb.org/t/p/w600_and_h900_bestv2" + moviesList
                .get(position).getPosterPath()).into(poster);
        movieTitle = (TextView) listItem.findViewById(R.id.movie_title);
        movieTitle.setText(moviesList.get(position).getOriginalTitle());
        releaseDate = (TextView) listItem.findViewById(R.id.movie_release_date);
        releaseDate.setText("Data de lançamento: " + moviesList.get(position).getReleaseDate());

        return listItem;
    }
}
