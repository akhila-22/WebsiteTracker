public class WebsiteModel {
    private int id;
    private String url;
    private String name;
    private int status;


    public WebsiteModel() {
    }

    public WebsiteModel(int id,String url, String name, int status)
    {
        this.id=id;
        this.name=name;
        this.url=url;
        this.status=status;

    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
