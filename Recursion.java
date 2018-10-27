
public class Recursion {

	private final static int EXCLUDE_NUMBER = 0;

	public static void main(String[] args) {

		/* Test Question 1 */
		System.out.println(dec2Bin(270));
		System.out.println(bin2Dec(100001110));
		System.out.println(hex2Dec("EFD1"));
		System.out.println(dec2Hex(61393));
		System.out.println();

		/* Test Question 2 */
		int[] set = new int[] { 1, 2, 3, 4 };
		int[] subset = new int[set.length];
		System.out.print("Array: ");
		printArray(set);

		System.out.println("Subsets of array: ");
		subset(set, subset, 0);
		System.out.println();

		/* Test Question 3 */
		specialPrint("Hello", '$');
	}

	/* Question 1.1 */
	private static int dec2Bin(int dec) { // dec2Bin
		int x = dec % 2;
		if (dec == 0 || dec == 1)
			return dec;
		else
			return x + (dec2Bin(dec / 2) * 10);
	}

	/* Question 1.2 */
	private static int bin2Dec(int num) { // bin to Dec
		return bin2Dec(num, 0);
	}

	public static int bin2Dec(int binary, int k) {// recursion helper method -bin to Dec
		if (binary == 0)
			return 0;
		else
			return (int) ((binary % 10) * Math.pow(2, k) + bin2Dec(binary / 10, k + 1));
	}

	/* Question 1.3 */

	private static int hex2Dec(String str) {// hex to Dec

		if (str == null || str.length() == 0)
			return 0;

		else {
			if (str.charAt(0) - 'A' >= 0)// if it is a char
				return (int) ((str.charAt(0) - 'A' + 10) * Math.pow(16, str.length() - 1)) + hex2Dec(str.substring(1));
			else

				return (int) (str.charAt(0) - '0' * Math.pow(16, str.length() - 1)) + hex2Dec(str.substring(1));
		}

	}

	/* Question 1.4 */
	private static char[] hexaMap = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	// dec to Hex by hexaMap help
	private static String dec2Hex(int num) {
		if (num < 16)
			return "" + hexaMap[num];
		else

			return dec2Hex(num / 16) + hexaMap[num % 16];
	}

	/* Question 2 */

	/* Helper - prints an array except of EXCLUDE_NUMBER */
	private static void printArray(int[] arr) {
		System.out.print('{');
		printArray(arr, 0, true);
		System.out.println('}');
	}

	// print Array
	private static void printArray(int[] arr, int index, boolean isFirst) {
		if (index >= arr.length) {
			return;
		}
		if (arr[index] != EXCLUDE_NUMBER) {
			if (isFirst) {
				System.out.printf("%d", arr[index]);
			} else {
				System.out.printf(", %d", arr[index]);
			}
			isFirst = false;

		}
		printArray(arr, index + 1, isFirst);
	}

	// prints all the subsets of a given set
	private static void subset(int[] set, int[] subset, int idx) {
		if (idx == set.length) {
			printArray(subset);
			return;
		} else {
			subset[idx] = EXCLUDE_NUMBER;
			subset(set, subset, idx + 1);
			subset[idx] = set[idx];
			subset(set, subset, idx + 1);

		}

	}

	/* Question 3 */
	// special Print - puts the index inside the string
	private static void specialPrint(String str, char delimeter) {
		if (str == null || str.length() == 0)
			return;
		if (str.length() == 1) {// if the length is 1
			System.out.println(str);

		} else {

			System.out.print(str.substring(0, 1) + delimeter);
			specialPrint(str.substring(1), delimeter);

		}
	}
}
