package task.home.com.task1.models;

@SuppressWarnings("ALL")
public class Category {
    private String scheme;

    private String term;

    private String getScheme() {
        return scheme;
    }

    @SuppressWarnings("unused")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    private String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return " [scheme = " + getScheme() + ", term = " + getTerm() + "]";
    }
}

