package com.example.provapraticanavita;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;

public class Movie extends AppCompatActivity {

    private Integer popularity, voteCount, movieId, voteAverage;
    private JSONArray genreId;
    private String posterPath, backdropPath, originalLanguage, originalTitle, currentTitle, overview,
            releaseDate;

    public Movie(Integer popularity, Integer voteCount, String posterPath, Integer movieId,
                 String backdropPath, String originalLanguage, String originalTitle,
                 Integer[] genreId, String currentTitle, Integer voteAverage, String overview,
                 String releaseDate){
    }

    public Movie(){
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public void setGenreId(JSONArray genreId) {
        this.genreId = genreId;
    }

    public JSONArray getGenreId() {
        return genreId;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Integer voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getCurrentTitle() {
        return currentTitle;
    }

    public void setCurrentTitle(String currentTitle) {
        this.currentTitle = currentTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
