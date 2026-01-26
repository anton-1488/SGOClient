package org.plovdev.sgo.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class SGOAnnouncement implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SerializedName("description")
    private String description;

    @SerializedName("postDate")
    private LocalDate postDate;

    @SerializedName("deleteDate")
    private LocalDate deleteDate;

    @SerializedName("author")
    private SGOUser author;

    @SerializedName("em")
    private SGOUser em;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    public SGOAnnouncement(String description, LocalDate postDate, LocalDate deleteDate, SGOUser author, SGOUser em, String name, int id) {
        this.description = description;
        this.postDate = postDate;
        this.deleteDate = deleteDate;
        this.author = author;
        this.em = em;
        this.name = name;
        this.id = id;
    }

    public SGOAnnouncement() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public LocalDate getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(LocalDate deleteDate) {
        this.deleteDate = deleteDate;
    }

    public SGOUser getAuthor() {
        return author;
    }

    public void setAuthor(SGOUser author) {
        this.author = author;
    }

    public SGOUser getEm() {
        return em;
    }

    public void setEm(SGOUser em) {
        this.em = em;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SGOAnnouncement{" +
                "description='" + description + '\'' +
                ", postDate=" + postDate +
                ", deleteDate=" + deleteDate +
                ", author=" + author +
                ", em=" + em +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}