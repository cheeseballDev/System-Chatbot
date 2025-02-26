import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Menu extends ChatbotData {
    private final HashMap<String, List<String>> menu;
    private final Set<String> randomSuggestions;
    
    public Menu() {
        menu = new HashMap<>();
        randomSuggestions = new HashSet<>();

        loadResponses();
    }

    public void loadResponses() {
        // FOOD FOR THE RANDOMIZER
        randomSuggestions.add("Here's our menu for appetizers \n => Edamame \n > INGREDIENTS \n  - sea salt \n  - sesame seed \n => Vegetable Tempura \n > INGREDIENTS \n  - Japanese sweet potato \n  - Japanese or Chinese eggplant \n  - premade tempura batter \n => Potstickers \n > INGREDIENTS \n  - ground pork \n  - water chestnuts \n  - baby bok choy \n  - eggs \n => Agedashi Tofu \n > INGREDIENTS \n  - Medium-Firm Tofu \n  - Corn Starch \n  - grated Daikon \n  - Bonito flakes\n");
        randomSuggestions.add("Here's our menu for sushi rolls \n => California Roll \n > INGREDIENTS \n  - Crab meat \n  - Avocado \n  - Cucumber \n  - Nori (seaweed) \n  - Sushi rice \n => Spicy Tuna Roll \n > INGREDIENTS \n  - Tuna \n  - Spicy mayo \n  - Cucumber \n  - Nori (seaweed) \n  - Sushi rice \n => Tempura Roll \n > INGREDIENTS \n  - Shrimp tempura \n  - Avocado \n  - Cucumber \n  - Nori (seaweed) \n  - Sushi rice\n");
        randomSuggestions.add("Here's our menu for noodles \n => Ramen \n > INGREDIENTS \n  - Pork belly \n  - Ramen noodles \n  - Soft-boiled egg \n  - Miso broth \n  - Scallions \n => Udon \n > INGREDIENTS \n  - Udon noodles \n  - Tempura shrimp \n  - Dashi broth \n  - Scallions \n  - Pickled ginger \n => Soba \n > INGREDIENTS \n  - Soba noodles \n  - Buckwheat flour \n  - Soy sauce \n  - Wasabi \n  - Seaweed\n");

        menu.put("menu", Arrays.asList("Here's our menu for appetizers\n =>  Edamame \n > INGREDIENTS \n  - sea salt \n  - sesame seed\n =>  vegetable Tempura \n > INGREDIENTS\n  - Japanese sweet potato \n  - Japanese or Chinese eggplant \n  - premade tempura wrapped\n =>  Potstickers\n > INGREDIENTS \n  - ground pork \n  - water chestnuts \n  - baby bok choy \n  - eggs\n =>  Agedashi tofu\n > INGREDIENTS \n  - Medium-Firm Tofu \n  - Corn Starch \n  - grated Daikon \n  - Bonito Flakes\n\nHere's our menu for sushi rollstizers\n =>  Philadelphia \n > INGREDIENTS \n  - Fresh salmon \n  - Cream cheese \n  - Avocado\n =>  Negi-hama \n > INGREDIENTS \n  - Yellowtail \n  - Scallions \n  - Seasame seed\n =>  Crunchy Roll \n > INGREDIENTS \n  - Crab \n  - Cucumber \n  - Avocado \n  - Red tuna \n  - Salmon \n  - White tuna \n  - Tempura flake \n  - Masago\n =>  Green Dragon \n > INGREDIENTS \n  - Eel \n  - cucumber \n  - crab \n  - mixed salad \n  - avocado\n\nHere's our menu for noodles \n => Ramen \n > INGREDIENTS \n  - Pork belly \n  - Ramen noodles \n  - Soft-boiled egg \n  - Miso broth \n  - Scallions \n => Udon \n > INGREDIENTS \n  - Udon noodles \n  - Tempura shrimp \n  - Dashi broth \n  - Scallions \n  - Pickled ginger \n => Soba \n > INGREDIENTS \n  - Soba noodles \n  - Buckwheat flour \n  - Soy sauce \n  - Wasabi \n  - Seaweed\n\nIs there anything else you need? \n> "));
        menu.put("cuisine", Arrays.asList("Here's our menu for appetizers\n =>  Edamame \n > INGREDIENTS \n  - sea salt \n  - sesame seed\n =>  vegetable Tempura \n > INGREDIENTS\n  - Japanese sweet potato \n  - Japanese or Chinese eggplant \n  - premade tempura wrapped\n =>  Potstickers\n > INGREDIENTS \n  - ground pork \n  - water chestnuts \n  - baby bok choy \n  - eggs\n =>  Agedashi tofu\n > INGREDIENTS \n  - Medium-Firm Tofu \n  - Corn Starch \n  - grated Daikon \n  - Bonito Flakes\n\nHere's our menu for sushi rollstizers\n =>  Philadelphia \n > INGREDIENTS \n  - Fresh salmon \n  - Cream cheese \n  - Avocado\n =>  Negi-hama \n > INGREDIENTS \n  - Yellowtail \n  - Scallions \n  - Seasame seed\n =>  Crunchy Roll \n > INGREDIENTS \n  - Crab \n  - Cucumber \n  - Avocado \n  - Red tuna \n  - Salmon \n  - White tuna \n  - Tempura flake \n  - Masago\n =>  Green Dragon \n > INGREDIENTS \n  - Eel \n  - cucumber \n  - crab \n  - mixed salad \n  - avocado\n\nHere's our menu for noodles \n => Ramen \n > INGREDIENTS \n  - Pork belly \n  - Ramen noodles \n  - Soft-boiled egg \n  - Miso broth \n  - Scallions \n => Udon \n > INGREDIENTS \n  - Udon noodles \n  - Tempura shrimp \n  - Dashi broth \n  - Scallions \n  - Pickled ginger \n => Soba \n > INGREDIENTS \n  - Soba noodles \n  - Buckwheat flour \n  - Soy sauce \n  - Wasabi \n  - Seaweed\n\nIs there anything else you need? \n> "));
        menu.put("food", Arrays.asList("Here's our menu for appetizers\n =>  Edamame \n > INGREDIENTS \n  - sea salt \n  - sesame seed\n =>  vegetable Tempura \n > INGREDIENTS\n  - Japanese sweet potato \n  - Japanese or Chinese eggplant \n  - premade tempura wrapped\n =>  Potstickers\n > INGREDIENTS \n  - ground pork \n  - water chestnuts \n  - baby bok choy \n  - eggs\n =>  Agedashi tofu\n > INGREDIENTS \n  - Medium-Firm Tofu \n  - Corn Starch \n  - grated Daikon \n  - Bonito Flakes\n\nHere's our menu for sushi rollstizers\n =>  Philadelphia \n > INGREDIENTS \n  - Fresh salmon \n  - Cream cheese \n  - Avocado\n =>  Negi-hama \n > INGREDIENTS \n  - Yellowtail \n  - Scallions \n  - Seasame seed\n =>  Crunchy Roll \n > INGREDIENTS \n  - Crab \n  - Cucumber \n  - Avocado \n  - Red tuna \n  - Salmon \n  - White tuna \n  - Tempura flake \n  - Masago\n =>  Green Dragon \n > INGREDIENTS \n  - Eel \n  - cucumber \n  - crab \n  - mixed salad \n  - avocado\n\nHere's our menu for noodles \n => Ramen \n > INGREDIENTS \n  - Pork belly \n  - Ramen noodles \n  - Soft-boiled egg \n  - Miso broth \n  - Scallions \n => Udon \n > INGREDIENTS \n  - Udon noodles \n  - Tempura shrimp \n  - Dashi broth \n  - Scallions \n  - Pickled ginger \n => Soba \n > INGREDIENTS \n  - Soba noodles \n  - Buckwheat flour \n  - Soy sauce \n  - Wasabi \n  - Seaweed\n\nIs there anything else you need? \n> "));
        menu.put("tariff", Arrays.asList("Here's our menu for appetizers\n =>  Edamame \n > INGREDIENTS \n  - sea salt \n  - sesame seed\n =>  vegetable Tempura \n > INGREDIENTS\n  - Japanese sweet potato \n  - Japanese or Chinese eggplant \n  - premade tempura wrapped\n =>  Potstickers\n > INGREDIENTS \n  - ground pork \n  - water chestnuts \n  - baby bok choy \n  - eggs\n =>  Agedashi tofu\n > INGREDIENTS \n  - Medium-Firm Tofu \n  - Corn Starch \n  - grated Daikon \n  - Bonito Flakes\n\nHere's our menu for sushi rollstizers\n =>  Philadelphia \n > INGREDIENTS \n  - Fresh salmon \n  - Cream cheese \n  - Avocado\n =>  Negi-hama \n > INGREDIENTS \n  - Yellowtail \n  - Scallions \n  - Seasame seed\n =>  Crunchy Roll \n > INGREDIENTS \n  - Crab \n  - Cucumber \n  - Avocado \n  - Red tuna \n  - Salmon \n  - White tuna \n  - Tempura flake \n  - Masago\n =>  Green Dragon \n > INGREDIENTS \n  - Eel \n  - cucumber \n  - crab \n  - mixed salad \n  - avocado\n\nHere's our menu for noodles \n => Ramen \n > INGREDIENTS \n  - Pork belly \n  - Ramen noodles \n  - Soft-boiled egg \n  - Miso broth \n  - Scallions \n => Udon \n > INGREDIENTS \n  - Udon noodles \n  - Tempura shrimp \n  - Dashi broth \n  - Scallions \n  - Pickled ginger \n => Soba \n > INGREDIENTS \n  - Soba noodles \n  - Buckwheat flour \n  - Soy sauce \n  - Wasabi \n  - Seaweed\n\nIs there anything else you need? \n> "));
        menu.put("meals", Arrays.asList("Here's our menu for appetizers\n =>  Edamame \n > INGREDIENTS \n  - sea salt \n  - sesame seed\n =>  vegetable Tempura \n > INGREDIENTS\n  - Japanese sweet potato \n  - Japanese or Chinese eggplant \n  - premade tempura wrapped\n =>  Potstickers\n > INGREDIENTS \n  - ground pork \n  - water chestnuts \n  - baby bok choy \n  - eggs\n =>  Agedashi tofu\n > INGREDIENTS \n  - Medium-Firm Tofu \n  - Corn Starch \n  - grated Daikon \n  - Bonito Flakes\n\nHere's our menu for sushi rollstizers\n =>  Philadelphia \n > INGREDIENTS \n  - Fresh salmon \n  - Cream cheese \n  - Avocado\n =>  Negi-hama \n > INGREDIENTS \n  - Yellowtail \n  - Scallions \n  - Seasame seed\n =>  Crunchy Roll \n > INGREDIENTS \n  - Crab \n  - Cucumber \n  - Avocado \n  - Red tuna \n  - Salmon \n  - White tuna \n  - Tempura flake \n  - Masago\n =>  Green Dragon \n > INGREDIENTS \n  - Eel \n  - cucumber \n  - crab \n  - mixed salad \n  - avocado\n\nHere's our menu for noodles \n => Ramen \n > INGREDIENTS \n  - Pork belly \n  - Ramen noodles \n  - Soft-boiled egg \n  - Miso broth \n  - Scallions \n => Udon \n > INGREDIENTS \n  - Udon noodles \n  - Tempura shrimp \n  - Dashi broth \n  - Scallions \n  - Pickled ginger \n => Soba \n > INGREDIENTS \n  - Soba noodles \n  - Buckwheat flour \n  - Soy sauce \n  - Wasabi \n  - Seaweed\n\nIs there anything else you need? \n> "));
        menu.put("dishes", Arrays.asList("Here's our menu for appetizers\n =>  Edamame \n > INGREDIENTS \n  - sea salt \n  - sesame seed\n =>  vegetable Tempura \n > INGREDIENTS\n  - Japanese sweet potato \n  - Japanese or Chinese eggplant \n  - premade tempura wrapped\n =>  Potstickers\n > INGREDIENTS \n  - ground pork \n  - water chestnuts \n  - baby bok choy \n  - eggs\n =>  Agedashi tofu\n > INGREDIENTS \n  - Medium-Firm Tofu \n  - Corn Starch \n  - grated Daikon \n  - Bonito Flakes\n\nHere's our menu for sushi rollstizers\n =>  Philadelphia \n > INGREDIENTS \n  - Fresh salmon \n  - Cream cheese \n  - Avocado\n =>  Negi-hama \n > INGREDIENTS \n  - Yellowtail \n  - Scallions \n  - Seasame seed\n =>  Crunchy Roll \n > INGREDIENTS \n  - Crab \n  - Cucumber \n  - Avocado \n  - Red tuna \n  - Salmon \n  - White tuna \n  - Tempura flake \n  - Masago\n =>  Green Dragon \n > INGREDIENTS \n  - Eel \n  - cucumber \n  - crab \n  - mixed salad \n  - avocado\n\nHere's our menu for noodles \n => Ramen \n > INGREDIENTS \n  - Pork belly \n  - Ramen noodles \n  - Soft-boiled egg \n  - Miso broth \n  - Scallions \n => Udon \n > INGREDIENTS \n  - Udon noodles \n  - Tempura shrimp \n  - Dashi broth \n  - Scallions \n  - Pickled ginger \n => Soba \n > INGREDIENTS \n  - Soba noodles \n  - Buckwheat flour \n  - Soy sauce \n  - Wasabi \n  - Seaweed\n\nIs there anything else you need? \n> "));
    }

    @Override
    public String[] getResponsesContent(){
        return menu.keySet().toArray(new String[0]);
    }

    public String foodRandomizer(){
        String[] foodArray = randomSuggestions.toArray(new String[0]);
        Random rng = new Random();
        return "Here are our suggestions for you!\n" + foodArray[rng.nextInt(foodArray.length)];
    }

    @Override
    public String getResponse(String userResponse) {
        for (String chatContent : menu.keySet()){
            if (userResponse.toLowerCase().contains(chatContent)) {
                    List<String> chat = menu.get(chatContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }
        return getBotMessage(0);
    }

}
