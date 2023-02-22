package reisinger.htl.sofaexpert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import reisinger.htl.sofaexpert.functions.MovieAdapter;
import reisinger.htl.sofaexpert.objects.Movie;

public class MainActivity extends AppCompatActivity {

    List<Movie> movies = new ArrayList<>();

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            readMovies();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        gridView = findViewById(R.id.gridV);
        MovieAdapter adapter = new MovieAdapter(this, movies);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), DetailedMovie.class);
                intent.putExtra("movie", movies.get(i));
                startActivity(intent);
            }
        });


    }

    public void readMovies() throws IOException, JSONException {
        StringBuilder jsonString = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(getAssets().open("movies.json")));
        String line;
        while ((line = bf.readLine()) != null) {
            jsonString.append(line.trim());
        }
        JSONObject js = new JSONObject(jsonString.toString());
        JSONArray jsArray = js.getJSONArray("results");
        for (int i = 0; i < jsArray.length(); i++) {
            JSONObject m = (JSONObject) jsArray.get(i);
            movies.add(new Movie((String) m.get("title"), Double.parseDouble(String.valueOf((m.get("vote_average")))), (String) m.get("poster_path"), LocalDate.parse(String.valueOf(m.get("release_date"))), (String) m.get("overview")));
        }

    }
}