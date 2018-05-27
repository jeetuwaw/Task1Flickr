package task.home.com.task1.models;

public class FlickrModel {
    private Feed feed;

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    @Override
    public String toString() {
        return "ClassPojo [feed = " + getFeed().toString() + "]";
    }
}
