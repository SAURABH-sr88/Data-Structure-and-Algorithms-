package LeetcodeQuestions;
import java.util.*;

public class DesignFoodRatingSystem2353 {
        private Map<String, String> foodToCuisine;
        private Map<String, Integer> foodToRating;
        private Map<String, TreeSet<Food>> cuisineToFoods;

        public DesignFoodRatingSystem2353(String[] foods, String[] cuisines, int[] ratings) {
            foodToCuisine = new HashMap<>();
            foodToRating = new HashMap<>();
            cuisineToFoods = new HashMap<>();

            for (int i = 0; i < foods.length; i++) {
                String food = foods[i];
                String cuisine = cuisines[i];
                int rating = ratings[i];

                foodToCuisine.put(food, cuisine);
                foodToRating.put(food, rating);

                cuisineToFoods.putIfAbsent(cuisine, new TreeSet<>());
                cuisineToFoods.get(cuisine).add(new Food(rating, food));
            }
        }

        public void changeRating(String food, int newRating) {
            String cuisine = foodToCuisine.get(food);
            int oldRating = foodToRating.get(food);

            // Remove the old rating
            cuisineToFoods.get(cuisine).remove(new Food(oldRating, food));

            // Update the rating
            foodToRating.put(food, newRating);

            // Add the new rating
            cuisineToFoods.get(cuisine).add(new Food(newRating, food));
        }

        public String highestRated(String cuisine) {
            return cuisineToFoods.get(cuisine).first().name;
        }

        private static class Food implements Comparable<Food> {
            int rating;
            String name;

            Food(int rating, String name) {
                this.rating = rating;
                this.name = name;
            }

            @Override
            public int compareTo(Food other) {
                if (this.rating != other.rating) {
                    return Integer.compare(other.rating, this.rating); // Descending order
                }
                return this.name.compareTo(other.name); // Lexicographical order
            }
        }
}
