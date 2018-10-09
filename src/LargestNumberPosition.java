import java.util.Arrays;

public class LargestNumberPosition {
    public static void main( String[] args ) {
        int[] inputArray = { 2, 5, 8, 3, 6, 9, 1, 6, 5 };
        int position = findPosition( inputArray, 0, inputArray.length - 1 );

        System.out.println( Arrays.toString( inputArray ) );
        System.out.println( "Largest number in the array is: " + inputArray[ position ] + " at index: " + position );
    }

    private static int findPosition( int[] inputArray, int head, int tail ) {
        int max;
        if ( head == tail ) max = head;
        else {
            int headMax = findPosition( inputArray, head, ( head + tail ) / 2 );
            int tailMax = findPosition( inputArray, ( ( head + tail ) / 2 ) + 1, tail );
            if ( inputArray[ headMax ] > inputArray[ tailMax ] ) max = headMax;
            else max = tailMax;
        }
        return max;
    }
}
