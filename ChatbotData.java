
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ChatbotData {
    private final Set<String> yesResponses;
    private final Set<String> noResponses;
    private final Set<String> tablePreference;
    private final Set<String> randomSuggestions;
    private final Set<String> helpResponses;
    private final HashMap<String, List<String>> responses;
    private final HashMap<String, List<String>> reservations; 
    private final HashMap<String, List<String>> tableCoupleReservation;
    private final HashMap<String, List<String>> tablePartyReservation;
    private int partyAmount;
    private String dateAndTime;
    private String specialRequests;
    private String tablePreferenceString;
    
    private String[] botMessage = new String[10];
    private String username;

    public ChatbotData() {
        yesResponses = new HashSet<>();
        noResponses = new HashSet<>();
        tablePreference = new HashSet<>();
        randomSuggestions = new HashSet<>();
        helpResponses = new HashSet<>();
        responses = new HashMap<>();
        reservations = new HashMap<>();
        tableCoupleReservation = new HashMap<>();
        tablePartyReservation = new HashMap<>();

        loadResponses();
        botMessage[0] = "I did not understand what you said. Can you please repeat that?\n> ";
        botMessage[1] = "Would you like a list of things I can assist you with?\n> ";
    }

    private void loadResponses() {
        // YES
        yesResponses.add("sure");
        yesResponses.add("okay");
        yesResponses.add("ok");
        yesResponses.add("hai");
        yesResponses.add("yur");
        yesResponses.add("yes");

        // NO
        noResponses.add("no");
        noResponses.add("nah");
        noResponses.add("nope");
        noResponses.add("n");
        noResponses.add("not really");
        noResponses.add("iie");

        // HELP
        helpResponses.add("help");
        helpResponses.add("support");
        helpResponses.add("list");
        helpResponses.add("huh");
        helpResponses.add("what");
        helpResponses.add("?");

        // FOOD FOR THE RANDOMIZER
        randomSuggestions.add("Here's our menu for appetizers \n => Edamame \n > INGREDIENTS \n  - sea salt \n  - sesame seed \n => Vegetable Tempura \n > INGREDIENTS \n  - Japanese sweet potato \n  - Japanese or Chinese eggplant \n  - premade tempura batter \n => Potstickers \n > INGREDIENTS \n  - ground pork \n  - water chestnuts \n  - baby bok choy \n  - eggs \n => Agedashi Tofu \n > INGREDIENTS \n  - Medium-Firm Tofu \n  - Corn Starch \n  - grated Daikon \n  - Bonito flakes\n");
        randomSuggestions.add("Here's our menu for sushi rolls \n => California Roll \n > INGREDIENTS \n  - Crab meat \n  - Avocado \n  - Cucumber \n  - Nori (seaweed) \n  - Sushi rice \n => Spicy Tuna Roll \n > INGREDIENTS \n  - Tuna \n  - Spicy mayo \n  - Cucumber \n  - Nori (seaweed) \n  - Sushi rice \n => Tempura Roll \n > INGREDIENTS \n  - Shrimp tempura \n  - Avocado \n  - Cucumber \n  - Nori (seaweed) \n  - Sushi rice\n");
        randomSuggestions.add("Here's our menu for noodles \n => Ramen \n > INGREDIENTS \n  - Pork belly \n  - Ramen noodles \n  - Soft-boiled egg \n  - Miso broth \n  - Scallions \n => Udon \n > INGREDIENTS \n  - Udon noodles \n  - Tempura shrimp \n  - Dashi broth \n  - Scallions \n  - Pickled ginger \n => Soba \n > INGREDIENTS \n  - Soba noodles \n  - Buckwheat flour \n  - Soy sauce \n  - Wasabi \n  - Seaweed\n");

        // BASIC RESPONSES
        responses.put("hello", Arrays.asList("Hi {username}! I am BOT Mika. Please check our list by typing list for all of our available choices by typing list.\n> ", "Irasshaimase {username}! I am BOT Mika. Please check our list for all available choices by typing list.\n> "));
        responses.put("hi", Arrays.asList("Konnichiwa {username}! I am BOT Mika. Please check our list by typing list for all of our available choices by typing list.\n> ", "Hello {username}! I am BOT Mika. Please check our list for all available choices by typing list.\n> "));
        responses.put("list", Arrays.asList("Here's the list of features available!\n> Restaurant description and information\n> Booking a reservation\n * Includes couple and party \n> Opening hours\n> Menu\n> Contact information\n - Telephone number\n - Email address\n - Address\n\nIs there anything that suits your interest?\n> "));
        responses.put("features", Arrays.asList("Here's the list of features available!\n> Restaurant description and information\n> Booking a reservation\n * Includes couple and party \n> Opening hours\n> Menu\n> Contact information\n - Telephone number\n - Email address\n - Address\n\nIs there anything that suits your interest?\n> "));
        responses.put("help", Arrays.asList("Here's the list of features available!\n> Restaurant description and information\n> Booking a reservation\n * Includes couple and party \n> Opening hours\n> Menu\n> Contact information\n - Telephone number\n - Email address\n - Address\n\nIs there anything that suits your interest?\n> "));
        
        // OPERATING HOURS 
        responses.put("hours", Arrays.asList("Kyoto's Finest's operating hours ranges from 11:00 AM to 9:30 PM (JST)\n\nIs there anything else you need?\n> "));
        responses.put("opening", Arrays.asList("Kyoto's Finest opens at 11:00 AM (JST)\n\nIs there anything else you need?\n> "));
        responses.put("closing", Arrays.asList("Kyoto's Finest opens at 11:00 AM (JST)\n\nIs there anything else you need?\n> "));
        
        // CONTACT
        responses.put("contact", Arrays.asList("Kyoto's Finest's contact information includes:\n - Telephone number: +81 0123 456 789\n - Email address: kyotosfinest@gmail.com\n - Address: 21 Saiinnakamizucho, Ukyo Ward, Kyoto, 615-0043, Japan\n\nIs there anything else you need?\n> "));
        responses.put("email", Arrays.asList("Kyoto's Finest's email address is: kyotosfinest@gmail.com\n\nIs there anything else you need?\n> "));
        responses.put("address", Arrays.asList("Kyoto's Finest's address is: 21 Saiinnakamizucho, Ukyo Ward, Kyoto, 615-0043, Japan\n\nIs there anything else you need?\n> "));
        responses.put("telephone", Arrays.asList("Kyoto's Finest's telephone number is: +81 0123 456 789\n\nIs there anything else you need?\n> "));
        responses.put("phone", Arrays.asList("Kyoto's Finest's telephone number is: +81 0123 456 789\n\nIs there anything else you need?\n> "));
        responses.put("number", Arrays.asList("Kyoto's Finest's telephone number is: +81 0123 456 789\n\nIs there anything else you need?\n> "));
        
        // MENU
        responses.put("menu", Arrays.asList("Here's our menu for appetizers\n =>  Edamame \n > INGREDIENTS \n  - sea salt \n  - sesame seed\n =>  vegetable Tempura \n > INGREDIENTS\n  - Japanese sweet potato \n  - Japanese or Chinese eggplant \n  - premade tempura wrapped\n =>  Potstickers\n > INGREDIENTS \n  - ground pork \n  - water chestnuts \n  - baby bok choy \n  - eggs\n =>  Agedashi tofu\n > INGREDIENTS \n  - Medium-Firm Tofu \n  - Corn Starch \n  - grated Daikon \n  - Bonito Flakes\n\nHere's our menu for sushi rollstizers\n =>  Philadelphia \n > INGREDIENTS \n  - Fresh salmon \n  - Cream cheese \n  - Avocado\n =>  Negi-hama \n > INGREDIENTS \n  - Yellowtail \n  - Scallions \n  - Seasame seed\n =>  Crunchy Roll \n > INGREDIENTS \n  - Crab \n  - Cucumber \n  - Avocado \n  - Red tuna \n  - Salmon \n  - White tuna \n  - Tempura flake \n  - Masago\n =>  Green Dragon \n > INGREDIENTS \n  - Eel \n  - cucumber \n  - crab \n  - mixed salad \n  - avocado\n\nHere's our menu for noodles \n => Ramen \n > INGREDIENTS \n  - Pork belly \n  - Ramen noodles \n  - Soft-boiled egg \n  - Miso broth \n  - Scallions \n => Udon \n > INGREDIENTS \n  - Udon noodles \n  - Tempura shrimp \n  - Dashi broth \n  - Scallions \n  - Pickled ginger \n => Soba \n > INGREDIENTS \n  - Soba noodles \n  - Buckwheat flour \n  - Soy sauce \n  - Wasabi \n  - Seaweed\n\nIs there anything else you need? \n> "));
        responses.put("cuisine", Arrays.asList("Here's our menu for appetizers\n =>  Edamame \n > INGREDIENTS \n  - sea salt \n  - sesame seed\n =>  vegetable Tempura \n > INGREDIENTS\n  - Japanese sweet potato \n  - Japanese or Chinese eggplant \n  - premade tempura wrapped\n =>  Potstickers\n > INGREDIENTS \n  - ground pork \n  - water chestnuts \n  - baby bok choy \n  - eggs\n =>  Agedashi tofu\n > INGREDIENTS \n  - Medium-Firm Tofu \n  - Corn Starch \n  - grated Daikon \n  - Bonito Flakes\n\nHere's our menu for sushi rollstizers\n =>  Philadelphia \n > INGREDIENTS \n  - Fresh salmon \n  - Cream cheese \n  - Avocado\n =>  Negi-hama \n > INGREDIENTS \n  - Yellowtail \n  - Scallions \n  - Seasame seed\n =>  Crunchy Roll \n > INGREDIENTS \n  - Crab \n  - Cucumber \n  - Avocado \n  - Red tuna \n  - Salmon \n  - White tuna \n  - Tempura flake \n  - Masago\n =>  Green Dragon \n > INGREDIENTS \n  - Eel \n  - cucumber \n  - crab \n  - mixed salad \n  - avocado\n\nHere's our menu for noodles \n => Ramen \n > INGREDIENTS \n  - Pork belly \n  - Ramen noodles \n  - Soft-boiled egg \n  - Miso broth \n  - Scallions \n => Udon \n > INGREDIENTS \n  - Udon noodles \n  - Tempura shrimp \n  - Dashi broth \n  - Scallions \n  - Pickled ginger \n => Soba \n > INGREDIENTS \n  - Soba noodles \n  - Buckwheat flour \n  - Soy sauce \n  - Wasabi \n  - Seaweed\n\nIs there anything else you need? \n> "));
        responses.put("food", Arrays.asList("Here's our menu for appetizers\n =>  Edamame \n > INGREDIENTS \n  - sea salt \n  - sesame seed\n =>  vegetable Tempura \n > INGREDIENTS\n  - Japanese sweet potato \n  - Japanese or Chinese eggplant \n  - premade tempura wrapped\n =>  Potstickers\n > INGREDIENTS \n  - ground pork \n  - water chestnuts \n  - baby bok choy \n  - eggs\n =>  Agedashi tofu\n > INGREDIENTS \n  - Medium-Firm Tofu \n  - Corn Starch \n  - grated Daikon \n  - Bonito Flakes\n\nHere's our menu for sushi rollstizers\n =>  Philadelphia \n > INGREDIENTS \n  - Fresh salmon \n  - Cream cheese \n  - Avocado\n =>  Negi-hama \n > INGREDIENTS \n  - Yellowtail \n  - Scallions \n  - Seasame seed\n =>  Crunchy Roll \n > INGREDIENTS \n  - Crab \n  - Cucumber \n  - Avocado \n  - Red tuna \n  - Salmon \n  - White tuna \n  - Tempura flake \n  - Masago\n =>  Green Dragon \n > INGREDIENTS \n  - Eel \n  - cucumber \n  - crab \n  - mixed salad \n  - avocado\n\nHere's our menu for noodles \n => Ramen \n > INGREDIENTS \n  - Pork belly \n  - Ramen noodles \n  - Soft-boiled egg \n  - Miso broth \n  - Scallions \n => Udon \n > INGREDIENTS \n  - Udon noodles \n  - Tempura shrimp \n  - Dashi broth \n  - Scallions \n  - Pickled ginger \n => Soba \n > INGREDIENTS \n  - Soba noodles \n  - Buckwheat flour \n  - Soy sauce \n  - Wasabi \n  - Seaweed\n\nIs there anything else you need? \n> "));
        responses.put("tariff", Arrays.asList("Here's our menu for appetizers\n =>  Edamame \n > INGREDIENTS \n  - sea salt \n  - sesame seed\n =>  vegetable Tempura \n > INGREDIENTS\n  - Japanese sweet potato \n  - Japanese or Chinese eggplant \n  - premade tempura wrapped\n =>  Potstickers\n > INGREDIENTS \n  - ground pork \n  - water chestnuts \n  - baby bok choy \n  - eggs\n =>  Agedashi tofu\n > INGREDIENTS \n  - Medium-Firm Tofu \n  - Corn Starch \n  - grated Daikon \n  - Bonito Flakes\n\nHere's our menu for sushi rollstizers\n =>  Philadelphia \n > INGREDIENTS \n  - Fresh salmon \n  - Cream cheese \n  - Avocado\n =>  Negi-hama \n > INGREDIENTS \n  - Yellowtail \n  - Scallions \n  - Seasame seed\n =>  Crunchy Roll \n > INGREDIENTS \n  - Crab \n  - Cucumber \n  - Avocado \n  - Red tuna \n  - Salmon \n  - White tuna \n  - Tempura flake \n  - Masago\n =>  Green Dragon \n > INGREDIENTS \n  - Eel \n  - cucumber \n  - crab \n  - mixed salad \n  - avocado\n\nHere's our menu for noodles \n => Ramen \n > INGREDIENTS \n  - Pork belly \n  - Ramen noodles \n  - Soft-boiled egg \n  - Miso broth \n  - Scallions \n => Udon \n > INGREDIENTS \n  - Udon noodles \n  - Tempura shrimp \n  - Dashi broth \n  - Scallions \n  - Pickled ginger \n => Soba \n > INGREDIENTS \n  - Soba noodles \n  - Buckwheat flour \n  - Soy sauce \n  - Wasabi \n  - Seaweed\n\nIs there anything else you need? \n> "));
        responses.put("meals", Arrays.asList("Here's our menu for appetizers\n =>  Edamame \n > INGREDIENTS \n  - sea salt \n  - sesame seed\n =>  vegetable Tempura \n > INGREDIENTS\n  - Japanese sweet potato \n  - Japanese or Chinese eggplant \n  - premade tempura wrapped\n =>  Potstickers\n > INGREDIENTS \n  - ground pork \n  - water chestnuts \n  - baby bok choy \n  - eggs\n =>  Agedashi tofu\n > INGREDIENTS \n  - Medium-Firm Tofu \n  - Corn Starch \n  - grated Daikon \n  - Bonito Flakes\n\nHere's our menu for sushi rollstizers\n =>  Philadelphia \n > INGREDIENTS \n  - Fresh salmon \n  - Cream cheese \n  - Avocado\n =>  Negi-hama \n > INGREDIENTS \n  - Yellowtail \n  - Scallions \n  - Seasame seed\n =>  Crunchy Roll \n > INGREDIENTS \n  - Crab \n  - Cucumber \n  - Avocado \n  - Red tuna \n  - Salmon \n  - White tuna \n  - Tempura flake \n  - Masago\n =>  Green Dragon \n > INGREDIENTS \n  - Eel \n  - cucumber \n  - crab \n  - mixed salad \n  - avocado\n\nHere's our menu for noodles \n => Ramen \n > INGREDIENTS \n  - Pork belly \n  - Ramen noodles \n  - Soft-boiled egg \n  - Miso broth \n  - Scallions \n => Udon \n > INGREDIENTS \n  - Udon noodles \n  - Tempura shrimp \n  - Dashi broth \n  - Scallions \n  - Pickled ginger \n => Soba \n > INGREDIENTS \n  - Soba noodles \n  - Buckwheat flour \n  - Soy sauce \n  - Wasabi \n  - Seaweed\n\nIs there anything else you need? \n> "));
        responses.put("dishes", Arrays.asList("Here's our menu for appetizers\n =>  Edamame \n > INGREDIENTS \n  - sea salt \n  - sesame seed\n =>  vegetable Tempura \n > INGREDIENTS\n  - Japanese sweet potato \n  - Japanese or Chinese eggplant \n  - premade tempura wrapped\n =>  Potstickers\n > INGREDIENTS \n  - ground pork \n  - water chestnuts \n  - baby bok choy \n  - eggs\n =>  Agedashi tofu\n > INGREDIENTS \n  - Medium-Firm Tofu \n  - Corn Starch \n  - grated Daikon \n  - Bonito Flakes\n\nHere's our menu for sushi rollstizers\n =>  Philadelphia \n > INGREDIENTS \n  - Fresh salmon \n  - Cream cheese \n  - Avocado\n =>  Negi-hama \n > INGREDIENTS \n  - Yellowtail \n  - Scallions \n  - Seasame seed\n =>  Crunchy Roll \n > INGREDIENTS \n  - Crab \n  - Cucumber \n  - Avocado \n  - Red tuna \n  - Salmon \n  - White tuna \n  - Tempura flake \n  - Masago\n =>  Green Dragon \n > INGREDIENTS \n  - Eel \n  - cucumber \n  - crab \n  - mixed salad \n  - avocado\n\nHere's our menu for noodles \n => Ramen \n > INGREDIENTS \n  - Pork belly \n  - Ramen noodles \n  - Soft-boiled egg \n  - Miso broth \n  - Scallions \n => Udon \n > INGREDIENTS \n  - Udon noodles \n  - Tempura shrimp \n  - Dashi broth \n  - Scallions \n  - Pickled ginger \n => Soba \n > INGREDIENTS \n  - Soba noodles \n  - Buckwheat flour \n  - Soy sauce \n  - Wasabi \n  - Seaweed\n\nIs there anything else you need? \n> "));

        // RESERVATIONS
        reservations.put("reserve", Arrays.asList("Sure thing {username}! Let me ask you something first though...\n", "No problem {username}! Let me ask you something first though...\n"));
        reservations.put("reservation", Arrays.asList("Sure thing {username}! Let me ask you something first though...\n", "No problem {username}! Let me ask you something first though...\n"));
        
        // TABLE PREFERENCE 
        tableCoupleReservation.put("couple", Arrays.asList("Sure thing! Any preferences for your seats?\n", "Of course! Do you have any seating preferences?\n"));
        tablePartyReservation.put("party", Arrays.asList("How many people are attending?\n", "How many people are you reserving for?\n"));
        
        //tableCoupleReservationPref

        // TABLE PREFERENCE
        tablePreference.add("window");
        tablePreference.add("windowed");
        tablePreference.add("aisle");
        tablePreference.add("corner");
        tablePreference.add("booth");
        tablePreference.add("near entrance");
        tablePreference.add("quiet area");
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }
    
    public String getBotMessage(int number) {
        return botMessage[number];
    }

    public String[] getResponsesContent(){
        return responses.keySet().toArray(new String[0]);
    }

    public String[] getReservationsContent(){
        return reservations.keySet().toArray(new String[0]);
    }

    public String[] getYesResponsesContent(){
        return yesResponses.toArray(new String[0]);
    }

    public String[] getNoResponsesContent(){
        return noResponses.toArray(new String[0]);
    }

    public String[] getHelpResponsesContent(){
        return helpResponses.toArray(new String[0]);
    }


    public String[] getTableCoupleReservationContent(){
        return tableCoupleReservation.keySet().toArray(new String[0]);
    }

    public String[] getCoupleTablePreferenceContent(){
        return tablePreference.toArray(new String[0]);
    }

    public String[] getTablePartyReservationContent(){
        return tablePartyReservation.keySet().toArray(new String[0]);
    }

    public void setPartyAmount(int amount){
        this.partyAmount = amount;
    }

    public int getPartyAmount(){
        return partyAmount;
    }

    public String getDateAndTime(){
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime){
        this.dateAndTime = dateAndTime;
    }

    public void setSpecialRequest(String specialRequests){
        this.specialRequests = specialRequests;
    }
    
    public String getSpecialRequest(){
        return specialRequests;
    }

    public String getCoupleTablePreference(){
        return tablePreferenceString;
    }

    public String getResponseStart(String userResponse) {
        for (String chatContent : responses.keySet()){
            if (userResponse.toLowerCase().contains(chatContent)) {
                    List<String> chat = responses.get(chatContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size())).replace("{username}", username);
                }
            }
            /* 
        for (String chatContent : reservations.keySet()){
            if (userResponse.toLowerCase().contains(chatContent)) {
                    List<String> chat = reservations.get(chatContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size())).replace("{username}", username);
                }
            }
            */    
        return botMessage[0];
    }

    public String getReservationResponse(String userResponse){
        for (String chatReservationContent : reservations.keySet()){
            if (userResponse.toLowerCase().contains(chatReservationContent)) {
                    List<String> chat = reservations.get(chatReservationContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size())).replace("{username}", username);
                }
            }  
        return botMessage[0];
    }

    public String getTableCoupleReseravationResponse(String userResponse){
        for (String chatTableCoupleContent : tableCoupleReservation.keySet()){
            if (userResponse.toLowerCase().contains(chatTableCoupleContent)) {
                    List<String> chat = tableCoupleReservation.get(chatTableCoupleContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }  
        return botMessage[0];
    }

    public void setCoupleTablePreference(String userRespose){
        for (String preferenceContent : tablePreference){
            if(userRespose.toLowerCase().contains(preferenceContent)){
                this.tablePreferenceString = userRespose;
            }
        }
    }

    public String getTablePartyReseravationResponse(String userResponse){
        for (String chatTablePartyContent : tablePartyReservation.keySet()){
            if (userResponse.toLowerCase().contains(chatTablePartyContent)) {
                    List<String> chat = tablePartyReservation.get(chatTablePartyContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }  
        return botMessage[0];
    }

    public String foodRandomizer(){
        String[] foodArray = randomSuggestions.toArray(new String[0]);
        Random rng = new Random();
        return "Here are our suggestions for you!\n" + foodArray[rng.nextInt(foodArray.length)];
    }

    public String tableRandomizer(){
        String[] tableArray = tablePreference.toArray(new String[0]);
        Random rng = new Random();
        return tableArray[rng.nextInt(tableArray.length)];
    }
}