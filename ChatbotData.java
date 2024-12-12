
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ChatbotData {
    private final Set<String> yesResponses;
    private final Set<String> noResponses;
    private final Set<String> helpResponses;
    private final Set<String> tablePreference;
    private final HashMap<String, List<String>> responses;
    
    private String[] botMessage = new String[3];
    private String username;

    public ChatbotData() {
        yesResponses = new HashSet<>();
        noResponses = new HashSet<>();
        helpResponses = new HashSet<>();
        tablePreference = new HashSet<>();
        responses = new HashMap<>();
        
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

        // TABLE PREFERENCE
        tablePreference.add("window");
        tablePreference.add("windowed");
        tablePreference.add("aisle");
        tablePreference.add("corner");
        tablePreference.add("booth");
        tablePreference.add("near entrance");
        tablePreference.add("quiet area");

        
        // BASIC RESPONSES
        responses.put("hello", Arrays.asList("Hi {username}! I am BOT Mika. Please check our list by typing list for all of our available choices by typing list.\n> ", "Irasshaimase {username}! I am BOT Mika. Please check our list for all available choices by typing list.\n> "));
        responses.put("hi", Arrays.asList("Konnichiwa {username}! I am BOT Mika. Please check our list by typing list for all of our available choices by typing list.\n> ", "Hello {username}! I am BOT Mika. Please check our list for all available choices by typing list.\n> "));
        responses.put("list", Arrays.asList("Here's the list of features available!\n> Restaurant description and information\n> Booking a reservation\n * Includes couple and party \n> Opening hours\n> Menu\n> Contact information\n - Telephone number\n - Email address\n - Address\n\nIs there anything that suits your interest?\n> "));
        responses.put("features", Arrays.asList("Here's the list of features available!\n> Restaurant description and information\n> Booking a reservation\n * Includes couple and party \n> Opening hours\n> Menu\n> Contact information\n - Telephone number\n - Email address\n - Address\n\nIs there anything that suits your interest?\n> "));
        responses.put("help", Arrays.asList("Here's the list of features available!\n> Restaurant description and information\n> Booking a reservation\n * Includes couple and party \n> Opening hours\n> Menu\n> Contact information\n - Telephone number\n - Email address\n - Address\n\nIs there anything that suits your interest?\n> "));
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

    public String[] getYesResponsesContent(){
        return yesResponses.toArray(new String[0]);
    }

    public String[] getNoResponsesContent(){
        return noResponses.toArray(new String[0]);
    }

    public String[] getHelpResponsesContent(){
        return helpResponses.toArray(new String[0]);
    }

    public String[] getTablePreferenceContent(){
        return tablePreference.toArray(new String[0]);
    }

    public String[] getCoupleTablePreferenceContent(){
        return tablePreference.toArray(new String[0]);
    }

    public String tableRandomizer(){
        String[] tableArray = tablePreference.toArray(new String[0]);
        Random rng = new Random();
        return tableArray[rng.nextInt(tableArray.length)];
    }

    public String getResponse(String userResponse) {
        for (String chatContent : responses.keySet()){
            if (userResponse.toLowerCase().contains(chatContent)) {
                    List<String> chat = responses.get(chatContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size())).replace("{username}", username);
                }
            }
        return botMessage[0];
    }
}