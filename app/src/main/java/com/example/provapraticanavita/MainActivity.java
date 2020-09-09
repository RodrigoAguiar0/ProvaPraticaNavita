package com.example.provapraticanavita;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.provapraticanavita.controller.ControllerDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    final private Context context = this;
    private ControllerDetails controllerDetails;
    private RequestQueue mQueue;
    private ArrayList<Movie> movieList;
    private TextView movieResultList;
    private int pagina = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        controllerDetails = new ControllerDetails();
        movieList = new ArrayList();
        PopulateList(pagina);
    }

    private void PopulateList(int pagina){
        mQueue = Volley.newRequestQueue(this);
        String url = "https://api.themoviedb.org/3/discover/movie?api_key=d77a8e9c222a7e2f3b70d8f516ea7a42&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=" + pagina + "&primary_release_year=2020";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("results");
                            movieList = controllerDetails.jsonParse(jsonArray);
                            showMovieList();
                        } catch (JSONException error) {
                            error.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }

    private void showMovieList(){
        movieResultList = findViewById(R.id.movie_information_result);
        movieResultList.append(movieList.get(0).getTitle());
    }
}