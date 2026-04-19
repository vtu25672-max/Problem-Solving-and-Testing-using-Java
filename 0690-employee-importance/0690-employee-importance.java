import java.util.*;

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        // Step 1: Create a map for quick lookup of employees by ID
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        
        // Step 2: Use a helper function to calculate total importance recursively
        return dfs(id, map);
    }

    private int dfs(int id, Map<Integer, Employee> map) {
        Employee employee = map.get(id);
        int total = employee.importance;
        
        // Add importance of all subordinates
        for (Integer subId : employee.subordinates) {
            total += dfs(subId, map);
        }
        
        return total;
    }
}
