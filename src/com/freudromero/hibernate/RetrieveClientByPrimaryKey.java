package com.freudromero.hibernate;

import com.freudromero.hibernate.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class RetrieveClientByPrimaryKey {
    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {

            // Create 3 new Client objects
            System.out.println("Creating 3 new Client objects...");
            Client tempClient1 = new Client("Carl", "Sagan", "Nasa");
            Client tempClient2 = new Client("Nicola", "Tesla", "Tesla");
            Client tempClient3 = new Client("Abraham", "Doe", "Netflix");

            // Start transaction
            session.beginTransaction();

            // Save the client objects
            System.out.println("Saving the Clients");
            session.save(tempClient1);
            session.save(tempClient2);
            session.save(tempClient3);

            // Commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!!!");

            // Now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();


            // Retrieve a Client based on id: Primary Key
            System.out.println("\nGetting Client with Id = 3");
            List<Client> theClients = session.createQuery("from Client c where c.id = 3").getResultList();
            for(Client client : theClients) {
                System.out.println(client);
            }

            // Commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
