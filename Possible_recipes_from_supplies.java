import java.util.*;

public class Possible_recipes_from_supplies {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        Set<String> supplySet = new HashSet<>(Arrays.asList(supplies));

        // Build graph and indegree map
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            List<String> ingList = ingredients.get(i);
            for (String ing : ingList) {
                graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipe);
            }
            indegree.put(recipe, ingList.size());
        }

        Queue<String> queue = new LinkedList<>(supplySet);
        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            String item = queue.poll();

            if (!graph.containsKey(item)) continue;

            for (String recipe : graph.get(item)) {
                indegree.put(recipe, indegree.get(recipe) - 1);
                if (indegree.get(recipe) == 0) {
                    queue.offer(recipe);
                    result.add(recipe);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Possible_recipes_from_supplies solver = new Possible_recipes_from_supplies();

        // Sample test case
        String[] recipes = {"bread", "sandwich", "burger"};
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(Arrays.asList("yeast", "flour"));         // for bread
        ingredients.add(Arrays.asList("bread", "meat"));          // for sandwich
        ingredients.add(Arrays.asList("sandwich", "lettuce"));    // for burger
        String[] supplies = {"yeast", "flour", "meat", "lettuce"};

        List<String> possibleRecipes = solver.findAllRecipes(recipes, ingredients, supplies);

        System.out.println("Recipes you can make: " + possibleRecipes);
    }
}
