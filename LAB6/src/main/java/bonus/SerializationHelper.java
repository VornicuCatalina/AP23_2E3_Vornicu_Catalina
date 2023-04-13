package bonus;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class SerializationHelper implements Serializable {
    int numVertices;
    float edgeProbability;
    int[] x, y;

    int player;
    boolean finished;
    Graph<List<Integer>, DefaultEdge> graphJGraphT;
    Map<List<Integer>, Integer> nodesToUser; // 0 -nobody ; 1-player1 ; 2-player2

    public SerializationHelper(int numVertices, float edgeProbability, int[] x, int[] y, int player, boolean finished, Graph<List<Integer>, DefaultEdge> graphJGraphT, Map<List<Integer>, Integer> nodesToUser) {
        this.numVertices = numVertices;
        this.edgeProbability = edgeProbability;
        this.x = x;
        this.y = y;
        this.player = player;
        this.finished = finished;
        this.graphJGraphT = graphJGraphT;
        this.nodesToUser = nodesToUser;
    }
}
