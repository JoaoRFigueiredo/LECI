import java.util.List;

public class Movie {
    private final String title;
    private final int year;
    private final Person director;
    private final Person writer;
    private final String series;
    private final List<Person> cast;
    private final List<Place> locations;
    private final List<String> languages;
    private final List<String> genres;
    private final boolean isTelevision;
    private final boolean isNetflix;
    private final boolean isIndependent;

    public static class Builder{
        private final String title;
        private final int year;
        private final Person director;
        private final Person writer;
        private final String series;
        private final List<Person> cast;
        private final List<Place> locations;
        private final List<String> languages;
        private final List<String> genres;
        private final boolean isTelevision;
        private final boolean isNetflix;
        private final boolean isIndependent;

        public Builder(String title, int year, Person director, Person writer, String series, List<Person> cast, List<Place> locations, List<String> languages, List<String> genres, boolean isTelevision, boolean isNetflix, boolean isIndependent){
            this.title = title;
            this.year = year;
            this.director = director;
            this.writer = writer;
            this.series = series;
            this.cast = cast;
            this.locations = locations;
            this.languages = languages;
            this.genres = genres;
            this.isTelevision = isTelevision;
            this.isNetflix = isNetflix;
            this.isIndependent = isIndependent;
        }

        public Movie build(){
            return new Movie(this);
        }
    }

    private Movie(Builder builder){
        title = builder.title;
        year = builder.year;
        director = builder.director;
        writer = builder.writer;
        series = builder.series;
        cast = builder.cast;
        locations = builder.locations;
        languages = builder.languages;
        genres = builder.genres;
        isTelevision = builder.isTelevision;
        isNetflix = builder.isNetflix;
        isIndependent = builder.isIndependent;
    }
}
