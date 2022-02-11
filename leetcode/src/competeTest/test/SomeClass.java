package competeTest.test;

public class SomeClass {

    public static void main(String[] args) {
        // Variable declaration / initialization
        int[] myArray = {3, 4, -5, 6, 2, 8, 1};    // You can change values or extend
        int elementToBeFound = 2;        // Change value to search for other elements
        int secondElementToBeFound = 23;    // Change value to search for other elements
        int elementIndex;

        // use method findElement to locate indices of some elements (-1 if not there)
        System.out.println("Trying to locate element " + elementToBeFound + " in myArray.");

        // Let's call findElement to try to locate elementToBeFound in myArray
        elementIndex = findElement(myArray, elementToBeFound);

        // If found...
        if (elementIndex > -1) {
            // ... display this message
            System.out.println("Element " + elementToBeFound + " was found in myArray at index: " + elementIndex + ".");
        } else {
            // ...otherwise, let the user know it is not there
            System.out.println("Element " + elementToBeFound + " was NOT found in myArray.");
        }

        // Let's try again
        // Let's call findElement to try to locate secondElementToBeFound in myArray
        elementIndex = findElement(myArray, secondElementToBeFound);

        // If found...
        if (elementIndex > -1) {
            // ... display this message
            System.out.println("Element " + secondElementToBeFound + " was found in myArray at index: " + elementIndex + ".");
        } else {
            // ...otherwise, let the user know it is not there
            System.out.println("Element " + secondElementToBeFound + " was NOT found in myArray.");
        }
    }

    public static int findElement(int[] inputArray, int elementWeWantToLocate) {
        // Declare and initialize index element
        int elementPosition = -1;

        // Sanity check | defensive programming: check if inputArray object even exists
        if (inputArray != null) {
            // Go through inputArray elements ...
            for (int index = 0; index < inputArray.length; index++) {
                // ... and try to find elementWeWantToLocate's index
                if (inputArray[index] == elementWeWantToLocate) {
                    elementPosition = index;
                }
            }
        }

        return elementPosition;
    }

}
