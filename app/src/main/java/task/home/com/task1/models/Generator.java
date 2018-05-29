package task.home.com.task1.models;

@SuppressWarnings("unused")
public class Generator {
    private String content;

    private String uri;

    private String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "ClassPojo [content = " + getContent() + ", uri = " + getUri() + "]";
    }
}

