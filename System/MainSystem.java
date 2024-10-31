package FinalsProject.System;

import java.util.Scanner;

import FinalsProject.Chatbot.*;

public class MainSystem {
    protected void initializeSystem() {
        Chatbot chatbot = new Chatbot();
        Scanner userInput = new Scanner(System.in);
        System.out.print(chatbot.getResponse(userInput.nextLine()));
    }

    protected void getUserInput() {

    }
}
