package task.home.com.task1.models;

@SuppressWarnings("ALL")
public class Content
{
    private String content;

    private String type;

    private String getContent()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    private String getType()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return " [content = "+getContent()+", type = "+getType()+"]";
    }
}


