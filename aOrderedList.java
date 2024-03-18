/**
 * aOrderedList class for creating ordered list objects
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

import java.util.Arrays;
import java.util.Comparator;


public class aOrderedList{
	
	private final int SIZEINCREMENTS = 20;
	private Comparable[] oList;
	private int listSize;
	private int numObjects;
	private int curr;
	

	public aOrderedList() {
		
			this.numObjects = 0;
			this.listSize = SIZEINCREMENTS;
			this.oList = new Comparable[SIZEINCREMENTS];
			this.curr = -1; //we know the list starts at index 0, the current value must be -1 until this.next() is called.
			
		}

	//method to add car object
	public void add(Comparable newObj) {
		
		if(numObjects%20 == 0) {
			this.oList = Arrays.copyOf(this.oList, this.oList.length + SIZEINCREMENTS);
			listSize = this.oList.length;
			}
		this.oList[numObjects] = newObj;
		numObjects++;
		Arrays.sort(this.oList, Comparator.nullsLast(Comparator.naturalOrder())); // forces values that are null to the end of the array
	}
		
		public String toString() {
			StringBuilder output = new StringBuilder();
			output.append(String.format("Number of cars: %7d\n", numObjects()));
			
			for(Comparable obj: this.oList) {
				if(obj != null) {
					output.append(obj);
				}
			}
			return output.toString();
		}

		private Object numObjects() {
			return null;
		}
	
	public int size() {
		return numObjects;
	}

	public Comparable get(int index) throws IndexOutOfBoundsException{
		if(index < oList.length && index >= 0) {
			
			if(oList[index] != null) return oList[index];
			else {
				System.out.println("! There was no object specified index.");
				return null;
			}
			
		}
		else throw new IndexOutOfBoundsException();
	}
	
	
	public boolean isEmpty() {
		return numObjects == 0;
	}
	
	public void remove(int index) {
		if (index < 0 || index >= numObjects) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		for (int i = index; i < numObjects - 1; i++) {
			oList[i] = oList[i + 1];
		}
		numObjects--;
		
		curr--;
	}
	
	public void reset() {
		curr = -1;
	}
	
	public Comparable next() {
		curr++;
		return this.get(curr);
		}
	
	public boolean hasNext() {
		return oList[curr+1]!= null;
	}
	
	public void remove() {
		if(curr >= 0) remove(curr);
		}
	}
	

	
	

