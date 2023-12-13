import java.util.ArrayList;
import java.util.List;

public class GraphConverter {
    
    public static List<String> adjacencyMatrixToEdgeList(int[][] matrix, String[] nodeNames) {
        List<String> edgeList = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) { // Assuming 0 indicates no edge
                    String edge = nodeNames[i] + "-" + matrix[i][j] + "-" + nodeNames[j];
                    edgeList.add(edge);
                }
            }
        }

        return edgeList;
    }

    public static void main(String[] args) {
        // Example adjacency matrix
        //Symmetric = Non Directional
        //Non Symmetric = Directional
        int[][] adjacencyMatrix = {
            {0, 2, 0},
            {2, 0, 3},
            {0, 3, 0}
        };

        // Node names
        String[] nodeNames = {"A", "B", "C"};

        // Convert and print edge list
        List<String> edgeList = adjacencyMatrixToEdgeList(adjacencyMatrix, nodeNames);
        edgeList.forEach(System.out::println);
    }
}

