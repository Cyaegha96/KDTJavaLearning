package solveTypeSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

//나이순 정렬


class Person{
	
	int age;
	String name;
	int order;
	public Person(int age, String name, int order) {
		super();
		this.age = age;
		this.name = name;
		this.order = order;
	}
}


class MyComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		if(o1.age == o2.age) {
			return Integer.compare(o1.order, o2.order);
		}else {
			return Integer.compare(o1.age, o2.age);
		}
	}

}


public class p10814 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
	
		StringTokenizer st;
		
		List<Person> persons = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			String line = bf.readLine();
			st = new StringTokenizer(line);
			
			int age= Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			persons.add(new Person(age, name, i));
			
			}

	
		
		persons.sort(new MyComparator());
		
		for(Person p: persons) {
			System.out.println(p.age +" " + p.name);
		}
		
	}
}
