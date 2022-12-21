# MongoDb_CRUD
This project performs CRUD operations on the MongoDB database which consists of the details of patients.

Following are the files in the project -
1. Patient.java This is a model class that consists of patient details
2. UserMenu.java: Displays a list of options for the end user to choose from for CRUD operations on the database.
3. Controller.java: Based on the user's choice passed from UserMenu.java, the Controller class collects the user inputs for inserting/updating a record
4. PatientDao.java: Based on the user inputs passed from Controller.java, this class connects with the MongoDB database and performs CRUD operations
