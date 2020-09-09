package com.example.provapraticanavita.controller;

import androidx.appcompat.app.AppCompatActivity;

import com.example.provapraticanavita.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ControllerDetails extends AppCompatActivity {

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }

    private ArrayList <Movie> movieList = new ArrayList();

    public ArrayList<Movie> jsonParse(JSONArray jsonArray) throws JSONException {
        for(int i = 0; i < jsonArray.length(); i++){
            JSONObject movieJson = jsonArray.getJSONObject(i);
            Movie movie = new Movie();
            movie.setPopularity(movieJson.getInt("popularity"));
            movie.setVoteCount(movieJson.getInt("vote_count"));
            movie.setPosterPath(movieJson.getString("poster_path"));
            movie.setMovieId(movieJson.getInt("id"));
            movie.setBackdropPath(movieJson.getString("backdrop_path"));
            movie.setOriginalLanguage(movieJson.getString("original_language"));
            movie.setOriginalTitle(movieJson.getString("original_title"));
            movie.setGenreId(movieJson.getJSONArray("genre_ids"));
            movie.setTitle(movieJson.getString("title"));
            movie.setVoteAverage(movieJson.getInt("vote_average"));
            movie.setOverview(movieJson.getString("overview"));
            movie.setReleaseDate(movieJson.getString("release_date"));
            movieList.add(movie);
            }
        return movieList;
        }
    }