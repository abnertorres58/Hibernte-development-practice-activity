package com.freudromero.hibernate;

import com.freudromero.hibernate.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class FindEmployeesByCompany {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Start transaction
            session.beginTransaction();

            // Retrieve list of Clients based on a company
            System.out.println("Fetching Clients from Nasa");
            List<Client> theClients = session.createQuery("from Client c where c.company = 'Nasa'").getResultList();
            for(Client client : theClients) {
                System.out.println(client);
            }

            // Commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
        }
    }
}
