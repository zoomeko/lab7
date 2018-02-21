# Lab 7 Inheritance, Abstract Classes

## Problem 1: Insect/Bee/Butterfly Abstract Classes

*Note that the Autograder is looking for exact variable/method names.*
*Note that the Autograder can't grade every aspect of these programs. A portion of your grade will be calculated when the instructor has reviewed your code.*


 **Make sure you add your new java file(s) to your git repository so they are uploaded to GitHub.
    Otherwise, I won't get all of your code, and your code won't compile for the autograder.**

 To add files to your repository, click 'Yes' when you create a new file and IntelliJ asks if you want to add it to git.
 If you did not add a file to git at this point, then right-click on that file and select git > add. Commit and push to GitHub and verify you see the file there.
 
 
The **Insect** class represents a generic insect species. You will specialize it with subclasses.

For the Insect class, please add 3 variables:

* A String called `name` to store the insect’s name. This variable should be protected.
* An int called `wingCount` to store the number of wings. This variable should be protected.
* A constant static int called `LEG_COUNT` to store the number of legs. Set it to 6. This constant should be public.

Add get and set methods for name and wingCount.

Think about: why are name and wingCount protected? Why is `LEG_COUNT` public, and why doesn't it need get and set methods? 

Insect objects need to create a String containing all data about that Insect. 

But, we don't know exactly what data will be stored for each specific Insect (a Bee's data will be different to a Butterfly's) so we can't write the code in this method yet. 

In Insect.java, add an **abstract** method called `speciesDataReport` like so,

```
abstract String speciesDataReport();
```

The subclasses you are about to create will have have the same `speciesDataReport` method, and these methods will have code in. 


The **Butterfly** class represents a butterfly species. It will be a subclass of Insect.

Configure Butterfly to extend Insect. 

Butterfly needs two new variables:

* A String called `wingColor` to store the butterfly’s wing color
* A String called `favoriteFlower` to store the butterfly’s favorite flower

Add get and set methods for the `wingColor` and `favoriteFlower` variables.

Think about: should you make these variables public, private, package-protected, or protected? 
Do you need get and set methods for name and wingCount in Butterfly? Why or why not? 

Also, add a constructor that takes 4 arguments in this order: the butterfly’s name, number of wings, wing color, and favorite flower.

Also, add a method to the Butterfly class called `speciesDataReport()`. This method should **override** the method with the same name in Insect. In this method, create and return a String containing all the info for a Butterfly object – its name, wing color, number of wings, number of legs, and favorite flower.


The **Bee** class represents a bee species.  It will be a subclass of Insect.

Bee needs to have two variables:

* A String called `bodyColor` for the bee’s body color
* A boolean called `makesHoney` for whether this species of bee makes honey (not all bees do)

Add get and set methods for `bodyColor` and `makesHoney`. Call the methods for `makesHoney` getMakesHoney and setMakesHoney. If you create the methods with IntelliJ the default names might be different. 
Think about: should you make these variables public, private, package-protected, or protected? 
Do you need get and set methods for name and wingCount in Bee? Why or why not? 

Add a constructor to set all the variables a Bee object, has in this order; name, number of wings, body color, makes honey.

And, Bee needs a method called `speciesDataReport()` that creates and returns a String containing all of the data for a Bee species.  This method should **override** the method with the same name in Insect. This method has the same name as the Butterfly method, but prints out the Bee information. As it prints out the information, it should print “This bee does make honey” or “this bee does not make honey” instead of “true” or “false”.


**Use the *Question_1_Insect_Manager* class to create some Insect, Bee and Butterfly objects.**


Test your Butterfly class by writing code in the Question_1_InsectManager class to create some test Butterfly object. Create two Butterfly objects, and then call the `speciesDataReport()` method on each to display all the data for each of the Butterfly objects.

Suggestions: A Monarch butterfly has 4 wings, its wings are orange and black, and likes a plant called milkweed.
A Common Yellow Swallowtail butterfly has 4 wings, its wings are yellow and black, and likes a plant called milk parsley.

Test your Bee class by writing code in the InsectManager class to create some test Bee object. Create two Bee objects, and then call the `speciesDataReport()` method on each to display all the data for each of the Bee objects.

Suggestions: name = “Honey bee”, color = “yellow and black”, makes honey = true,  number of wings = 4
Name= “Bumble bee”, color = “yellow, black and white”, makes honey = false, number of wings = 4

Last task: Create an ArrayList or LinkedList of Insects. Add all of your Bee and Butterfly objects to this list.

Use a for each loop to iterate over your list and call `speciesDataReport()` for each Insect, like this,

```
LinkedList<Insect> insects = new LinkedList();

//Create and add some Butterfly and Bee objects to the list

for (Insect i : insects) {

   String data = i.speciesDataReport();
   System.out.println(data);

}
```

For which object is the speciesDataReport being called for? Notice that the calls to `speciesDataReport` run the method of that name for the correct type of Insect. It will call the speciesDataReport from the Butterfly class if the Insect object in the list is a Butterfly, and it will call the speciesDataReport from the Bee class if the Insect object in the list is a Bee.


So what's happening with the *abstract* Insect class? Can you make an Insect object? 

The first line of the class is 

`public abstract class Insect { //class definition follows`

And it contains an abstract method, 

`public abstract void speciesDataReport();`

So if you wrote code like this,

`Insect i = new Insect();`

The compiler will report an error. An abstract class is one that you can't make objects from.  You can't make an Insect object from the Insect class. If you wrote `Insect i = new Insect();` in your program, verify that you see a compiler error, and then remove it. 

You can subclass an abstract class, (create classes that declare that they are a subclass of Insect) and the subclasses *can* be used to make objects. You can make Bee and Butterfly objects.  Note that a Bee object is also an Insect object. A Butterfly object is also an Insect object.
 
So why is this useful? It's helpful in a scenario where you have a general description class, but you know that you will be specializing it with more than one subclass; and only the subclasses will be doing tasks in your program. You can now specify required behavior in the (abstract) superclass and enforce that the subclasses will be able to provide this behavior too.

Insect doesn't want to implement speciesDataReport. It only represents general Insect objects, not a particular species - so it doesn't make sense to implement a real speciesDataReport.  It doesn't make much sense to make an Insect object. It's too vague to be useful in your program. But, it does make sense to create Bee or Butterfly objects. 

So, that's why we create an abstract speciesDataReport in Insect. “Abstract”, for the method, means that all Insect objects will have a method called speciesDataReport. But Insect doesn't want to define exactly what speciesDataReport does, and Insect doesn't need to implement it. 

So declare it as abstract in Insect, and the compiler will make sure all subclasses of Insect will create a speciesDataReport method. So, the compiler knows that every actual Insect object (in our case, Bee and Butterfly objects) will have to have an speciesDataReport. 

Abstract classes can define abstract methods. These are methods that you are requiring subclasses to have, but Insect doesn't need to decide how exactly it will be done. So anything that subclasses Insect will be required to have a `speciesDataReport` method, and each subclass can decide how it will be implemented - so each subclass can generate it's own specific speciesDataReport. 

This is useful if you need to guarantee that all subclasses need to have a particular behavior. We'll see some more examples of this when we look at GUIs.

Finally, imagine you don't have the `abstract void speciesDataReport();` line in Insect. Comment this line out, and then look at your loop in the InsectManager class. The compiler will be reporting an error. The loop is printing Bee and Butterfly data, and these classes both have speciesDataReport. So why does the compiler complain?

The Insect class doesn't have a method called speciesDataReport. While Bee and Butterfly both do, there is nothing to guarantee you won’t add an Insect object to this LinkedList, and Insect does not have this method.  So the compiler reports an error. Now uncomment this line `abstract void speciesDataReport();` and verify your code compiles and runs as expected. 

## Problem 2: HVAC, Inheritance

This is a prototype of a program for managing calls to a Heating, Ventilation and Air Conditioning repair/servicing company. Customers will call to set up servicing of their furnaces, air conditioning etc. units. This program keeps a list of pending calls, and allows the operator to add new calls, and store resolutions of calls that have been done. 

Run the program, and review the code.

There are a couple of new things:

* HVACInput.java uses a TreeMap; which behaves like a HashMap but keeps the keys in sorted order.
* An **enum** in the Furnace class. An enum is a collection of named constants; useful if you know a variable can only have one of a defined number of values - like types of furnace.

Please make these changes to the program:

a. Create a new class called WaterHeater. This represents a service call for a 
water heater. A water heater service call needs an **address**, **date service requested**, **description of the problem**, and the **age** of the water heater. The age varialbe should be an integer.

Resolved service calls for WaterHeater objects also need the **resolved date**, **description of the resolution**, and the **fee** charged to the customer. 

Note that many of these variables are already declared in ServiceCall, and a WaterHeater is a type of ServiceCall. So make WaterHeater should be a subclass of ServiceCall, and it will have the same variables that ServiceCall does. You'll need to add the WaterHeater-specific variables. 

b. The city that this HVAC company operates in requires that all service calls to water heaters have a mandatory $20 extra charge added. As this applies to all water heaters, add a private static variable called **cityFee** to your class to store this data. This should be a double.

c. Override that **toString** method in WaterHeater which returns a String containing all the static and instance variables for a WaterHeater. You should break down the fee into the service charge plus the $20 mandatory city fee.

d. Create a constructor to set the following variables, in this order: 
address, description of the problem, date reported, and the age of the water heater.

e. Add code to ServiceCallManager.java to test your new class. Make sure you can add service calls for water heaters to the list of today's ServiceCalls.

Note that the tests only check for the correct behavior of the WaterHeater object, and do not check any of the code you'll add to ServiceCallManager. This will be human-graded. 

## Question 3 Support Ticket manager 

This program is a prototype to manage IT support tickets for a company. Users would call or email a helpdesk to report computer problems, and this program keeps a record of all current problems. 

Tickets need to store a description of the problem, the date the issue was reported, and the user who reported it. 

The tickets are assigned a priority between 1-5.   
1 is the most urgent (e.g. all servers down)
5 is the least serious (e.g. missing mouse mat). 

Each ticket will have a unique integer ID. This is generated internally in the `Ticket` class. (We'll improve on this approach later in the semester when we cover databases.)

When a problem is fixed, the ticket is removed from the list of open tickets and added to a separate list of resolved tickets. A String describing the resolution is stored in the Ticket, and the date the ticket was resolved. 

For this question, you'll add some features to the program. 

Run and test the program with some example support tickets.

### Problem 1:

To think about: What is each class for? How are different responsibilities divided between the classes? 

If `TicketStore` used a database instead of an in-memory LinkedList, would `TicketUI` or `Question_3_Support_Ticket_Manager` have to do anything differently?

Make sure you understand the role of the static and instance `ticketID` and `ticketIdCounter` variables in the Ticket class. Why are a static variable, and an instance variable, declared in the class? How are these used to create ID values for each ticket?

### Problem 2:

Add a check to `TicketUI.getNewTicketInfo()` method, to ensure that the priority entered for a new ticket is between 1 and 5, inclusive. 

### Problem 3:

Add two new options to the menu: Delete by Description, and Search by Description.  You'll need to add some more int constants; and modify the `configureMenuOptions` method; and modify the switch statement in `manage`. You *don't* need to modify TicketUI.

Search By Description will search your ticket list and returns a new list of Tickets whose descriptions contain a certain String. For example, you might want to search for all tickets with the word “server” in the description.

The search should NOT be case sensitive.

Note that you should not modify the description when you save tickets. (So, the approach of saving all descriptions in lowercase or uppercase is not an acceptable solution for this problem.)
 
Implement `TicketStore.searchByDescription` to search the list and return all matching tickets. 

If `TicketStore.searchByDescription` doesn't find any matches, return an empty list.
If `TicketStore.searchByDescription` is called with an empty string, it should return an empty list.


Implement Question_3_Support_Ticket_Manager.searchByDescription. 
Use the `getSearchTerm` method in TicketUI to ask the user for the search string.
Use `TicketStore.searchByDescription` to search for matching tickets
Use the `displayTickets` method in TicketUI to display all matching tickets. 


### Problem 4:

Implement Delete by Description.  Follow the notes in `deleteTicketByDescription`.

### Problem 5:

Modify the program so you can save information about deleted tickets.

Your Ticket objects should be able to store another date; `resolvedDate`, the date the ticket was closed.
And, a String that documents why the ticket was closed – the fix or the resolution for the ticket. This String should be called `resolution`

When a ticket is deleted, it has been resolved in some way. Either a technician fixed the problem, or the user has figured out how to change their own screensaver, or it’s become a non-issue in some other way.

Now, when you delete a Ticket, your `deleteTicketById` method should ask for the resolution. It should store the resolution string , plus the current date in the correct Ticket. Now, remove this Ticket from the ticketQueue list.

A ResolvedTicketStore class is provided for you. It stores resolved tickets in a list, and provides an `addTicket` method. 

Create a ResolvedTicketStore object when the program starts. 

When tickets are resolved, add the resolved ticket to your ResolvedTicketStore. Add any other resolved tickets created in this session to the ResolvedTicketStore.

### Problem 6:

When the program is closed, all the data is lost.  Add the ability to save all data to file.  You can decide how to organize and structure the data in your files. 

Create a new class called `TicketFileIO` to manage the file input and output. Question_3_Support_Ticket_Manager will use methods in this class when the program starts and ends.  

Your `Question_3_Support_Ticket_Manager` should not do any file reading or writing. Delegate these tasks to your TicketFileIO class.

When the program closes, write out all the data about all open tickets to one file in the **TicketData** directory of your project.
Open tickets should be saved in a file called `open_tickets.txt`.

Write all data about tickets that have been resolved in this session, to a separate file.

Resolved tickets should go into one file, per day. This file should have today’s date in the filename and be in the format of `resolved_tickets_February_20_2014.txt`. If you run the program twice on one day, make sure you don't overwrite existing tickets in that day's file.  


Use a static method with this name, and arguments, 

```
    /* Write the list of tickets to the file with the name provided.
    The append argument specifies what to do if the file already exists. 
    If append=true, add data to the file
    If append=false, create a new file for this data.
    
    public static void saveTickets(LinkedList<Ticket> ticketList, String fileName, boolean append) {
        // TODO implement this method
    }
    
```
    

Here's some code to generate today's date as a string in the correct format,

    
```
SimpleDateFormat filenameFormatter = new SimpleDateFormat("MMMM_dd_yyyy");
Date date = new Date();   //defaults to today, right now
String s = filenameFormatter.format(date);
// s will be in the format "September_28_2017"
        
```

### Problem 7: 

When your program opens, it should look for a file called `TicketData/open_tickets.txt`. If this file exists, read in this file, and create Ticket objects, and store these in the TicketStore object list so the user can see all open tickets.

Use a static method with this name and arguments.

```
    /** Read a file, turn the data into Ticket objects, and return a list of Ticket objects */
    public static LinkedList<Ticket> loadTickets(String fileName) {
       // TODO implement this method and return a LinkedList of Tickets
    }
``` 
    
You don't need to read in the previous resolved tickets, you only need to read the open tickets from the  `open_tickets.txt` file

What happens to ticket IDs when the program is closed and opened? Make sure they don't reset to 1 when the user restarts the program. Every ticket created should always have a unique positive integer ID, (excluding 0) no matter how many times the program is used*. 

If you save the ticket ID in a file, make sure it's also in the the **TicketData** directory.

The tests will create a separate test directory and will read and write to this location, so if you keep all of your files in **TicketData** then the tests won't overwrite your files.

You will need to create a second constructor for creating a tickets when the ID is already known. Make sure you don't break your mechanism for ensuring unique IDs. 

*Actually, you'll only be able to create approx 2 billion ticket IDs with this approach. That should be enough for now, although perhaps something that will be revisited in a future version using a relational database. 


**Test Failures** There will be 3 intentional test failures in this code. The instructor will review and assign points for your file IO code and ticket resolution code. 