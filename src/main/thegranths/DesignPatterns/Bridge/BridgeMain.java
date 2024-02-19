package DesignPatterns.Bridge;

import java.util.Random;

public class BridgeMain {
    public static void main(String[] args) {
//        QRMessage qrMessage = new QRMessage(new SMS());
//        qrMessage.sendMessage();

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNum = rand.nextInt((10 - 2) + 1) + 2;
            NotificationSender sender;
            if (randomNum % 2 == 0) {
                sender = new Email();
            }else{
                sender = new SMS();
            }
            Notification message = new TextMessage(sender);
            message.sendMessage();
        }
//        NotificationSender sender = new Email();
//        Notification message = new TextMessage(sender);
//        message.sendMessage();
    }
}
