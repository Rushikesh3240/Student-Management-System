package com.borax9;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        do{
        Operations op=new Operations();
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Student Management System");
        System.out.println("Press '1' for fetching Information");
        System.out.println("Press '2' for delete information");
        System.out.println("Press '3' for Update Information");
        System.out.println("Press '4' for view all students");
        System.out.println("Press '5' for Exit");

        System.out.println("Chose option");
        choice=sc.nextInt();

        switch (choice) {
            case 1 -> op.addStudent();
            case 2 -> op.removeStudent();
            case 3 -> op.updateStudent();
            case 4 -> op.viewAllStudent();
            case 5 -> System.out.println("Thank you for use App");
            default -> System.out.println("Invalid option");
        }
        }
while (choice!=5);
    }
}
