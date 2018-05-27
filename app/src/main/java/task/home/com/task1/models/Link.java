package task.home.com.task1.models;

public class Link
{
    private String rel;

    private String type;

    private String href;

    private String getRel()
    {
        return rel;
    }

    public void setRel (String rel)
    {
        this.rel = rel;
    }

    private String getType()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getHref ()
    {
        return href;
    }

    public void setHref (String href)
    {
        this.href = href;
    }

    @Override
    public String toString()
    {
        return " [rel = "+getRel()+", type = "+getType()+", href = "+getHref()+"]";
    }
}

