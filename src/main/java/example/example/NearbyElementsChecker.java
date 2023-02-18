package example.example;

import java.util.Arrays;
/**
 * The task of the class is to find and return the nearby elements from a two-dimensional int array.
 * To keep it as an one class application, the entry point (main method) and test data is kept here also.
 */
public class NearbyElementsChecker {
    private int [][] elements;
    /**
     * Constructor. The array to work with is given here to the instance.
     *
     * @param elements the 2 dimensional int array to search through
     */
    public NearbyElementsChecker(int[][] elements) {
        this.elements = elements;
    }
    /**
     * Instance method for returning nearby elements.
     *
     * @param row row of the target element -melyik tömbbel foglalkozunk
     * @param col column of the target element --adott tömb melyik elemével foglalkozunk
     * @param range maximum distance of nearby elements to give back
     *        range --> adott szám jobbról és balról milyen szórásban kéri a számokat
     * @return array holding the nearby elements within range, except for the target element, may be of zero length
     * @return null if row is out of bounds
     */
    public int[] getNearbyElements(int row, int col, int range) {

        int firstElement = col - range;
        int lastElement = col + range;

        //row is outside
        if (row < 0 || row >= elements.length) {
            return null;
        }

        //outside of the array
        if (lastElement < 0 || firstElement >=elements[row].length){
            return new int[]{};
        }

        //just firstElement outside or lastElement outside
        if(firstElement < 0){
            firstElement = 0;
        }
        if(lastElement >= elements[row].length ){
            lastElement = elements[row].length - 1;
        }


        //elements in range into array
        int sizeOfArray = lastElement - firstElement + 1;
        if (firstElement <= col && col <= lastElement) {
            sizeOfArray--;
        }

        int j = 0;
        int[] nearbyElements = new int[sizeOfArray];
        for (int i = firstElement; i <= lastElement; i++){
            if (i != col){
                nearbyElements[j++] = elements[row][i];
            }
        }
        return nearbyElements;
    }

    /**
     * Instance method for pretty printing the elements
     */
    public void prettyPrint() {

        int maxLength = 0;
        for(int[] row: elements){
            for(int rowElement : row) {
                maxLength =Math.max(maxLength, String.valueOf(rowElement).length());
            }
        }
        //Selecting the longest row
        /*
        int maxLength = 0;
        for (int[] row : elements) {
            maxLength = Math.max(maxLength, row.length);
        }
        //Store the number of digits in each column
        int[] maxDigitCounts = new int[maxLength];

        */
        /*
        //Determine the maximum number of digits for each column
        for (int[] row : elements){
            for (int i = 0; i<row.length; i++){
                int digitCount = Integer.toString(row[i].length());
                maxDigitCounts[i] = Math.max(maxDigitCounts[i], digitCount);
            }
        }
        //Determine the width of the longest number (including its sign)
        int maxWith = 0;
        for (int i : maxDigitCounts) {
            maxWidth = Math.max(maxWidth, i);
        }
        */

        //Print each row of elements, aligning each number to the right
        for (int[] row : elements) {
            for (int column : row){
                System.out.printf("%" + (maxLength + 1) + "d", column);
            }
            System.out.println();
        }
    }

    // The main method with this declaration is the entry point of Java applications.
    public static void main(String[] args) {

        int[][] testArray = new int[][] {
                { 2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323 },
                { 1, 3, 5, 7 },
                { 321, 320, 32, 3, 41241, -11, -12, -13, -66, -688 },
                { 25, -3, 41, 325, 7, 424, 42}
        };

        //belső tömb hossza ({ 1, 3, 5, 7 }  itt 4 lesz):
        // testArray[1].length

        //dimenziós tömb adott elemének (itt tömbjének) adott elemére mutatás:
        //testArray[1][3]

        //tömbben tömb végigjárása:
       /* for (int[] element : testArray) {
            for (int innerElement : element) {

            }
        }

        */

        int[] elso = new int[] {1,2,3,4,5};
        int[] masodik = new int[] {6,7,8,9,10};



        int[][] summary = new int[2][];
        summary[0] = elso;
        summary[1] = masodik;

        System.out.println(Arrays.toString(elso));
        System.out.println(Arrays.toString(masodik));
        System.out.println(Arrays.toString(summary[0]));
        System.out.println(Arrays.toString(summary[1]));

        // Create an instance of our class with the test data.
        NearbyElementsChecker nearbyElementsChecker = new NearbyElementsChecker(testArray);

        // Print the two-dimensional array
        nearbyElementsChecker.prettyPrint();
    }

}
