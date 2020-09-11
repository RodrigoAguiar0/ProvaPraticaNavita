package com.example.provapraticanavita;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Details extends AppCompatActivity {

    private TextView movieTitle,movieGenre, movieDetailsDetails;
    private ImageView movieImage;
    private Toolbar detailsToolbar;
    private Movie movie;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        detailsToolbar = findViewById(R.id.details_toolbar);
        movieTitle = findViewById(R.id.movie_details_title);
        movieImage = findViewById(R.id.movie_detais_poster);
        movieGenre = findViewById(R.id.movie_details_genre);
        movieDetailsDetails = findViewById(R.id.movie_details_details);
        movie = (Movie) getIntent().getSerializableExtra("Movie");

        populateMovieDetails();
    }

    public void populateMovieDetails(){
        String genres = "";
        movieTitle.setText(movie.getCurrentTitle());
        Picasso.get().load("https://image.tmdb.org/t/p/w600_and_h900_bestv2"
                .concat(movie.getPosterPath())).into(movieImage);

        detailsToolbar.setTitle("Detalhes de ".concat(movie.getCurrentTitle()));

        ArrayList <String> movieGenresList = movie.getMovieGenres();
        for (int i = 0; i < movieGenresList.size(); i++){
            if(movieGenresList.size() - 1 == i){
                genres = genres.concat(movieGenresList.get(i)).concat(".");
            }else{
                genres = genres.concat(movieGenresList.get(i)).concat(", ");
            }
        }
        movieGenre.setText("Gênero(s) - ".concat(genres));

        movieDetailsDetails.setText(movie.getOverview());
    }

}
