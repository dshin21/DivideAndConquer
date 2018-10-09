import java.util.ArrayList;

public class MergeSort {
    public static void main( String[] args ) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add( 2 );
        A.add( 5 );
        A.add( 8 );
        A.add( 3 );
        A.add( 6 );
        A.add( 9 );
        A.add( 1 );
        A.add( 6 );
        A.add( 5 );

        System.out.println( "Original A: " + A );
        A = mergeSort( A );
        System.out.println( "After merge sort: " + A );
    }

    private static ArrayList<Integer> mergeSort( ArrayList<Integer> A ) {
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        int mid = A.size() / 2;

        if ( A.size() > 1 ) {
            for ( int i = 0; i < mid; i++ ) B.add( A.get( i ) );
            for ( int j = mid; j < A.size(); j++ ) C.add( A.get( j ) );
            B = mergeSort( B );
            C = mergeSort( C );
            merge( C, B, A );
        }
        return A;
    }

    private static void merge( ArrayList<Integer> C,
                               ArrayList<Integer> B,
                               ArrayList<Integer> A ) {
        int a = 0;
        int b = 0;
        int c = 0;
        ArrayList<Integer> temp;
        int index;
        while ( a < B.size() && b < C.size() ) {
            if ( B.get( a ) <= C.get( b ) ) {
                A.set( c, B.get( a ) );
                a++;
            } else {
                A.set( c, C.get( b ) );
                b++;
            }
            c++;
        }
        if ( a == B.size() ) {
            temp = C;
            index = b;
        } else {
            temp = B;
            index = a;
        }
        for ( int i = index; i < temp.size(); i++ ) {
            A.set( c, temp.get( i ) );
            c++;
        }
    }
}
