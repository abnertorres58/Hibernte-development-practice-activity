package com.freudromero.hibernate;

import com.freudromero.hibernate.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteClient {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .buildSessionFactory();

        // Create session

        Session session = factory.getCurrentSession();

        try {
            int clientId = 1;


            // Now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Retrieve student based on the id: primary key
            System.out.println("\nGetting client with id: " + clientId);

            Client myClient = session.get(Client.class, clientId);

             // Delete the student
//            System.out.println("Deleting the student: " + myClient);
//            session.delete(myClient);

            // Delete client id=2
            System.out.println("Deleting client id=2");
            session.createQuery("delete from Client where id=2").executeUpdate();




            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

    }
}
