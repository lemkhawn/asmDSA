package Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Entity.Queue;
import Interface.ISend;

public class CSender implements ISend<Queue> {

    @Override
    public void send(Queue list) {
        boolean flag = true;
        String message = null;
        Scanner sc = new Scanner(System.in);
        while (flag) {
            System.out.println("Enter message to send: ");
            message = sc.nextLine();
            if (message.equalsIgnoreCase("exit") || message.length() > 12) {
                flag = false;
            } else {
                LocalDateTime date = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                String formatted = date.format(formatter);
                list.enqueue(formatted + ": " + message + "Send");
            }
        }

    }

}
