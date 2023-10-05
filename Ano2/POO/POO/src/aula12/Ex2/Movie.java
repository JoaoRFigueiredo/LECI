package aula12.Ex2;

public class Movie {
    private String name;
    private double score;
    private String rating;
    private String genre;
    private int time;

    public Movie(String name, double score, String rating, String genre, int time){
        this.name = name;
        this.score = score;
        this.rating = rating;
        this.genre = genre;
        this.time = time;
    }

    public String getName(){
        return name;
    }

    public double getScore(){
        return score;
    }

    public String getRating(){
        return rating;
    }

    public String getGenre(){
        return genre;
    }

    public int getTime(){
        return time;
    }

    public String toString(){
        return String.format("%-40s%-20.2f%-20s%-20s%-20d", this.name, this.score, this.rating, this.genre, this.time);
    }
}
