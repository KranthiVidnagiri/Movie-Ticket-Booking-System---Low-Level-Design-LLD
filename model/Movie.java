package model;

public class Movie {
    private final String id;
    private String name;

    public Movie(final String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getTitle() {
        return name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + id + '\'' +
                ", title='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }
}
