package com.cestar.dao;

import java.util.Scanner;

import org.bson.Document;

import com.cestar.model.Patient;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

/*
 * This class performs CRUD operations on the database
 */
public class PatientDao {
	Scanner sc = new Scanner(System.in);
	MongoClient client;
	MongoDatabase db;
	MongoCollection<Document> collection;

	/*
	 * Establish connection with MySql database
	 */
	public void createConnection() {
		client = new MongoClient("localhost", 27017);
		System.out.println("Connection established successfully");
		db = client.getDatabase("patientsrecords");
		collection = db.getCollection("patients");
	}

	public void read() {
		createConnection();
		// Retrieve all the documents from collection
		FindIterable<Document> iterDoc = collection.find();
		// Casting iterable document object to cursor
		MongoCursor<Document> cursor = iterDoc.cursor();

		// Header format for output table
		String format = "%-10s| %-20s| %-13s| %-15s| %-15s| %-10s|";
		System.out.println(String.format(format, "PatientId", "Name", "Contact", "Region", "Disease", "VisitDate"));
		System.out.println(
				"----------------------------------------------------------------------------------------------");

		// loop through the cursor
		while (cursor.hasNext()) {
			// retrieve the document
			Document doc = cursor.next();
			// retrieve specific fields from the document
			int patientId = doc.getInteger("patientid");
			String name = doc.getString("name");
			String contact = doc.getString("contact");
			String region = doc.getString("region");
			String disease = doc.getString("disease");
			String visitDate = doc.getString("visitdate");

			// display fetched record
			System.out.println(String.format(format, patientId + "", name + "", contact + "", region + "", disease + "",
					visitDate + ""));
		}
	}

	public void insert(Patient patient) {
		createConnection();
		Document doc = createDocument(patient);
		collection.insertOne(doc);
		System.out.println("Record inserted successfully");
	}

	/*
	 * method to delete a record from db table
	 */
	public void delete(int id_to_delete) {
		createConnection();
		collection.deleteOne(Filters.eq("patientid", id_to_delete));
		System.out.println("Record deleted successfully");
	}

	public void update(int id_to_update, int entry) {
		createConnection();

		switch (entry) {
		case 1: {
			System.out.println("Please enter new name of the patient");
			String new_name = sc.nextLine();
			collection.updateOne(Filters.eq("patientid", id_to_update), Updates.set("name", new_name));
			break;
		}
		case 2: {
			System.out.println("Please enter new contact of the patient");
			String new_contact = sc.nextLine();
			collection.updateOne(Filters.eq("patientid", id_to_update), Updates.set("contact", new_contact));
			break;
		}
		case 3: {
			System.out.println("Please enter new region of the patient");
			String new_region = sc.nextLine();
			collection.updateOne(Filters.eq("patientid", id_to_update), Updates.set("region", new_region));
			break;
		}
		case 4: {
			System.out.println("Please enter new disease of the patient");
			String new_disease = sc.nextLine();
			collection.updateOne(Filters.eq("patientid", id_to_update), Updates.set("disease", new_disease));
			break;
		}
		default: {
			System.out.println("Incorrect choice...please enter options from 1 to 4 only!!");
			break;
		}
		}
	}

	private Document createDocument(Patient patient) {
		// create a document
		Document doc = new Document();
		// add fields to document
		doc.append("patientid", patient.getPatientId());
		doc.append("name", patient.getName());
		doc.append("contact", patient.getContact());
		doc.append("region", patient.getRegion());
		doc.append("disease", patient.getDisease());
		doc.append("visitdate", patient.getVisitDate());
		return doc;
	}
}