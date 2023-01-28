package com.bogdan_yanushkevich.javacore.rest.repository.impl;

import com.bogdan_yanushkevich.javacore.rest.model.File;
import com.bogdan_yanushkevich.javacore.rest.repository.FileRepositiry;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibFileRepositoryImpl implements FileRepositiry {

    private Transaction transaction;

    @Override
    public File create(File file) {
        try (Session session = HibernateSessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(file);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return file;
    }

    @Override
    public File update(File file) {
        try (Session session = HibernateSessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(file);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return file;
    }

    @Override
    public File getById(Integer id) {
        try (Session session = HibernateSessionFactory.openSession()) {
            return session.get(File.class, id);
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = HibernateSessionFactory.openSession()) {
            transaction = session.beginTransaction();
            File file = session.get(File.class, id);
            session.remove(file);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<File> getAll() {
        try (Session session = HibernateSessionFactory.openSession()) {
            return session.createQuery("FROM File", File.class).getResultList();
        }
    }
}
