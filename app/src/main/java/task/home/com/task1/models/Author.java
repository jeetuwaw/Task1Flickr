package task.home.com.task1.models;

public class Author {
    private String name;

    private String uri;
    private String nsID;
    private String flickrBuddyicon;

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    private String getNsid() {
        return this.nsID;
    }

    public void setNsID(String nsID) {
        this.nsID = nsID;
    }

    private String getFlickrBuddyicon() {
        return flickrBuddyicon;
    }

    public void setFlickrBuddyicon(String flickrBuddyicon) {
        this.flickrBuddyicon = flickrBuddyicon;
    }

    @Override
    public String toString() {
        return " [name = " + getName() + ", uri = " + getUri() + "NSID = " + getNsid() + "Icon = " + getFlickrBuddyicon() + "]";
    }


}

