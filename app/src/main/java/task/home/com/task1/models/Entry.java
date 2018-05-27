package task.home.com.task1.models;

import java.util.ArrayList;

public class Entry {
    private String id;

    private Content content;

    private Author author;

    private String title;

    private Category category;

    private String updated;

    private ArrayList<Link> link;

    private String published;

    private String displaycategories;

    private String flickrDateTaken;

    private String dcDateTaken;

    private String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    private Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    private String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    private String getUpdated() {
        return updated;
    }

    @SuppressWarnings("unused")
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public ArrayList<Link> getLink() {
        return link;
    }

    public void setLink(ArrayList<Link> link) {
        this.link = link;
    }

    private String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    private String getDisplaycategories() {
        return displaycategories;
    }

    public void setDisplaycategories(String displaycategories) {
        this.displaycategories = displaycategories;
    }

    private String getFlickrDateTaken() {
        return flickrDateTaken;
    }

    public void setFlickrDateTaken(String flickrDateTaken) {
        this.flickrDateTaken = flickrDateTaken;
    }

    private String getDcDateTaken() {
        return dcDateTaken;
    }

    public void setDcDateTaken(String dcDateTaken) {
        this.dcDateTaken = dcDateTaken;
    }

    @Override
    public String toString() {
        return " [id = " + getId() + ", content = " + getContent() + ", author = " + getAuthor() + ", title = " + getTitle() + ", category = " + getCategory() + ", updated = " + getUpdated() + ", link = " + getLink() + ", published = " + getPublished() + ", displaycategories = " + getDisplaycategories() + ",FlickrDateTaken = " + getFlickrDateTaken() + "]";
    }
}

