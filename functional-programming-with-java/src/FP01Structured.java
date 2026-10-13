import java.util.List;

public class FP01Structured {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker",
				"Kubernetes");
		printAllNumbersInListStructured(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15)); //
		// Ctrl +1 to create the method
		printEvenNumbersInListStructured(numbers);
		printOddNumbersInListStructured(numbers);
		printWordContainsSpring(courses);
		printcourseNameHaveAtlease4Char(courses);
		printSquaresOfEvenNumbersInListFunctional(numbers);
		printCubesOfOddNumbersInList(numbers);
		printNumberOfCharactersInEachCourse(courses);
	}

	private static void printNumberOfCharactersInEachCourse(List<String> courses) {
		System.out.println("Print number of characters in each course");
		
		courses.stream()
		.map(course -> course + " - " + course.length())
		.forEach(System.out::println);
	}

	private static void printCubesOfOddNumbersInList(List<Integer> numbers) {
		System.out.println("Print cubes of odd number in the List");

		numbers.stream().filter(number -> number % 2 != 0) // number%2 == 1
				.map(number -> number * number * number).forEach(System.out::println);

	}

	private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
		System.out.println("Print square of even number in the List");

		numbers.stream().filter(number -> number % 2 == 0).map(number -> number * number).forEach(System.out::println);

	}

	private static void printcourseNameHaveAtlease4Char(List<String> courses) {
		System.out.println("Course contains the name atlease 4 letters");
		courses.stream().filter(course -> course.length() >= 4).forEach(System.out::println);

	}

	private static void printWordContainsSpring(List<String> courses) {
		System.out.println("course contain the name Spring");
		courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);

	}

	private static void printOddNumbersInListStructured(List<Integer> numbers) {
		System.out.println("Print odd number in the List");

		numbers.stream().filter(number -> number % 2 != 0) // number%2 == 1
				.forEach(System.out::println);

	}

	private static void print(int number) {
		System.out.println(number);

	}

	private static boolean isEven(int number) {
		return number % 2 == 0;
	}

	private static void printAllNumbersInListStructured(List<Integer> numbers) {
		System.out.println("Print all numbers in the list");

		// get the stream of number
		// Functional approach
		// numbers.stream().forEach(FP01Structured::print); // Method Reference

		numbers.stream().forEach(System.out::println);

		// Structural approach
		/*
		 * // How to loop the numbers? for (int number : numbers) {
		 * System.out.println(number); }
		 */
	}

	private static void printEvenNumbersInListStructured(List<Integer> numbers) {
		System.out.println("Print all even number in the list");
		// Structural approach
		/*
		 * for (int number : numbers) { if (number % 2 == 0) System.out.println(number);
		 * }
		 */

		// Functional approach
		numbers.stream()
				// .filter(FP01Structured::isEven) // Filter - Only Allow Even Numbers
				.filter(number -> number % 2 == 0)// Lambda Expression
				.forEach(System.out::println); // Method Reference
	}

}
