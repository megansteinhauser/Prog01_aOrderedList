/**
 * Car class creates car objects with make, year, and price
 * 
 * CSC 1351 Programming Project No 1
 * 
 * Section 002
 * 
 * @author Megan Steinhauser
 * 
 * @since 03-17-24
 * 
 */


package aOrderedList;


public class Car implements Comparable <Car>{

		
		private final String make;
		private final int year;
		private final int price;
		
		// Constructor
		public Car(String make, int year, int price) {
		
			this.make = make;
			this.year = year;
			this.price = price;
		}
		
		
		//Method to get make of car
		public String getMake() {
			return make;
		}
		
		
		//Method to get year of car
		public int getYear() {
			return year;
		}
		
		
		//Method to get price of car
		public int getPrice() {
			return price;
		}
		
		
		//Method to compare cars
		public int compareTo(Car anotherCar) {
			if(this.make.compareTo(anotherCar.getMake())==0)
					return Integer.compare(this.year, anotherCar.getYear());
			else 
				return this.make.compareTo(anotherCar.getMake());
		}
		
			
		public String toString() {
			String price = String.format("%-13s%7s%n", "Price:");
			return String.format("\nMake: %14s\nYear: %14d\n%s", this.make, this.year, price);
		}	
	}


