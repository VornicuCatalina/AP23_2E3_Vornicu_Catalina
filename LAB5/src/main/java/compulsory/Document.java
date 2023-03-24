package compulsory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {
    private String id;
    private String location;
    private String title;
    private String type;
    private Map<String, Object> tags = new HashMap<>();

    public void addTags(String key, Object obj) {
        tags.put(key, obj);
    }

    public Document(String name, String type, String path, String id) {
        this.title = name;
        this.type = type;
        this.location = path;
        this.id = id;
    }

}
