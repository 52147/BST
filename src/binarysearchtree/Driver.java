package binarysearchtree;

// Test program
public class Driver {

	public static void main(String[] args) {
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();

		final int NUMS = 4000;
		final int GAP = 37;

		System.out.println("Checking... (no more output means success)");

		for (int i = GAP; i != 0; i = (i + GAP) % NUMS)
			t.insert(i);
		for (int i = 1; i < NUMS; i += 2)
			t.remove(i);

		if (t.findMin() != 2 || t.findMax() != (NUMS - 2))
			System.out.println("FindMin or FindMax error!");
		for (int i = 2; i < NUMS; i += 2)
			if (t.find(i) != i)
				System.out.println("Find error 1 !");
		for (int i = 1; i < NUMS; i += 2)
			if (t.find(i) != null)
				System.out.println("Find error 2 !");

	}

}
