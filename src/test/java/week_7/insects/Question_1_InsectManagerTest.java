package week_7.insects;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;
import static test_utils.ReflectionUtils.hasFieldOfType;
import static test_utils.ReflectionUtils.hasGetSet;

/**
 * Created by clara on 8/5/17.
 */
public class Question_1_InsectManagerTest {
    
    // Verify Insect class has the correct fields (variables)
    
    @Test
    public void testInsectClassStructure() throws Exception {
        
        Class insectClass = Class.forName("week_7.insects.Insect");
        assertTrue("Insect class should have a name variable", hasFieldOfType(insectClass, "name", String.class));
        assertTrue("Insect class should have a wingCount variable", hasFieldOfType(insectClass, "wingCount", int.class));
        assertTrue("Insect class should have a LEG_COUNT variable", hasFieldOfType(insectClass, "LEG_COUNT", int.class));
        
        // Has getters and setters for name, wingCount?
        assertTrue("Add get and set methods for name", hasGetSet(insectClass, "name", String.class));
        assertTrue("Add get and set methods for wingCount", hasGetSet(insectClass, "wingCount", int.class));
        
        Field leg = insectClass.getDeclaredField("LEG_COUNT");
        
        // Is leg static and constant ?
        int modifiers = leg.getModifiers();
        
        assertTrue("LEG_COUNT should be static", Modifier.isStatic(modifiers));
        assertTrue("LEG_COUNT should be final (constant)", Modifier.isFinal(modifiers));
    
        // Is it set to 6?
        Object legs = leg.get(null);  // LEG_COUNT is static so argument is ignored. For an instance field, it will be the objects for which the field value should be read. EG Insect i = new Insect(); Field.get(i);
        assertTrue("LEG_COUNT should be an int", legs instanceof Integer);
        assertEquals("LEG_COUNT should be set to 6", 6, (int) legs);
        
        // speciesDataReport method exists, takes no arguments, and is abstract, and returns a String
        
        Method speciesData = insectClass.getDeclaredMethod("speciesDataReport");
        assertTrue("speciesDataReport should be declared abstract", Modifier.isAbstract(speciesData.getModifiers()));
        assertEquals("speciesDataReport should return a String", String.class, speciesData.getReturnType());
        
        
    }
    
    @Test
    public void testButterflyClassStructure() throws Exception {
        
        Class butterflyClass = Class.forName("week_7.insects.Butterfly");

        Butterfly testButterfly = null;
        
        //Correct constructor
        try {
            Constructor c = butterflyClass.getDeclaredConstructor(String.class, int.class, String.class, String.class);
            testButterfly = (Butterfly) c.newInstance("Monarch", 4, "Orange and Black", "Flowers");
    
        } catch (NoSuchMethodException ne) {
            fail("Butterfly should declare a constructor with 4 arguments in this order: name, wingCount, wingColor, favoriteFlower");
        }
    
        // Don't re-declare any variables from the Insect superclass
        assertFalse("Butterfly class should NOT declare a name variable", hasFieldOfType(butterflyClass, "name", String.class));
        assertFalse("Butterfly class should NOT declare a wingCount variable", hasFieldOfType(butterflyClass, "wingCount", int.class));
        assertFalse("Butterfly class should NOT declare a LEG_COUNT variable", hasFieldOfType(butterflyClass, "LEG_COUNT", int.class));
        
        // Check Butterfly is a subclass of Insect
        assertEquals("Butterfly should be a subclass of Insect", Insect.class, butterflyClass.getSuperclass());
        
        // Verify wingColor, favoriteFlower fields present
        assertTrue("Butterfly class should have a wingColor String variable", hasFieldOfType(butterflyClass, "wingColor", String.class));
        assertTrue("Butterfly class should have a favoriteFlower String variable", hasFieldOfType(butterflyClass, "favoriteFlower", String.class));
    
        // And they should be protected or private
        Field wing = butterflyClass.getDeclaredField("wingColor");
        assertTrue("Butterfly's wingColor should be private or protected", Modifier.isPrivate(wing.getModifiers()) || Modifier.isProtected(wing.getModifiers()));
    
        Field flower = butterflyClass.getDeclaredField("favoriteFlower");
        assertTrue("Butterfly's favoriteFlower should be private or protected", Modifier.isPrivate(flower.getModifiers()) || Modifier.isProtected(flower.getModifiers()));
    
    
        // Has getters and setters for wingColor, favoriteFlower?
        assertTrue("Add get and set methods for wingColor", hasGetSet(butterflyClass, "wingColor", String.class));
        assertTrue("Add get and set methods for favoriteFlower", hasGetSet(butterflyClass, "favoriteFlower", String.class));
        
        // speciesDataReport method exists, takes no arguments, and is NOT abstract, and returns a String
        Method speciesData = butterflyClass.getDeclaredMethod("speciesDataReport");
        assertFalse("speciesDataReport should NOT be declared abstract. Implement it for the Butterfly class", Modifier.isAbstract(speciesData.getModifiers()));
        assertEquals("speciesDataReport should return a String", String.class, speciesData.getReturnType());
        
        // Print correct data?
        String[] expectedData = {"Monarch", "4", "6", "Orange and Black", "Flowers"};
    
        String message = "Make sure speciesDataReport returns a String will all the required data about the Butterfly. Name, wing count, wing color, leg count, favorite flower.";
    
        String speciesDataString = (String) speciesData.invoke(testButterfly);
        for (String s : expectedData) {
            assertTrue(message, speciesDataString.contains(s));
        }
    
    }
    
    
    @Test
    public void testBeeClassStructure() throws Exception {
        
        Class beeClass = Class.forName("week_7.insects.Bee");
    
        Bee testBeeNoHoney = null;
        Bee testBeeMakesHoney = null;
    
        //Correct constructor
        try {
            Constructor c = beeClass.getDeclaredConstructor(String.class, int.class, String.class, boolean.class);
            testBeeNoHoney = (Bee) c.newInstance("Bumble", 4, "Stripy", false);
            testBeeMakesHoney = (Bee) c.newInstance("Buzzy", 4, "Yellow", true);
    
        } catch (NoSuchMethodException ne) {
            fail("Bee should declare a constructor with 4 arguments, in this order: name, wingCount, bodyColor, makesHoney");
        } catch (Exception e) {
            System.out.println("Error creating Bee object with constructor");
            fail(e.getMessage());
        }
        
        // Don't re-declare any variables from the Insect superclass
        assertFalse("Bee class should NOT declare a name variable", hasFieldOfType(beeClass, "name", String.class));
        assertFalse("Bee class should NOT declare a wingCount variable", hasFieldOfType(beeClass, "wingCount", int.class));
        assertFalse("Bee class should NOT declare a LEG_COUNT variable", hasFieldOfType(beeClass, "LEG_COUNT", int.class));
        
        // Check Bee is a subclass of Insect
        
        assertEquals("Bee should be a subclass of Insect", Insect.class, beeClass.getSuperclass());
        
        // Verify bodyColor, makesHoney fields present
        assertTrue("Bee class should have a makesHoney boolean variable", hasFieldOfType(beeClass, "makesHoney", boolean.class));
        assertTrue("Bee class should have a bodyColor String variable", hasFieldOfType(beeClass, "bodyColor", String.class));
        
        // Has getters and setters for bodyColor, makesHoney?
        assertTrue("Add get and set methods for bodyColor", hasGetSet(beeClass, "bodyColor", String.class));
        assertTrue("Add get and set methods for makesHoney", hasGetSet(beeClass, "makesHoney", boolean.class));
    
    
        // And they should be protected or private
        Field wing = beeClass.getDeclaredField("bodyColor");
        assertTrue("Bee's bodyColor should be private or protected", Modifier.isPrivate(wing.getModifiers()) || Modifier.isProtected(wing.getModifiers()));
    
        Field flower = beeClass.getDeclaredField("makesHoney");
        assertTrue("Bee's makesHoney should be private or protected", Modifier.isPrivate(flower.getModifiers()) || Modifier.isProtected(flower.getModifiers()));
    
    
        // speciesDataReport method exists, takes no arguments, and is NOT abstract, and returns a String
        
        Method speciesData = beeClass.getDeclaredMethod("speciesDataReport");
        assertFalse("speciesDataReport should NOT be declared abstract. Implement it for the Bee class", Modifier.isAbstract(speciesData.getModifiers()));
        assertEquals("Bee class speciesDataReport should return a String", String.class, speciesData.getReturnType());
    
        String message = "Make sure speciesDataReport returns a String will all the required data about the Bee. " +
                "\nName, wing count, body color, leg count, makes honey. " +
                "\nIf Bee makes honey include 'does make honey'. If does not make honey, include 'does not make honey'";
    
        
        String speciesDataStringNoHoney = (String) speciesData.invoke(testBeeNoHoney);
        String[] expectedDataNoHoney = {"Bumble", "4", "6", "Stripy", "does not make honey"};
        for (String s : expectedDataNoHoney) {
            assertTrue(message, speciesDataStringNoHoney.contains(s));
        }
        
    
        String speciesDataStringHoney = (String) speciesData.invoke(testBeeMakesHoney);
        String[] expectedDataHoney = {"Buzzy", "4", "6", "Yellow", "does make honey"};
        for (String s : expectedDataHoney) {
            assertTrue(message, speciesDataStringHoney.contains(s));
        }
    }
    
    
    
    
    
}
    
