import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class PlayingWithOptional {

	public static void main(String[] args) {
		List<String> fruits = List.of("apple", "banana","mango");
		
		Predicate<? super String> predicate = fruit -> fruit.startsWith("b");
		Optional<String> optional = fruits.stream().filter(predicate).findFirst();
		System.out.println("print if any fruit starts with b in the list of fruit ");
		System.out.println(optional);
		System.out.println(optional.isEmpty());
		System.out.println(optional.isPresent());
		System.out.println(optional.get());
		
		Optional<String> optionalf = fruits.stream().filter(fruit -> fruit.startsWith("c")).findFirst();
		System.out.println("print if any fruit starts with c in the list of fruit ");
		System.out.println(optionalf);
		System.out.println(optionalf.isEmpty());
		System.out.println(optionalf.isPresent());
		System.out.println(optionalf.get());
		
		Optional<String> fruit = Optional.of("banana");
		Optional<String> empty = Optional.empty(); //NoSuchElementException

	}

}
