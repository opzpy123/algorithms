package competeTest.Inn.inn3_21;

public class ShapeTest {
	public static void main(String[] args) {

		circle(2);
		circle(3);
		circle(7);


	}

	private static void square(int n) {
		for (int i = 0; i < n + 1; i++) {
			if (i == 0) {
				for (int j = 0; j < n + 1; j++) {
					if (j == 0) {
						System.out.print(" ");
					} else {
						System.out.print("__");
					}
				}
				System.out.println();
			} else if (i == n) {
				for (int j = 0; j < n + 2; j++) {
					if (j == 0 || j == n + 1) {
						System.out.print("|");
					} else {
						System.out.print("__");
					}
				}
				System.out.println();
			} else {
				for (int j = 0; j < n + 2; j++) {
					if (j == 0 || j == n + 1) {
						System.out.print("|");
					} else {
						System.out.print("  ");
					}
				}
				System.out.println();
			}
		}
	}

	private static void triangle(int n) {
		for (int i = 0; i < n + 1; i++) {
			if (i == 0) {
				for (int j = 0; j < n; j++) {
					System.out.print(" ");
				}
				System.out.print("/\\");
				System.out.println();
			} else if (i == n) {
				System.out.print("/");
				for (int j = 0; j < n * 2; j++) {
					System.out.print("_");
				}
				System.out.println("\\");
			} else {
				for (int j = 0; j < n - i; j++) {
					System.out.print(" ");
				}
				System.out.print("/");
				for (int j = 0; j < i * 2; j++) {
					System.out.print(" ");
				}
				System.out.print("\\");
				System.out.println();
			}
		}
	}

	private static void circle(int n) {
		for (int i = 0; i < 2 * n + 1; i++) {
			for (int j = 0; j < 4 * n + 1; j++) {

			}
			if (i == 0 || i == 2 * n) {
				for (int j = 0; j < (int) 2 * ((n - Math.sqrt((Math.pow(n, 2) - Math.pow((n - i), 2))))) - n + 1; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < 2 * n + 1; j++) {
					System.out.print("X");
				}
				System.out.println();
			} else if (i == n) {
				for (int j = 0; j < (int) 2 * ((n - Math.sqrt((Math.pow(n, 2) - Math.pow((n - i), 2))))); j++)
					System.out.print(" ");
				System.out.print("XX");
				for (int j = 0; j < 4 * Math.sqrt((Math.pow(n, 2) - Math.pow((n - i), 2))); j++)
					System.out.print(" ");
				System.out.print("XX");
				System.out.println();
			} else {
				for (int j = 0; j < (int) 2 * ((n - Math.sqrt((Math.pow(n, 2) - Math.pow((n - i), 2))))); j++)
					System.out.print(" ");
				System.out.print("XX");
				for (int j = 0; j < 4 * Math.sqrt((Math.pow(n, 2) - Math.pow((n - i), 2))) - 2; j++)
					System.out.print(" ");
				System.out.print("XX");
				System.out.println();
			}
		}
	}

	private static void rhombus(int n) {

		for (int i = 0; i < n + 2; i++) {
			if (i == 0) {
				for (int j = 0; j < n + 1; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < Math.round(Math.sqrt(5) * (n + 1)) + 1; j++) {
					System.out.print("_");
				}
				System.out.println();
			} else if (i == n + 1) {
				System.out.print("/");
				for (int j = 0; j < Math.round(Math.sqrt(5) * (n + 1)); j++) {
					System.out.print("_");
				}
				System.out.println("/");
			} else {
				for (int j = 0; j < n - i + 1; j++) {
					System.out.print(" ");
				}
				System.out.print("/");
				for (int j = 0; j < Math.round(Math.sqrt(5) * (n + 1)); j++) {
					System.out.print(" ");
				}
				System.out.print("/");
				System.out.println();
			}
		}
	}
}
