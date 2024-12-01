package FinalsProject;

import java.util.HashMap;

public class ChatbotData {
    private HashMap<String, String> responses;
    
    public ChatbotData() {
        responses = new HashMap<>();
        loadResponses();
    }

    private void loadResponses() {
        responses.put("hello", "Hi. I am BOT Mika, How may I help you?");
        responses.put("hi", "Hello. I am BOT Mika, How may I help you?");
        responses.put("hello", "Hi! I am BOT Mika, How may I help you?");
        responses.put("hi", "Hello! I am BOT Mika, How may I help you?");
        responses.put("hi", "Hello! I am BOT Mika, your personal dining assistant. How may I help you?");
        responses.put("hello", "hi! Craving for something delicious or would you like to book a reservation?");
        responses.put("hi", "hello! I am BOT Mika, your personal dining assistant. Would you like to order or book a reservation?");
        responses.put("hello", "hi! would you like to order or book a reservation?");

        //order
        responses.put("Amazing", "wonderful! We have lots to offer, here's our menu.");
        responses.put(" ", "What would you like to order?");

        //Reservation
        responses.put("Great", "Gladly, Is this your first time dining with us?");


        //yes
        responses.put(" ", "Welcome! We’re so excited to have you. Is this for a group gathering or a personal date?");

        //date
        responses.put("that's lovely", "That's great, Do you have any special preferences for seating, like a quiet corner or window view?");

        //group
        responses.put("Wonderful", "Sounds exciting, How many people will be joining you?");

        
        //no
        responses.put("Welcome back", "Welcome back! Are you reserving for a group gathering or a personal date this time?");

        //date
        responses.put("that's great ", "That's lovely, would you it be the usual seating or would like to change your preference for today?");
        responses.put(" ", "Do you have any special preferences for seating, like a quiet corner or window view?");

        //group
        responses.put("Wonderful", "Sounds exciting, How many people will be joining you?");
        
    }

    public String getResponse(String userResponse) {
        return responses.getOrDefault(userResponse.toLowerCase().trim(), "I did not understand what you said.\nCan you please repeat that?");
    }
}
