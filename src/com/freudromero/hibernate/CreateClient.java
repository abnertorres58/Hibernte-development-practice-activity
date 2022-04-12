package com.freudromero.hibernate;

import com.freudromero.hibernate.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateClient {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .buildSessionFactory();

        // Create session

        Session session = factory.getCurrentSession();

        try {
            // Use the session to create a java object
            // Create a client object
            System.out.println("Creating a Client object...");
            Client tempClient = new Client("John", "Steward", "Microsoft");

            // Start transaction
            session.beginTransaction();

            // Save the current object
            System.out.println("Saving the client...");
            session.save(tempClient);

            // Commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!!!");
        } finally {
            factory.close();
        }
    }
}
