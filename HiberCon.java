package com.borax9;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HiberCon {

    private static final SessionFactory sf;

    static {
        try{
            sf=new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex){
            throw  new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSf(){
        return sf;
    }



}
