package DSA.Graph;

public class Main {
    public static void main(String[] args) {
        graph graph = new graph();
        graph.AddVertex("S");
        graph.AddVertex("A");
        graph.AddEdge("S", "A");
        graph.PrintGraph();
        graph.RemoveEdge("S", "A");
        graph.PrintGraph();
    }
}
