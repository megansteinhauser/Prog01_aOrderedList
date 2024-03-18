/**
 * Main class containing methods for getting both input and output files, parsing each line of the input file and the main mathod
 * 
 * CSC 1351 Programming Project No 1
 * 
 * Section 002
 * 
 * @author Megan Steinhauser
 * @since 03-17-24
 * 
 */
package aOrderedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Prog01_aOrderedList {
	
			static Scanner scanner = new Scanner(System.in);
		
		
		public static Scanner getInputFile(String UserPrompt) throws FileNotFoundException {
			
				File file = null;
				while (true) {
					System.out.print(UserPrompt);
					String filename = scanner.nextLine();
					file = new File(filename);
					if (file.exists()) {
						try {
							return new Scanner(file);
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("File specifiec <" + filename + "> does not exist. Would you like to continue? <Y/N>");
						String choice = scanner.nextLine();
						if (choice.equalsIgnoreCase("N")) {
							throw new FileNotFoundException();
						}
					}
				}
			}
		
		

		
				 
		//Method to get fileName of out out file. Will return print writer pointing to file name	
				 public static PrintWriter getOutputFileName(String userPrompt)throws FileNotFoundException {
					 
			
				
				PrintWriter printWriter = null;
				while (true) {
					
					System.out.print(userPrompt);
					String filename = scanner.nextLine();
					File file = new File(filename);
					if (file.canWrite()) {
						
						try {
							printWriter = new PrintWriter(file);
							return printWriter;
						} catch (FileNotFoundException e) {
							
							e.printStackTrace();
						}
					} else {
						
						System.out.println("Invalid filename. WOuld you like to continue? <Y/N>");
						String choice = scanner.nextLine();
						if (choice.equalsIgnoreCase("N")) {
							throw new FileNotFoundException();
								}
							}
						}
					}
				 
				 private static String writeOrderedList(aOrderedList cars) {
						StringBuilder out = new StringBuilder();
						
						out.append("Number of cars: " + cars.size());
						out.append("\n");
							cars.reset();
							while (cars.hasNext()) {
							Car car = (Car) cars.next();
							out.append("Make: " + car.getMake());
							out.append("Year: " + car.getYear());
							out.append("Price: $" + car.getPrice());
								out.append("\n");
							}
							
							return out.toString();
						}
				 
				 
				 public static void main(String[] args) throws FileNotFoundException {
						
					 aOrderedList cars = new aOrderedList();
						
						Scanner input = getInputFile("Enter input filename: ");
						PrintWriter output = getOutputFileName("Enter output filename: ");
						
						
						while (input.hasNextLine()) {
							
							
							String line = input.nextLine();
							String[] parts = line.split(",");
							
							if(parts[0].equals("A")) {
								
								if (parts.length == 4 ) {
									String make = parts [1];
									int year = Integer.parseInt(parts[2]);
									int price = Integer.parseInt(parts[3]);
									Car car = new Car(make, year, price);
									cars.add(car);	
								} 
								
							} else if (parts[0].equals("D")) {
								
								if (parts.length == 2) {
									
									int index = Integer.parseInt(parts[1]);
									cars.remove(index);
									
								} else if (parts.length == 3) {
									
									String make = parts[1];
									int year = Integer.parseInt(parts[2]);
									Car car = null;
									boolean stop = false;
									cars.reset();
									while (cars.hasNext() && !stop) {
										car = (Car) cars.next();
										
										if(car.getMake().equals(make) && car.getYear() == year) {
											cars.remove();
											stop = true;
											
											
										}
										
									}
									
								}
								
							}
							
						}
						
						output.write(writeOrderedList(cars));
						output.close();
						
						
						input.close();
						scanner.close();
						
					}
				 
				}