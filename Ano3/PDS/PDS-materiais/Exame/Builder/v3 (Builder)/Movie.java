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
     /*public Movie(final String movieTitle,final int movieYear,final Person movieDirector,final Person movieWriter,
     final String movieSeries,final List<Person> movieCast,final List<Place> movieLocations,final List<String> movieLanguages,
     final List<String> movieGenres,final boolean television,final boolean netflix,final boolean independent){
          this.title = movieTitle;
          this.year = movieYear;
          this.director = movieDirector;
          this.writer = movieWriter;
          this.series = movieSeries;
          this.cast = movieCast;
          this.locations = movieLocations;
          this.languages = movieLanguages;
          this.genres = movieGenres;
          this.isTelevision = television;
          this.isNetflix = netflix;
          this.isIndependent = independent;
     }
*/
     public static class Builder {
          //required parameter
          private final String title; 
          private final int year; 
          private final Person director; 
          private final Person writer; 
          // optional parameter
          private final String series =""; 
          private final List<Person> cast = new List<Person>(); 
          private final List<Place> locations= new List<Place>(); 
          private final List<String> languages= new List<String>(); 
          private final List<String> genres= new List<String>(); 
          private final boolean isTelevision= false; 
          private final boolean isNetflix=false; 
          private final boolean isIndependent=false; 

     }
     public Builder(String title,int year,Person director,Person writer){
          this.title=title;
          this.year=year;
          this.director=director;
          this.writer=writer;
     }
     public Builder series(String item){
          series=item;
          return this;
     }
     public Builder cast(List<Person> castmember){
          cast.add(castmember);

          return this;
     }
     public Builder locations(List<Place> locals){
          locations.add(locals);

          return this;
     }
     public Builder languages(List<String> language){
          languages.addAll(language);

          return this;
     }
     public Builder genres(List<String> genre){
          genres.addAll(genre);

          return this;
     }
     public Builder isTelevision(Boolean tv){
          isTelevision=tv;
          return this;
     }
     public Builder isNetflix(Boolean netflix){
          isNetflix=netflix;
          return this;
     }
     public Builder isIndependent(Boolean ind){
          isIndependent=ind;
          return this;
     }
     public Movie build(){
          return new Movie(this);
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