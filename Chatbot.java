package FinalsProject;

import java.util.Scanner;

public class Chatbot extends ChatbotData implements Runnable {

    public void runChatbot() {
        Chatbot chatbot = new Chatbot();
        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.print(chatbot.getResponse(userInput.nextLine()));
        }
    }

    public void run() {
        try {
            Thread.sleep(50);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
