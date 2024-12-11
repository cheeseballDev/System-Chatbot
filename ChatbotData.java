
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ChatbotData {
    private final Set<String> yesResponses;
    private final Set<String> noResponses;
    private final HashMap<String, List<String>> responses;
    private final HashMap<String, List<String>> reservations;
    private final HashMap<String, List<String>> ifNewCustomerResponse;
    private final HashMap<String, List<String>> ifOldCustomerResponse;
    private final HashMap<String, List<String>> tableCoupleReservation;
    private final Set<String> tablePreference;
    private final HashMap<String, List<String>> tablePartyReservation;
    private int partyAmount;
    private String dateAndTime;
    private String specialRequests;
    private String tablePreferenceString;
    
    private String[] botMessage = new String[10];

    public ChatbotData() {
        yesResponses = new HashSet<>();
        noResponses = new HashSet<>();
        responses = new HashMap<>();
        reservations = new HashMap<>();
        ifNewCustomerResponse = new HashMap<>();
        ifOldCustomerResponse = new HashMap<>();
        tableCoupleReservation = new HashMap<>();
        tablePreference = new HashSet<>();
        tablePartyReservation = new HashMap<>();

        loadResponses();
        botMessage[0] = "I did not understand what you said. Can you please repeat that?\n> ";
        botMessage[1] = "Would you like a list of things I can assist you with?\n> ";
    }

    private void loadResponses() {
        yesResponses.add("yes");
        yesResponses.add("yeah");
        yesResponses.add("yuh");
        yesResponses.add("yep");
        yesResponses.add("y");
        yesResponses.add("sure");
        yesResponses.add("okay");
        yesResponses.add("ok");

        noResponses.add("no");
        noResponses.add("nah");
        noResponses.add("nope");
        noResponses.add("n");
        noResponses.add("never");

        responses.put("hello", Arrays.asList("Hi! I am BOT Mika. Please check our list by typing list for all of our available choices.\n> ", "Irasshaimase! I am BOT Mika. Please check our list for all available choices.\n> "));
        responses.put("hi", Arrays.asList("Konnichiwa! I am BOT Mika. Please check our list by typing list for all of our available choices.\n> ", "Hello! I am BOT Mika. Please check our list for all available choices.\n> "));
        responses.put("list", Arrays.asList("Here's the list of features available!\n> Restaurant description and information\n> Booking a reservation\n * Includes couple and party \n> Opening hours\n> Menu\n> Contact information\n - Telephone number\n - Email address\n - Address\n What else do you need?\n"));
        responses.put("features", Arrays.asList("Here's the list of features available!\n> Restaurant description and information\n> Booking a reservation\n * Includes couple and party \n> Opening hours\n> Menu\n> Contact information\n - Telephone number\n - Email address\n - Address"));

        reservations.put("reserve", Arrays.asList("Sure thing! Let me ask you something first though...", "Alrighty then! Let me ask you something first though..."));
        reservations.put("reservation", Arrays.asList("Sure thing! Let me ask you something first though...", "Alrighty then! Let me ask you something first though..."));
        
        ifNewCustomerResponse.put("yes", Arrays.asList("test", "test2"));
        ifOldCustomerResponse.put("no", Arrays.asList("I see... Glad you're still with us then!\nTable for a couple or for a party?\n", "I see... Glad you're still with us then! What is the purpose of your reservation?\n"));
        tableCoupleReservation.put("couple", Arrays.asList("Sure thing! Any preferences for your seats?\n", "Of course! Do you have any seating preferences?\n"));
        tablePreference.add("window");
        tablePreference.add("windowed");
        tablePreference.add("aisle");
        tablePreference.add("corner");
        tablePreference.add("booth");
        tablePreference.add("near entrance");
        tablePreference.add("quiet area");

        tablePartyReservation.put("party", Arrays.asList("How many poeple are attending?\n", "How many people are you reserving for?\n"));
        //tableCoupleReservationPref



        /*
         * add opening hours, operaitng hours, menu, address, list/features
         */
    }

    public String getBotMessage(int number) {
        return botMessage[number];
    }

    public String[] getResponsesContent(){
        return responses.keySet().toArray(new String[0]);
    }

    public String[] getReservationsContents(){
        return reservations.keySet().toArray(new String[0]);
    }

    public String[] getYesResponsesContents(){
        return yesResponses.toArray(new String[0]);
    }

    public String[] getNoResponsesContents(){
        return noResponses.toArray(new String[0]);
    }

    public String[] getIfNewCustomerResponseContents(){
        return ifNewCustomerResponse.keySet().toArray(new String[0]);
    }

    public String[] getIfOldCustomerResponseContents(){
        return ifOldCustomerResponse.keySet().toArray(new String[0]);
    }

    public String[] getTableCoupleReservationContents(){
        return tableCoupleReservation.keySet().toArray(new String[0]);
    }

    public String[] getCoupleTablePreferenceContents(){
        return tablePreference.toArray(new String[0]);
    }

    public String[] getTablePartyReservationContents(){
        return tablePartyReservation.keySet().toArray(new String[0]);
    }

    public void setPartyAmount(int amount){
        this.partyAmount = amount;
    }

    public int getPartyAmount(){
        return partyAmount;
    }

    public void setDateAndTime(String dateAndTime){
        this.dateAndTime = dateAndTime;
    }

    public String getDateAndTime(){
        return dateAndTime;
    }

    public void setSpecialRequests(String specialRequests){
        this.specialRequests = specialRequests;
    }
    
    public String getSpecialRequests(){
        return specialRequests;
    }

    public String getResponseStart(String userResponse) {
        for (String chatContent : responses.keySet()){
            if (userResponse.toLowerCase().contains(chatContent)) {
                    List<String> chat = responses.get(chatContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }
        for (String chatContent : reservations.keySet()){
            if (userResponse.toLowerCase().contains(chatContent)) {
                    List<String> chat = reservations.get(chatContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }
        //return responses.getOrDefault(userResponse.toLowerCase().trim(), "I did not understand what you said.\nCan you please repeat that?");
        // This if statement checks whether the user is struggling
        return botMessage[0];
    }

    public String getReservationResponse(String userResponse){
        for (String chatReservationContent : reservations.keySet()){
            if (userResponse.toLowerCase().contains(chatReservationContent)) {
                    List<String> chat = reservations.get(chatReservationContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }  
        return botMessage[0];
    }

    public String getIfNewCustomerResponse(String userResponse){
        for (String chatNewCustomerContent : ifNewCustomerResponse.keySet()){
            if (userResponse.toLowerCase().contains(chatNewCustomerContent)) {
                    List<String> chat = ifNewCustomerResponse.get(chatNewCustomerContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }  
        return botMessage[0];
    }

    public String getIfNotNewCustomerResponse(String userResponse){
        for (String chatNotNewCustomerContent : ifOldCustomerResponse.keySet()){
            if (userResponse.toLowerCase().contains(chatNotNewCustomerContent)) {
                    List<String> chat = ifOldCustomerResponse.get(chatNotNewCustomerContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
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

    public String getCoupleTablePreference(){
        return tablePreferenceString;
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


    
}