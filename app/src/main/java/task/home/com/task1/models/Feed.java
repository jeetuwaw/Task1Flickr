package task.home.com.task1.models;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Feed {
    private String id;

    private String icon;

    private String title;

    private String updated;

    private ArrayList<Link> link;

    private ArrayList<Entry> entry;

    private String subtitle;

    private Generator generator;

    private String xmlns;

    private String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    private String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    private ArrayList<Link> getLink() {
        return link;
    }

    public void setLink(ArrayList<Link> link) {
        this.link = link;
    }

    public ArrayList<Entry> getEntry() {
        return entry;
    }

    public void setEntry(ArrayList<Entry> entry) {
        this.entry = entry;
    }

    private String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    private Generator getGenerator() {
        return generator;
    }

    public void setGenerator(Generator generator) {
        this.generator = generator;
    }

    private String getXmlns() {
        return xmlns;
    }

    @Override
    public String toString() {
        return "[id = " + getId() + ", icon = " + getIcon() + ", title = " + getTitle() + ", updated = " + getUpdated() + ", link = " + getLink() + ", entry = " + getEntry() + ", subtitle = " + getSubtitle() + ", generator = " + getGenerator() + ", xmlns = " + getXmlns() + "]";
    }
}

