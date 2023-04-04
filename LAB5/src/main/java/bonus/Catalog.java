package bonus;



import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.DefaultParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.graph4j.Graph;
import org.graph4j.GraphBuilder;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class Catalog implements Serializable {
    private String name;
    private List<Document> docs;

    //bonus
    private Map<String,Integer> numberOfColorsPerType=new HashMap<>();
    private int maximumPerNodes=0;
    Graph graph = GraphBuilder.empty().buildGraph();
    private LinkedList<String> tags=new LinkedList<>();

    //end bonus


    public Catalog(String catalog) {
        docs = new ArrayList<>();
        this.name = catalog;
    }

    public Catalog() {
        docs = new ArrayList<>();
    }

    public List<Document> getDocs() {
        return docs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDocs(List<Document> docs) {
        this.docs = docs;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", docs=" + docs +
                '}';
    }

    public void info() throws IOException, TikaException, SAXException {
        gettingMetadata();
    }

    private void gettingMetadata() throws IOException, TikaException, SAXException {
        File file=new File("C:/Users/User/Documents/AP23_2E3_Vornicu_Catalina/output.html");
        Parser parser=new AutoDetectParser();
        BodyContentHandler bodyContentHandler=new BodyContentHandler();
        Metadata metadata=new Metadata();
        FileInputStream inputStream=new FileInputStream(file);
        ParseContext context=new ParseContext();

        parser.parse(inputStream, bodyContentHandler, metadata, context);
        System.out.println(bodyContentHandler.toString());

        metadata.add("description","Testing");
        String[] metadataNames = metadata.names();
        for(String name:metadataNames){
            System.out.println(name+" : "+metadata.get(name));
        }
    }

    //bonus
    public void modifyValue(String type){
        numberOfColorsPerType.replace(type,numberOfColorsPerType.get(type)+1);
    }

    public void addValue(String type, Document document){
        numberOfColorsPerType.put(type,1);
    }
    public void addingVertex(Document document){

        graph.addVertex(docs.indexOf(document));
    }

    public void addingEdges(Document document, String type){
        for(Document doc:this.getDocs()){
            if(doc.getId().compareTo(document.getId())!=0) {
                for (String s : doc.getTags().values()) {
                    if (s.compareTo(type) == 0 && docs.indexOf(document)!=docs.indexOf(doc)) {
                        graph.addEdge(docs.indexOf(document), docs.indexOf(doc));
                    }
                }
            }
        }
    }
    public LinkedList<String> getTags(){
        return tags;
    }

    public int getMaximumPerNodes(){
        docs.stream().forEach(d->{
            int sizeTag=d.getTags().size();
            if(sizeTag>maximumPerNodes){
                maximumPerNodes=sizeTag;
            }
        });
        int maximumMap=0;
        for(Integer i: numberOfColorsPerType.values()){
            if(i>maximumMap){
                maximumMap=i;
            }
        }
        if(maximumMap>maximumPerNodes){
            return maximumMap;
        }
        return maximumPerNodes;
    }
    public void ColorAlg(){
        int nrNodes=getMaximumPerNodes();
        int[] colors=new int[docs.size()];
        Arrays.fill(colors,0);
        if(!graphColoringUtil(graph,nrNodes,colors,0)){
            System.out.println("Does not exist");
        }
        else{
            printColors(colors);
        }
    }

    private boolean graphColoringUtil(Graph g, int m, int colors[],int v){
        if(v==docs.size())
            return true;

        for(int cr=1;cr<=m;cr++){
            if(isSafe(v,g,colors,cr)){
                colors[v]=cr;
                if(graphColoringUtil(g,m,colors,v+1))
                    return true;

                colors[v]=0;
            }
        }
        return false;
    }
    private void printColors(int[] colors){
        for(int i=0;i<colors.length;i++){
            System.out.println("Vertex "+docs.get(i).getTitle()+" has the color "+colors[i]);
        }
    }
    private boolean isSafe(int v, Graph g, int colors[],int cr){
        for(int i=0;i<docs.size();i++){
            if(g.containsEdge(v,i) && cr==colors[i]){
                return false;
            }
        }
        return true;
    }
}
