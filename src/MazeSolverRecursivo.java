import java.util.ArrayList;
import java.util.List;

public class MazeSolverRecursivo implements MazeSolver {
    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        if (findPath(grid, start.row, start.col, end, path, visited)) {
            return path;
        }
        return new ArrayList<>();
    }

    private boolean findPath(boolean[][] grid, int row, int col, Cell end, List<Cell> path, boolean[][] visited) {
        // Verificar fuera de límites o celda inválida
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return false;
        if (!grid[row][col] || visited[row][col])
            return false;

        visited[row][col] = true;

        // Si se llegó a la celda objetivo
        if (row == end.getRow() && col == end.getCol()) {
            path.add(0, new Cell(row, col)); // Añadir al inicio
            return true;
        }

        // Moverse en las 4 direcciones: abajo, arriba, derecha, izquierda
        if (findPath(grid, row + 1, col, end, path, visited) ||  // abajo
            findPath(grid, row - 1, col, end, path, visited) ||  // arriba
            findPath(grid, row, col + 1, end, path, visited) ||  // derecha
            findPath(grid, row, col - 1, end, path, visited)) {  // izquierda
            path.add(0, new Cell(row, col)); // Añadir al inicio
            return true;
        }

        return false;
    }
}
