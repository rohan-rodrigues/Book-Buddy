package io.github.charly1811.bookexampledemo;

/**
 * Created by rohanrodrigues on 4/29/17.
 */

public class Option {
    private String name;
    private String description;
    private int thumbnail;

    public Option() {
    }

    public Option(String name, String description, int thumbnail) {
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(double price) {
        this.description = description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
