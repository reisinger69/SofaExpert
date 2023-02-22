package reisinger.htl.sofaexpert.objects;

import java.io.Serializable;
import java.time.LocalDate;

public class Movie implements Serializable {
    String title;
    double voteAverage;
    String posterPath;
    LocalDate releaseDate;
    String overview;

    public Movie(String title, double vote_average, String posterPath, LocalDate releaseDate, String overview) {
        this.title = title;
        this.voteAverage = vote_average;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.overview = overview;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", voteAverage=" + voteAverage +
                ", posterPath='" + posterPath + '\'' +
                ", releaseDate=" + releaseDate +
                ", overview='" + overview + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
