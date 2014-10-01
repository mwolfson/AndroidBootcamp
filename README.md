#Android Bootcamp

This project is designed as a learning tool to help get started developing Android, by creating a simple App.

This project contains a series of checkpoints.  Each one is designed to build upon the last.  You will learn:

  - Building interfaces using XML
  - Defining business logic using Activities
  - Communicating between Activities
  - Packaging and running an Application
  - Using background processes
  - Calling Web-services
  
### Project Description

This project will build a simple expense tracker app.  

The feature-set of this app is as follows:

  - Generate an Expense Item (With a desription and amount)
  - Use a Web-service to perform a currency conversion
  - Share the Expense Item
  - Save the Expense Item to the file-system
  
### Resouces

There are a lot of great resources available for learning Android development.  Here are a few of the resources I used when I was starting (and still continue to use today).

  - [Android: Getting Started] - the official Google documentation
  - [StackOverflow] - your 'dumb' question has probably already been answered here
  - [Vogella Android Tutorials] - step-by-step tutorials about variety of Android subjects 
  - [XDA-Developers: Android] - very large community focused on open-source

##Task #1 - Import Project 
######[Checkpoint 1]
###Key Concept
*Use the IDE to compile and run an Application*

The purpose of this task it to familiarize yourself with the developer tools.  For this task, you will import the project into your local IDE, and run the App on your device or an emulator.

#####The steps:
  1. Download and install the developer tools
  2. Import the Expense Tracker project into your workspace
  3. Create an emulator, or configure your device for development
  4. Run the app from your IDE

#####Resources:
  - [Building Your First App]
  - [Import existing Project]
  - [Using The Emulator]  
  
##Task #2 - Modify user interface, and change Application name
######[Checkpoint 2]
###Key Concept
*Learn how Android uses XML to define the user interface and String resources*

The purpose of this task is to understand how Android uses XML files (in the /res folder of the project) to abstract interface definition, and other resources (like String values). 

#####The steps:
  1. Change the title of the App from "Hello World" to "Expense Tracker"
  2. In the existing vertical LinearLayout, add the following Views
    * TextView
    * EditText
    * TextView
    * EditText
    * Button
  4. Remember to sure the text in your labels is not hard-coded

#####Resources:
  - [App Resources]
  - [Getting Started With XML Layouts]    
  
##Task #3 - Additional Layout Concepts
######[Checkpoint 3]
###Key Concept
*Explore additional layout containers, and use XML attributes to fine tune the interface*

In this task, we will explore how to customize positioning and size of View components using XML attributes

#####The steps:
  1. Replace the existing LinearLayout with a RelativeLayout
  2. Change the 2 EditTexts to fill the screen (instead of currently expanding to size based on text input)
    * Expense Description
  	* Expense Amount
  
#####Resources:
  - [Android Layouts]
  - [Layout Attributes]
  
##Task #4 - Use Image Resources
######[Checkpoint 4]
###Key Concept
*Understand how Android handles image resources to support multiple screen sizes*

Because Android can support a large variety of devices (with many different screen resolutions), it is necessary to include multiple resolutions of any image you supply.  This will insure they scale correctly on all devices.

#####The steps:
  1. Add a red arrow to the 'Enter' button to make it more visually appealing (Hint: Use Android Tools to create Icon assets)
  2. Extra Credit: add validation to the 'Amount' edit feild to ensure only numbers are entered (Hint: there is an inputType attribute)
  
#####Resources:
  - [Supporting Multiple Screen Sizes]
  - [Android Asset Studio]
  
##Task #5 - Implement business logic with an Activity
######[Checkpoint 5]
###Key Concept
*Use business logic to interact with interface elements*

Android uses a Java Class (extending Activity) to execute business logic.  

#####The steps:
  1. Get a reference to the 'Expense Amount' EditText, and retreive the value it contains
  2. Output the current value in the EditText when the button is pressed
   
#####Resources:
  - [Activities]
  - [OnClick Tutorial]
  
##Task #6 - Using Activity Intents
######[Checkpoint 6]
###Key Concept
*Launch Activities using Intents*

Android uses the concept of an 'Intent' to call start a new Activity from another.

#####The steps:
  1. Create a new Activity that will allow the user to record more information about the expense they are recording (named DetailActivity)
    * You will need to create a new XML layout and an Activity class
    * Don't forget to add your Activity to the AndroidManifest.xml file
  2.  On the Main Activity, when the user presses the 'Enter Button' - launch the DetailActivity
  	* The Detail Activity will be an opportunity for the user to add more details (and eventually save the expense to the filesystem)
   
#####Resources:
  - [What is an Intent]
  - [Intent tutorial]
  
##Task #7 - The ActionBar
######[Checkpoint 7]
###Key Concept
*Understand how the ActionBar is used*

Android uses a control at the top of the screen for navigation, and user interactivity.  It is useful to add buttons, and other information.  There is a variety of functionality built into the ActionBar, that should be leveraged to ensure platform consistency

#####The steps:
  1. Add controls to the top of ActionBar of the DetailActivity
    * You will need to change the API level of our App, since the ActionBar was not supported until API 14
    * This will require new image assets for the menu icons (review Task #4)
  2.  Add 2 new menu items that will eventually be used to email or share an expense item
    * You will need a new menu.xml file and changes to the Activity
  3. Extra Credit: Implement the Email action
  4. Extra Credit: Enable the Share item
     
#####Resources:
  - [ActionBar Tutorial]
  - [Adding a Share Action]
  
##Task #8 - Passing data between Activities
######[Checkpoint 8]
###Key Concept
*Pass data between 2 Activities using Intent Extras*

It is frequently necessary to include relevant data when starting one Activity from another.  You can attach data to an Intent before sending it, which can be interpreted when the Activity starts.

#####The steps:
  1. Pass the current expense data from the MainActivity to the DetailsActivity 
  2. Display expense information on the DetailsActivity
    * Extra Credit: format the currency amount in readable format
     
#####Resources:
  - [Android Intent Usage]
  - [Sending Simple Data]
  
##Task #9 - Accessing data from a Web Service (in the background)
######[Checkpoint 9]
###Key Concept
*Accessing Web Services using AsyncTasks*

It is common to interact with Web resources to get data.  It is important to do this in the background, so the user doesn't experience pauses in the interface. This task will show how to access web resources off the UI thread.
 
#####The steps:
  1. Call a WebService to convert the expense value to a different currency 
    * Make sure to call the WebService in an AsyncTask (off the UI thread)
  2. Log the output from the Web Service
     
#####Resources:
  - [Connecting to the Network]
  - [What is AsyncTask]
  - [Calling WebService from Android]
  
##Task #10 - Change the Interface when the AsyncTask finishes
######[Checkpoint 10]
###Key Concept
*Understanding AsyncTask Life-cycle*

Because we performed the Web Service call off the UI thread, we need communicate back with the interface to notify the user that results have returned.
 
#####The steps:
  1. Place the value returned from the WebService on the DetailActivity
    * During the appropriate lifecycle method of the AsyncTask, access the View object, and set the value
     
#####Resources:
  - [AsyncTask]
  
  
[Checkpoint 1]:https://github.com/mwolfson/AndroidBootcamp/commit/6c5c05126be74812988f361bd1f3ef5397ad6119
[Checkpoint 2]:https://github.com/mwolfson/AndroidBootcamp/commit/3de3cdd39201fb66ab9007122e673c56f0514e4f
[Checkpoint 3]:https://github.com/mwolfson/AndroidBootcamp/commit/537c6036c62ae8cd0c41d83d1d780aa87747d346
[Checkpoint 4]:https://github.com/mwolfson/AndroidBootcamp/commit/f24978689749e4cfa23b2e4c517b18a958d7f160
[Checkpoint 5]:https://github.com/mwolfson/AndroidBootcamp/commit/6271512bc11ea204b1c81407d3f76dbac3707ad4
[Checkpoint 6]:https://github.com/mwolfson/AndroidBootcamp/commit/cb8080bd4b2069dcd317f52b16e5b0065de70ae7
[Checkpoint 7]:https://github.com/mwolfson/AndroidBootcamp/commit/ad67f27bd5e902c612d1ea2f812c03f279656f91
[Checkpoint 8]:https://github.com/mwolfson/AndroidBootcamp/commit/f73bb0138c49d26a4e33ac1b8f0f506292c6bf6c
[Checkpoint 9]:https://github.com/mwolfson/AndroidBootcamp/commit/13f65d7579844607136158ed3dfea32f5af800a8
[Checkpoint 10]:https://github.com/mwolfson/AndroidBootcamp/commit/c5f0fe50a94fb3ef33eeab4e8b20a94b76cbaf0a
[Building Your First App]:http://developer.android.com/training/basics/firstapp/index.html
[Import existing Project]:http://stackoverflow.com/questions/2231474/how-to-import-existing-android-project-into-eclipse
[Using The Emulator]:http://developer.android.com/tools/devices/emulator.html
[App Resources]:http://developer.android.com/guide/topics/resources/index.html
[Getting Started With XML Layouts]:http://code.tutsplus.com/tutorials/getting-started-with-xml-layouts--mobile-12749
[Android Layouts]:http://developer.android.com/guide/topics/ui/declaring-layout.html
[Layout Attributes]:http://developer.android.com/guide/topics/ui/declaring-layout.html#attributes
[Android Asset Studio]:http://romannurik.github.io/AndroidAssetStudio/
[Supporting Multiple Screen Sizes]:http://developer.android.com/training/multiscreen/screensizes.html
[Intent tutorial]:http://programmerguru.com/android-tutorial/android-intent-example/
[Activities]:http://developer.android.com/guide/components/activities.html
[OnClick Tutorial]:http://martin.cubeactive.com/android-onclicklitener-tutorial/
[What is an Intent]:http://stackoverflow.com/questions/6578051/what-is-intent-in-android
[ActionBar Tutorial]:http://www.vogella.com/tutorials/AndroidActionBar/article.html
[Adding a Share Action]:http://developer.android.com/training/sharing/shareaction.html
[Android Intent Usage]:http://www.codelearn.org/android-tutorial/android-intent
[Sending Simple Data]:http://developer.android.com/training/sharing/send.html
[Vogella Android Tutorials]:http://www.vogella.com/tutorials/android.html
[Android: Getting Started]:https://developer.android.com/training/index.html
[StackOverflow]:http://stackoverflow.com/questions/tagged/android
[XDA-Developers: Android]:http://www.xda-developers.com/android/want-to-learn-how-to-program-for-android-start-here/
[Connecting to the Network]:https://developer.android.com/training/basics/network-ops/connecting.html
[What is AsyncTask]:http://programmerguru.com/android-tutorial/what-is-asynctask-in-android/
[Calling WebService from Android]:http://vrsbrazil.wordpress.com/2013/02/07/calling-a-restful-web-service-from-an-android-application/
[AsyncTask]:http://developer.android.com/reference/android/os/AsyncTask.html