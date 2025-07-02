import java.util.ArrayList;
import java.util.List;

public class Inventory {
	List<Supply> supplies = new ArrayList<>();
	
	long countDifferentKinds() {
		return supplies.stream()
				.filter(Supply::isUncontaminated)
				.map(Supply::getName)
				.distinct()
				.count();
		
	}
}
