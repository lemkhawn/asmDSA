package Main;

import Entity.*;
import Interface.*;
import java.util.Scanner;
import Controller.*;

public class Main {
    public static void main(String[] args) {
        CSender sender = new CSender();
        CReceiver receiver = new CReceiver();
        CTransfer transfer = new CTransfer();
        // CHistory history = new CHistory();
        Queue message = new Queue(50);
        Stack memory = new Stack(50);

        System.out.println("MESSAGES SYSTEM");
        System.out.println("=========================================" + "\n");
        sender.send(message);
        transfer.transfer(message, memory);
        System.out.println("=========================================" + "\n");
        System.out.println("History message: ");
        receiver.read(memory);
        System.out.println("=========================================" + "\n");
    }
}
