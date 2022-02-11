package competeTest.Inn.inn3_21;

public class Shapes {
	public static void main(String[] args) {
		//Input parameters do not meet the requirements
		if (args.length != 2) {
			System.out.print("Usage: java Shapes <shape> <size>.");
			return;
		}

		//Get two command line parameters
		String arg0 = args[0];
		String arg1 = args[1];

		//If the second parameter is not of type int, throw an exception and prompt
		char[] chars = arg1.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if(!Character.isDigit(chars[i])){
				System.out.print("Invalid size - it must be a positive integer.");
				return;
			}
		}
		int num = Integer.parseInt(arg1);
		//num must be a positive integer
		if (num <= 0) {
			System.out.print("Invalid size - it must be a positive integer.");
			return;
		}
		//The parameters are qualified, determine which method to execute
		if (arg0.equals("square")) {
			square(num);
		} else if (arg0.equals("triangle")) {
			triangle(num);
		} else if (arg0.equals("circle")) {
			circle(num);
		} else if (arg0.equals("rhombus")) {
			rhombus(num);
		} else {
			//Did not enter the correct shape
			System.out.print("Invalid shape , must be either square,triangle,circle or rhombus.");
		}
	}

	//draw square
	private static void square(int n) {
		//Follow the prompts to determine the number of rows
		for (int i = 0; i < n+1; i++) {
			if (i == 0) {
				//Determine the situation at the beginning of the line
				//How many Spaces and underscores are required
				for (int j = 0; j <n+1; j++) {
					if(j==0){
						System.out.print(" ");
					}else {
						System.out.print("__");
					}
				}
				System.out.println();
			}else if(i==n){
				//On the last line
				//How many vertical and underscores are required
				for (int j = 0; j <n+2; j++) {
					if(j==0||j==n+1){
						System.out.print("|");
					}else {
						System.out.print("__");
					}
				}
				System.out.println();
			}else {
				//In the middle
				for (int j = 0; j <n+2; j++) {
					if(j==0||j==n+1){
						System.out.print("|");
					}else {
						System.out.print("  ");
					}
				}
				System.out.println();
			}
		}
	}

	//draw triangle
	private static void triangle(int n) {
		//Follow the prompts to determine the number of rows
		for (int i = 0; i < n+1; i++) {
			if(i==0){
				//Determine the situation at the beginning of the line
				//How many Spaces are required
				for (int j = 0; j < n; j++) {
					System.out.print(" ");
				}
				System.out.print("/\\");
				System.out.println();
			} else if(i==n){
				//On the last line
				//How many space are required
				System.out.print("/");
				for (int j = 0; j < n * 2; j++) {
					System.out.print("_");
				}
				System.out.println("\\");
			}else {
				//Same as above
				for (int j = 0; j < n-i; j++) {
					System.out.print(" ");
				}
				System.out.print("/");
				for (int j = 0; j < i*2; j++) {
					System.out.print(" ");
				}
				System.out.print("\\");
				System.out.println();
			}
		}
	}

	//draw circle
	private static void circle(int n) {
		//Follow the prompts to determine the number of rows
		for (int i = 0; i < 2 * n + 1; i++) {
			//Calculate how many Spaces are needed at the beginning and end
			if (i == 0 || i == 2 * n) {
				for (int j = 0; j < (int) 2 * ((n - Math.sqrt((Math.pow(n, 2) - Math.pow((n - i), 2))))) - n + 1; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < 2 * n + 1; j++) {
					System.out.print("X");
				}
				System.out.println();
			} else {
				//Draw in general
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

	//draw rhombus
	private static void rhombus(int n) {
		//Follow the prompts to determine the number of rows
		for (int i = 0; i < n + 2; i++) {
			if (i == 0) {
				//Determine the situation at the beginning of the line
				//How many Spaces are required
				for (int j = 0; j < n + 1; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < Math.round(Math.sqrt(5)  * (n+1))+1; j++) {
					System.out.print("_");
				}
				System.out.println();
			} else if (i == n + 1) {
				//Determine the situation at the end of the line
				System.out.print("/");
				for (int j = 0; j < Math.round(Math.sqrt(5)  * (n+1)); j++) {
					System.out.print("_");
				}
				System.out.println("/");
			} else {
				//Draw in general
				for (int j = 0; j < n - i + 1; j++) {
					System.out.print(" ");
				}
				System.out.print("/");
				for (int j = 0; j < Math.round(Math.sqrt(5)  * (n+1)); j++) {
					System.out.print(" ");
				}
				System.out.print("/");
				System.out.println();
			}
		}
	}

}
