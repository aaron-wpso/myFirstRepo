package com.bucketlist.aaron.bucketlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The BucketListApplication allows users to create an online bucketlist for
 * things they want to achieve in life. This application allows for creating,
 * reading, updating, deleting both goals and categories within the bucketlist.
 * 
 * @author Aaron
 * @version 1.0
 * @since 2018-11-15
 */
@SpringBootApplication
public class BucketListApplication {

	/**
	 * This marks the entry point of the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BucketListApplication.class, args);
	}
}
