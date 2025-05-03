package com.borax9;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Operations  {


        Student std = new Student();

    public void addStudent(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Student Id");
            int id = Integer.parseInt(br.readLine());
            std.setId(id);
            System.out.println("Enter Student name");
            String name = br.readLine();
            std.setName(name);
            System.out.println("Enter Student age");
            int age = Integer.parseInt(br.readLine());
            std.setAge(age);
            System.out.println("Enter Student course");
            String course = br.readLine();
            std.setCourse(course);

            Session session = HiberCon.getSf().openSession();
            Transaction t = session.beginTransaction();
            session.persist(std);
            t.commit();
            session.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void removeStudent() {
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter remove Student ID");
            int id = Integer.parseInt(br.readLine());
            Session session = HiberCon.getSf().openSession();
            Transaction t = session.beginTransaction();
            Student std = session.get(Student.class, id);
            if (std != null) {
                session.remove(std);
            }
            t.commit();
            session.close();

        }catch (Exception e){
            System.out.println(e);
        }

    }
    public void updateStudent(){
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter new id");
            int id= Integer.parseInt(br.readLine());
            std.setId(id);
            System.out.println("Enter new Name");
            String name=br.readLine();
            std.setName(name);
            System.out.println("Enter new Age");
            int age=Integer.parseInt(br.readLine());
            std.setAge(age);
            System.out.println("Enter new course");
            String course=br.readLine();
            std.setCourse(course);

            Session session=HiberCon.getSf().openSession();
            Transaction t=session.beginTransaction();

            session.merge(std);
            t.commit();
            session.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void viewAllStudent(){
        try{
            Session session=HiberCon.getSf().openSession();
            Transaction t=session.beginTransaction();
            List<Student>std=session.createQuery("From Student",Student.class).getResultList();

            for(Student st :std){
                System.out.println(st);
                t.commit();
                session.close();
            }


        }catch (Exception e){
            System.out.println(e);
        }
    }





}
