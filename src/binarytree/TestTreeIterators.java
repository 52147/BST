package binarytree;

import java.util.NoSuchElementException;

public class TestTreeIterators {
	
	// Test program
    public static void main( String[ ] args )
    {
        BinaryTree<Integer> t = new BinaryTree<Integer>( );

        testItr( "PreOrder", new PreOrder<Integer>( t ) ); // Test empty tree

        BinaryTree<Integer> t1 = new BinaryTree<Integer>( 1 );
        BinaryTree<Integer> t3 = new BinaryTree<Integer>( 3 );
        BinaryTree<Integer> t5 = new BinaryTree<Integer>( 5 );
        BinaryTree<Integer> t7 = new BinaryTree<Integer>( 7 );
        BinaryTree<Integer> t2 = new BinaryTree<Integer>( );
        BinaryTree<Integer> t4 = new BinaryTree<Integer>( );
        BinaryTree<Integer> t6 = new BinaryTree<Integer>( );

        t2.merge( 2, t1, t3 );
        t6.merge( 6, t5, t7 );
        t4.merge( 4, t2, t6 );
        
        t = t4;

        testItr( "Preorder", new PreOrder<Integer>( t ) );
        testItr( "Postorder", new PostOrder<Integer>( t ) );
        testItr( "Inorder", new InOrder<Integer>( t ) );
        testItr( "Level order", new LevelOrder<Integer>( t ) );
    }

    public static <AnyType> void testItr( String type, TreeIterator<AnyType> itr )
    {
        try
        {
            System.out.print( type + ":" );
            for( itr.first( ); itr.isValid( ); itr.advance( ) )
                System.out.print( " " + itr.retrieve( ) );
            System.out.println( );
            itr.advance( );
        }
        catch( NoSuchElementException e )
          { System.out.println( e + " (as expected)" ); }
    }

}
