package TestDemo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter name of class: ");
		
		String classInfo = scan.nextLine();
	
		Class classStuff = null;
		
		try {
			classStuff = Class.forName(classInfo);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Method allClassStuffMethods[];
		
		allClassStuffMethods = classStuff.getDeclaredMethods();
			
		ArrayList<Method> testClassStuffMethods= new ArrayList<Method>();
		
		
		for(int i = 0; i < allClassStuffMethods.length; i++) {
			if (allClassStuffMethods[i].getAnnotation(MyAnnotation.class) != null) {
				testClassStuffMethods.add(allClassStuffMethods[i]);
			}
		}
		
		
		for(Method item : testClassStuffMethods) {
			try {
				System.out.print(item.getName() + ": ");
				item.invoke(null);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(item.getName());
		}
	/*	
		Field innerFields[][] = new Field [allClassStuffMethods.length][3];
		
		for(int i = 0; i < allClassStuffMethods.length; i++) {
			{
			innerFields[i] = allClassStuffMethods[i].getClass().getDeclaredFields();
			}
		}
		
		boolean results[] = new boolean[innerFields.length];
		
		for(int i = 0; i < innerFields.length; i++) {
			for(int j = 0; j < 3; j++) {
				Field actual = innerFields[i][1];
				Field expected = innerFields[i][2];
				boolean test = (actual == expected);
				results[i] = test;
			}
		}
		
		for(int i = 1; i <= results.length; i++) {
			System.out.println("Test" + i + ": " + results[i-1]);
		}
		*/
	}
}
	

