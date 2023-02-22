package org.example;


import javax.mail.*;
import java.io.IOException;
import java.util.Properties;

public class MailReading {
    Properties properties = null;
    private Session session = null;
    private Store store = null;
    private Folder inbox = null;
    private String userName = "samplefakeaccount365@mail.ru";
    private String password = "AueCUkmdZ4HFh58krNQf";


    public boolean readMails(String recipient, String textMessage)  {

        boolean recipientAndTextMessageMatch = false;

        properties = new Properties();
        properties.setProperty("mail.store.protocol", "imaps");
        try {
            session = Session.getDefaultInstance(properties, null);
            store = session.getStore("imaps");
            store.connect("imap.mail.ru", userName, password);
            inbox = store.getFolder("INBOX");

            int unreadMailCount = inbox.getUnreadMessageCount();

            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();

            for (int i = messages.length; i > (messages.length - unreadMailCount); i--) {
                Message message = messages[i - 1];

                Address[] from = message.getFrom();
                String emailFrom = from[0].toString();
                String emailBody = org.jsoup.Jsoup.parse(message.getContent().toString()).text();

                if(emailFrom.equals(recipient) && emailBody.equals(textMessage) ) recipientAndTextMessageMatch=true; break;

            }

            inbox.close(false);
            store.close();
        } catch (NoSuchProviderException ex) {
            System.out.println("Problem with pop3");
            ex.printStackTrace();
        } catch (MessagingException ex) {
            System.out.println("Problem connection with message store");
            ex.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return recipientAndTextMessageMatch;

    }

}
