import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A",0));
        nodeList.add(new GraphNode("B",1));
        nodeList.add(new GraphNode("C",2));
        nodeList.add(new GraphNode("D",3));
        nodeList.add(new GraphNode("E",4));
        nodeList.add(new GraphNode("F",5));
        nodeList.add(new GraphNode("G",6));
        Graph g = new Graph(nodeList);

        g.addUndirectionalEdge(0,1);
        g.addUndirectionalEdge(0,2);
        g.addUndirectionalEdge(1,3);
        g.addUndirectionalEdge(1,6);
        g.addUndirectionalEdge(2,3);
        g.addUndirectionalEdge(2,4);
        g.addUndirectionalEdge(3,5);
        g.addUndirectionalEdge(4,5);
        g.addUndirectionalEdge(5,6);

        System.out.println(g.toString());
        g.bfsSsp(nodeList.get(4));
    }
}