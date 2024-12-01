package FinalsProject.Chatbot;

import java.util.HashMap;

public class Chatbot {
    private HashMap<String, String> responses;
    
    public Chatbot() {
        responses = new HashMap<>();
        loadResponses();
    }

    private void loadResponses() {
        responses.put("hello", "Hi. I am BOT Mika, How may I help you?");
        responses.put("hi", "Hello. I am BOT Mika, How may I help you?");
    }

    public String getResponse(String userResponse) {
        return responses.getOrDefault(userResponse.toLowerCase().trim(), "I did not understand what you said.");
    }
}
