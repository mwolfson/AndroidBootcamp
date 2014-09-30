#Android Bootcamp

This project is designed as a learning tool to help get started developing Android, by creating a simple App.

This project contains a series of checkpoints.  Each one is designed to build upon the last.  You will learn:

  - Building interfaces using XML
  - Defining business logic using Activities
  - Communicating between Activities
  - Packaging and running an Application
  - Using background processes
  - Calling Web-services
  
##Project Description

This project will build a simple expense tracker app.  

The feature-set of this app is as follows:

  - Generate an Expense Item (With a desription and amount)
  - Use a Web-service to perform a currency conversion
  - Share the Expense Item
  - Save the Expense Item to the file-system

##Task #1 - Import Project [Checkpoint 1]
###Key Concept
*Use the IDE to compile and run an Application*

The purpose of this task it to familiarize yourself with the developer tools.  For this task, you will import the project into your local IDE, and run the App on your device or an emulator.

The steps:
  1. Download and install the developer tools
  2. Import the Expense Tracker project into your workspace
  3. Create an emulator, or configure your device for development
  4. Run the app from your IDE

Resources:
  - [Building Your First App]
  - [Import existing Project]
  - [Using The Emulator]  
  
##Task #2 - Modify user interface, and change Application name [Checkpoint 2]
###Key Concept
*Learn how Android uses XML to define the user interface and String resources*

The purpose of this task is to understand how Android uses XML files (in the /res folder of the project) to abstract interface definition, and other resources (like String values). 

The steps:
  1. Change the title of the App from "Hello World" to "Expense Tracker"
  2. In the existing vertical LinearLayout, add the following Views
    * TextView
    * EditText
    * TextView
    * EditText
    * Button
  4. Remember to sure your text is not hard-coded and is abstracted to the strings.xml file

Resources:
  - [App Resources]
  - [Getting Started With XML Layouts]    
  
  
[Checkpoint 1]:https://github.com/mwolfson/AndroidBootcamp/commit/6c5c05126be74812988f361bd1f3ef5397ad6119
[Checkpoint 2]:https://github.com/mwolfson/AndroidBootcamp/commit/3de3cdd39201fb66ab9007122e673c56f0514e4f
[Building Your First App]:http://developer.android.com/training/basics/firstapp/index.html
[Import existing Project]:http://stackoverflow.com/questions/2231474/how-to-import-existing-android-project-into-eclipse
[Using The Emulator]:http://developer.android.com/tools/devices/emulator.html
[App Resources]:http://developer.android.com/guide/topics/resources/index.html
[Getting Started With XML Layouts]:http://code.tutsplus.com/tutorials/getting-started-with-xml-layouts--mobile-12749