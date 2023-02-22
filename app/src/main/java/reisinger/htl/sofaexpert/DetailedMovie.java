package reisinger.htl.sofaexpert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import reisinger.htl.sofaexpert.objects.Movie;

public class DetailedMovie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_movie);
        TextView title = findViewById(R.id.dTitle);
        TextView rating = findViewById(R.id.rating);
        TextView releaseDate = findViewById(R.id.release);
        TextView description = findViewById(R.id.description);
        ImageView image = findViewById(R.id.poster);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        Movie m = (Movie) b.getSerializable("movie");
        title.setText(m.getTitle());
        rating.setText(m.getVoteAverage() + " / 10");
        releaseDate.setText(m.getReleaseDate().toString());
        description.setText(m.getOverview());
        Picasso.get().load(("http://image.tmdb.org/t/p/w154" + m.getPosterPath())).into(image);
    }
}