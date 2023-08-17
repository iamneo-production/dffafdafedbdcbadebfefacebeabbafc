package com.examly.springapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
//@ComponentScan("com.examly")
public class SpringappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringappApplication.class, args);

		CricketerService cricketerService = new CricketerService();
		
		ArrayList<Cricketer> cricketersList = new ArrayList<>();

        cricketersList.add(new Cricketer("Virat Kohli", 32, "India"));
        cricketersList.add(new Cricketer("Steve Smith", 31, "Australia"));
        cricketersList.add(new Cricketer("Kane Williamson", 35, "New Zealand"));
        cricketersList.add(new Cricketer("MS Dhoni", 30, "India"));


        // Add more cricketers as needed

        // Sort by name using Comparable
        Collections.sort(cricketersList);
        
       // For JDBC CONNECTION TO SAVE DATA IN DB
       for(Cricketer c: cricketersList)
       {
    	   cricketerService.addCricketer(c);
       }

        // Print the cricketers sorted by name
        System.out.println("Cricketers sorted by name:");
        for (Cricketer cricketer : cricketersList) {
            System.out.println("Name: " + cricketer.getName() +
                    ", Age: " + cricketer.getAge() +
                    ", Country: " + cricketer.getCountry());
        }

        // Sort by age using Comparator
        Collections.sort(cricketersList, new CricketerAgeComparator());

       
        
        // Print the cricketers sorted by age
        System.out.println("Cricketers sorted by age:");
        for (Cricketer cricketer : cricketersList) {
            System.out.println("Name: " + cricketer.getName() +
                    ", Age: " + cricketer.getAge() +
                    ", Country: " + cricketer.getCountry());
        }
        
        // For JDBC CONNECTION TO GET DATA FROM DB
        System.out.println("Display the Cricketers Deatails From DB");
        List <Cricketer> cricketerListDB = cricketerService.getAllCricketer();
        
        for (Cricketer cricketer : cricketerListDB) {
            System.out.println("Name: " + cricketer.getName() +
                    ", Age: " + cricketer.getAge() +
                    ", Country: " + cricketer.getCountry());
        }
        
        
	}

    // @GetMapping("/Welcome")
    // public String helloSpring(){
    //     System.out.println("Welcome to Springapp");
    //     return "Welcome to Springapp";
    // }

}
