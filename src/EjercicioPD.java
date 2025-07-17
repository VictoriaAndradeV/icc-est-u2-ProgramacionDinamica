import java.util.HashMap;
import java.util.Map;

public class EjercicioPD {
     private Map<Integer, Long> cache; // Usa el campo de instancia

    public EjercicioPD() {
        this.cache = new HashMap<>();
        cache.put(0, 0L);
        cache.put(1, 1L);
    }

    // Fibonacci recursivo sin optimización
    public long getFibonacci(int n) {
        if (n <= 1) return n;
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

    // Fibonacci con memoización
    public long getFibonacciPD(int n) {
        return getFibonacciPDHelper(n);
    }

    private long getFibonacciPDHelper(int n) {
        if (cache.containsKey(n)) return cache.get(n);
        long result = getFibonacciPDHelper(n - 1) + getFibonacciPDHelper(n - 2);
        cache.put(n, result);
        return result;
    }

}
