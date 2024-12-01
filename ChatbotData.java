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
    }

    public String getResponse(String userResponse) {
        return responses.getOrDefault(userResponse.toLowerCase().trim(), "I did not understand what you said.\nCan you please repeat that?");
    }
}
