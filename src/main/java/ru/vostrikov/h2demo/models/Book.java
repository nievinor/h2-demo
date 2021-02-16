package ru.vostrikov.h2demo.models;

public class Book {

    private long id;
    private String name;
    private long authorId;
    private long genreId;

    public Book() {
    }

    public Book(String name, long authorId, long genreId) {
        this.name = name;
        this.authorId = authorId;
        this.genreId = genreId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + "', authorId=" + authorId + ", genreId='" + genreId + '}';
    }

}
