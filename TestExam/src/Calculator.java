import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

class Calculator {
	Map<Double, Double> values= new HashMap<>();
	
	Double square(Double x) {
		
		Function<Double, Double> squareFunction = factor-> {
			return factor * factor;
		};
		return values.computeIfAbsent(x, squareFunction);
	
	}
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		System.out.println(calculator.square(10.0));
	}
}
