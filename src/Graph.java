import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    public ArrayList<GraphNode> nodeList = new ArrayList<>();
    public Graph(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
    }
    public void addUndirectionalEdge(int i, int j){
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first);
    }
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("  ");
        for(GraphNode name : this.nodeList){
            s.append(name.name+" ");
        }
        s.append("\n");

        for(int i = 0;i < nodeList.size();i++){
            s.append(nodeList.get(i).name+" ");
            for (GraphNode node : nodeList.get(i).neighbors){
                s.append(node.name+"->");
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }


//  Breadth first search
    public void bfsVisit(GraphNode node){
      Queue<GraphNode> q = new LinkedList<GraphNode>();
      q.add(node);

      while(!q.isEmpty()){
          GraphNode currentNode = q.remove();
          if(!currentNode.isVisited){
              System.out.print(currentNode.name+" ");
              currentNode.isVisited = true;
              for(GraphNode neighbor : currentNode.neighbors){
                  if(!neighbor.isVisited){
                      q.add(neighbor);
                  }
              }

          }
      }
    }
    public void bfs(){
        for(GraphNode node : nodeList){
            bfsVisit(node);
        }
    }



//  Depth first search
    public void dfsVisit(GraphNode node){
        Stack<GraphNode> s = new Stack<GraphNode>();
        s.push(node);

        while(!s.isEmpty()){
            GraphNode currNode = s.pop();
            if(!currNode.isVisited){

                currNode.isVisited = true;
                System.out.print(currNode.name+" -> ");
                for(GraphNode neighbor : currNode.neighbors){
                    if(!neighbor.isVisited){
                        s.push(neighbor);
                    }
                }
            }
        }
    }
    public void dfs(){
        for(GraphNode node : nodeList){
            if(!node.isVisited){
                dfsVisit(node);
            }
        }
    }



// Topological Sort
    public void addDirectedEdge(int i, int j){
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbors.add(second);
    }
    public void topologicalVisited(GraphNode node, Stack<GraphNode> stack){
        for(GraphNode neighbor : node.neighbors ){
            if(!neighbor.isVisited){
                topologicalVisited(neighbor, stack);
            }
        }
        node.isVisited = true;
        stack.push(node);
    }
    public void tls(){
        Stack<GraphNode> stack = new Stack<GraphNode>();

        for(GraphNode node : nodeList){
            if(!node.isVisited){
                topologicalVisited(node, stack);
            }
        }

        while(!stack.isEmpty()){
            GraphNode currNode = stack.pop();
            System.out.print(currNode.name+" ");
        }
    }

//    BFS ssspp


    public void pathPrint(GraphNode node){
        if(node.parent != null){
            pathPrint(node.parent);
        }
        System.out.print(node.name+" ");
    }


    public void bfsSsp(GraphNode node){
        Queue<GraphNode> q = new LinkedList<GraphNode>();
        q.add(node);
        while(!q.isEmpty()){
            GraphNode currNode = q.remove();
            currNode.isVisited = true;
            System.out.print("The following is the path for "+currNode.name+": ");
            pathPrint(currNode);
            System.out.println();
            for(GraphNode neighbor : currNode.neighbors){
                if (!neighbor.isVisited){
                    neighbor.parent = currNode;
                    q.add(neighbor);
                    neighbor.isVisited = true;
                }
            }

        }
    }
}
