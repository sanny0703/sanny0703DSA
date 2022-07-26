package HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Design a food rating system that can do the following:
 * <p>
 * Modify the rating of a food item listed in the system.
 * Return the highest-rated food item for a type of cuisine in the system.
 * Implement the FoodRatings class:
 * <p>
 * FoodRatings(String[] foods, String[] cuisines, int[] ratings) Initializes the system. The food items are described by foods, cuisines and ratings, all of which have a length of n.
 * foods[i] is the name of the ith food,
 * cuisines[i] is the type of cuisine of the ith food, and
 * ratings[i] is the initial rating of the ith food.
 * void changeRating(String food, int newRating) Changes the rating of the food item with the name food.
 * String highestRated(String cuisine) Returns the name of the food item that has the highest rating for the given type of cuisine. If there is a tie, return the item with the lexicographically smaller name.
 */
public class FoodRatingSystem {
    private Map<String, PriorityQueue<Food>> cuisinesMap;
    private Map<String, Food> foodsMap;

    public FoodRatingSystem(String[] foods, String[] cuisines, int[] ratings) {
        cuisinesMap = new HashMap<>();
        foodsMap = new HashMap<>();
        int n = foods.length;
        for (int i = 0; i < n; i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            foodsMap.put(foods[i], food);
            if (!cuisinesMap.containsKey(cuisines[i]))
                cuisinesMap.put(cuisines[i], new PriorityQueue<>((a, b) -> a.rating == b.rating ? a.name.compareTo(b.name) : b.rating - a.rating));
            PriorityQueue<Food> queue = cuisinesMap.get(cuisines[i]);
            queue.offer(food);
        }
    }

    public static void main(String[] args) {
        FoodRatingSystem foodRatingSystem = new FoodRatingSystem(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"}, new int[]{9, 12, 8, 15, 14, 7});
        System.out.println(foodRatingSystem.highestRated("korean"));
        System.out.println(foodRatingSystem.highestRated("japanese"));
        foodRatingSystem.changeRating("sushi", 16);
        System.out.println(foodRatingSystem.highestRated("japanese"));
        foodRatingSystem.changeRating("ramen", 16);
        System.out.println(foodRatingSystem.highestRated("japanese"));
    }

    public void changeRating(String foodName, int newRating) {
        Food food = foodsMap.get(foodName);
        PriorityQueue<Food> queue = cuisinesMap.get(food.cuisine);
        queue.remove(food);
        food.rating = newRating;
        queue.offer(food);
    }

    public String highestRated(String cuisine) {
        return cuisinesMap.get(cuisine).peek().name;
    }

    static class Food {
        String name;
        String cuisine;
        int rating;

        public Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }
}
