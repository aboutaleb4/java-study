public class ArrayNotes {
    static void arrayNotes() {
        /* Arrays */
        //Instantiating an array with items in it.
        int[] numbers = {1, 2, 3, 4, 5};

        //Fetching using index
        int numberFetchedUsingIndex = numbers[2];
        System.out.println("The third number is: " + numberFetchedUsingIndex);

        //Attempting to fetch using an index that is out of bounds
        try {
            numberFetchedUsingIndex = numbers[6];
            System.out.println("The sixth number is: " + numberFetchedUsingIndex);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
