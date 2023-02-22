package reisinger.htl.sofaexpert.functions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

import reisinger.htl.sofaexpert.R;
import reisinger.htl.sofaexpert.objects.Movie;

public class MovieAdapter extends ArrayAdapter<Movie> {
    public MovieAdapter(@NonNull Context context, @NonNull List<Movie> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.moviecard, parent, false);
        }

        Movie movie = getItem(position);
        ImageView image = listitemView.findViewById(R.id.movieImage);

        Picasso.get().load(("http://image.tmdb.org/t/p/w154" + movie.getPosterPath())).into(image);
        return listitemView;
    }
}
