package com.example.repostory.impl;

import com.example.model.Product;
import com.example.repostory.IProductRepostory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.repostory.impl.ConectionUtil.sessionFactory;

@Repository
public class ProductRepostory implements IProductRepostory {


    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList = null;
        try {
            session = sessionFactory.openSession();
            productList = session.createQuery("FROM Product").getResultList();
        }finally {
            if (session != null){
                session.close();
            }
        }
        return productList;
    }

    @Override
    public void save(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
        Session session=null;
        Product product=null;
        try{
            session = ConectionUtil.sessionFactory.openSession();
            product= (Product) session.createQuery("from Product p where id =:idx").setParameter("idx",id).getSingleResult();

        }finally {
            if (session!=null){
                session.close();
            }
        }
        return product;
    }

    @Override
    public void update(int id, Product product) {
        Session session=null;
        Transaction transaction=null;
        try{
            session= ConectionUtil.sessionFactory.openSession();
            transaction=session.beginTransaction();
            session.merge(product);
            transaction.commit();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        Session session=null;
        Transaction transaction=null;
        Product product=null;
        try{
            session=ConectionUtil.sessionFactory.openSession();
            transaction=session.beginTransaction();
            product = (Product) session.createQuery("from Product p where id =:idx").setParameter("idx",id).getSingleResult();
            session.remove(product);
            transaction.commit();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList=null;
        Session session=null;
        try{
            session = ConectionUtil.sessionFactory.openSession();
            productList = session.createQuery("from Product p where p.name like:searchName ").setParameter("searchName",'%'+name+'%').getResultList();
        }finally {
            if (session!=null){
                session.close();
            }
        }
        return productList;
    }

}
