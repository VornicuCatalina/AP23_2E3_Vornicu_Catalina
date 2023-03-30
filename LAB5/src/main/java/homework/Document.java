package homework;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {
    private String id;
    private String location;
    private String title;
    private String type;
    private Map<String, Object> tags ;

    public void addTags(String key, Object obj) {
        tags.put(key, obj);
    }

    public Document(String name, String type, String path, String id) {
        tags= new HashMap<>();
        this.title = name;
        this.type = type;
        this.location = path;
        this.id = id;
    }

    public Document(){
        tags= new HashMap<>();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }
    public void addTag(String key, Object obj){
        tags.put(key,obj);
    }
}
