package com.example.provapraticanavita;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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


public class MainActivity extends AppCompatActivity implements AbsListView.OnScrollListener {

    final private Context context = this;
    private ControllerDetails controllerDetails;
    private RequestQueue mQueue;
    private ArrayList<Movie> movieList;
    private int page = 1;
    private MovieAdapter movieAdapter;
    private ListView listView;
    private int preLast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.movies_list);
        controllerDetails = new ControllerDetails();
        movieList = new ArrayList();
        PopulateList(page);
        listView.setOnScrollListener(this);
    }



    private void PopulateList(int page){
        mQueue = Volley.newRequestQueue(this);
        String url = "https://api.themoviedb.org/3/discover/movie?api_key=d77a8e9c222a7e2f3b70d8f516ea7a42&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=" + page;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        if(movieList != null){

                        }
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
        movieAdapter = new MovieAdapter(this, movieList);
        listView.setAdapter(movieAdapter);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        {

            switch (view.getId()) {
                case R.id.movies_list:

                    final int lastItem = firstVisibleItem + visibleItemCount;

                    if (lastItem == totalItemCount) {
                        if (preLast != lastItem) {
                            Log.d("Last", "Last");
                            preLast = lastItem;
                        }
                        page++;
                        PopulateList(page);
                    }
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
