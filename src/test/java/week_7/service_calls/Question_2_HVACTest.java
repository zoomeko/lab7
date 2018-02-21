package week_7.service_calls;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

/**
 * Created by clara on 8/4/17.
 */

public class Question_2_HVACTest {
    
    
    
/*

a. In your HVAC program, create a new class called WaterHeater.
This represents a service call for a water heater.

 A water heater service call needs

 - an address,
 - date service requested,
 - description of the problem, and the
 
 - age of the water heater. *    <-- this is the only field not present in Service Call
 
 -Resolved service calls also need the resolved date,
 -description of the resolution, and the
 - fee charged to the customer.
 
 b. The city requires that all service calls to water heaters have a mandatory $20
 extra charge added. As this applies to all water heaters, add a static variable called cityFee
 to your class to store this data.
 
 d. Create a constructor to set the following variables, in this order:
address, description of the problem, date reported, and the age of the water heater.


 c. Add a toString method to WaterHeater which returns a string containing all the static
 and instance variables for a WaterHeater. You should break down the fee into the service
 charge plus the $20 mandatory city fee.

d. Add code to ServiceCallManager.java to test your new class.
Make sure you can add service calls for water heaters to the list of todayServiceCalls.


*/

    @Test
    public void testWaterHeaterClassStructure() throws Exception {
        // wow much reflection
        
        // These all throw exceptions if the Class, Field, or Method does not exist.
        
        // Test for a new class called WaterHeater.
        Class waterHeater = Class.forName("week_7.service_calls.WaterHeater");
        
        // Subclass of ServiceCall
        assertEquals("WaterHeater should be a subclass of ServiceCall", ServiceCall.class, waterHeater.getSuperclass());
        
        try {
            Field age = waterHeater.getDeclaredField("age");  // Errors if the field is not present
        } catch (NoSuchFieldException e) {
            fail("Add an age field to the WaterHeater class");
        }
        
        Method toString = null;
        
        try {
            toString = waterHeater.getDeclaredMethod("toString");
            assertEquals("WaterHeater toString should return a String. Whatever calls this method will display the String.", toString.getReturnType(), String.class);
        } catch (NoSuchMethodException e) {
            fail("WaterHeater should define its own toString method. toString should not take any arguments.");
        }
        
        // cityFee, is static, a double, is private, and is set to 20
    
        try {
    
            Field cityFee = waterHeater.getDeclaredField("cityFee");
            assertTrue("cityFee variable should be private", Modifier.isPrivate(cityFee.getModifiers()));
            cityFee.setAccessible(true);  // enable private variable to be accessed
            assertTrue("cityFee variable should be static.", Modifier.isStatic((cityFee.getModifiers())));
            assertEquals("cityFee variable be a double, and the value should be set to 20.0", cityFee.get(null), 20.0);
        } catch (NoSuchElementException e){
            fail("Create a private static double variable called cityFee.");
        }
        
        // Constructor
        // address, description of the problem, date service requested, and the age of the water heater.
        try {
            Constructor constr = waterHeater.getDeclaredConstructor(String.class, String.class, Date.class, int.class);
            
            Date testDate = new SimpleDateFormat("dd-MM-yy").parse("14-12-2015");   //Dec 14, 2015
    
            String day_num = new SimpleDateFormat("d").format(testDate);   // e.g. for Sep 1, returns 1; for Sept 12, returns 12
            
            String month_num = new SimpleDateFormat("M").format(testDate);       // For September,returns 9, for December returns 12
            String month_str_abbr = new SimpleDateFormat("MMM").format(testDate);   // For September, returns Sep
            String month_str = new SimpleDateFormat("MMMM").format(testDate);         // For September, returns September
    
            String year_full = new SimpleDateFormat("yyyy").format(testDate);    // For 2015, returns 2015
            String year_abbr = new SimpleDateFormat("yy").format(testDate);       // For 2015, returns 15
            
    
            String testAddress = "1234 Test Street";
            String testProblem = "Not heating water";
            int testAge = 6;
    
            Field cityFee = waterHeater.getDeclaredField("cityFee");
            cityFee.setAccessible(true);  // enable private variable to be accessed
    
            cityFee.set(null, 42);  // Testing with a different value for cityFee
            Object o = constr.newInstance(testAddress, testProblem, testDate, testAge);
            String s = (String) toString.invoke(o);
    
            assertTrue("toString should include the address", s.contains(testAddress));
            assertTrue("toString should include the problem", s.contains(testProblem));
    
            assertTrue("toString should include the day of the month", s.contains(day_num) );  // Look for day of month
            assertTrue("toString should include the date", s.contains(month_num) ||  s.contains(month_str_abbr) || s.contains(month_str));  // Look for month as number or String ( 9 or September )
            assertTrue("toString should include the date", s.contains(year_full) || s.contains(year_abbr) );  // Look for day, month, year
    
            assertTrue("toString should include the age", s.contains(testAge + ""));
            assertTrue("toString should include the city fee", s.contains("42"));
    
    
        } catch (NoSuchMethodException e) {
            fail("Create a constructor in WaterHeater which takes these parameters: address, description of the " +
                    "problem, date service requested, and the age of the water heater. Parameters should be in this order.");
        }
        
    }


}