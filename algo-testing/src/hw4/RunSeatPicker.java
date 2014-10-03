package hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RunSeatPicker {

	public void RunSeatPicker1() {
		
		int numberOfPeople = 6;
		
		List<Pair> pairs = new ArrayList<Pair>();
		
		Pair a,b,c,d,e,f;
		a = new Pair(1,2);
		b = new Pair(2,3);
		c = new Pair(3,4);
		d = new Pair(4,5);
		e = new Pair(5,6);
		f = new Pair(1,6);
		
		pairs.add(a);
		pairs.add(b);
		pairs.add(c);
		pairs.add(d);
		pairs.add(e);
		pairs.add(f);
		
		/*
		 * 
		 *    1 ------ 2 ------ 3
		 *    -                 -
		 *    -                 -
		 *    6 ------ 5 -------4
		 * 
		 * 
		 */
		
		SeatPicker picker = new SeatPicker();
		int [][] seats = picker.pickSeating(numberOfPeople, pairs);
		
		for (int i = numberOfPeople - 1; i >= 0; i --) {
			for (int j = 0; j < numberOfPeople; j ++){
				System.out.print(seats[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void runSeatPicker2() {
		int numberOfPeople = 7;
		List<Pair> pairs = new ArrayList<Pair>();
		
		Pair a,b,c,d,e,f,g;
		a = new Pair(1,2);
		b = new Pair(2,3);
		c = new Pair(3,4);
		d = new Pair(4,5);
		e = new Pair(4,7);
		f = new Pair(4,6);
		g = new Pair(7,5);
		
		pairs.add(a);
		pairs.add(b);
		pairs.add(c);
		pairs.add(d);
		pairs.add(e);
		pairs.add(f);
		pairs.add(g);
		
		SeatPicker picker = new SeatPicker();
		int [][] seats = picker.pickSeating(numberOfPeople, pairs);
		
		for (int i = numberOfPeople - 1; i >= 0; i --) {
			for (int j = 0; j < numberOfPeople; j ++){
				System.out.print(seats[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void runSeatPicker3() {
		int numberOfPeople = 9;
		List<Pair> pairs = new ArrayList<Pair>();
		
		Pair a,b,c,d,e,f,g,h;
		a = new Pair(1,2);
		b = new Pair(2,3);
		c = new Pair(2,4);
		d = new Pair(3,4);
		e = new Pair(4,5);
		f = new Pair(6,7);
		g = new Pair(7,8);
		h = new Pair(8,9);
		
		pairs.add(a);
		pairs.add(b);
		pairs.add(c);
		pairs.add(d);
		pairs.add(e);
		pairs.add(f);
		pairs.add(g);
		pairs.add(h);
		SeatPicker picker = new SeatPicker();
		int [][] seats = picker.pickSeating(numberOfPeople, pairs);
		
		for (int i = numberOfPeople - 1; i >= 0; i --) {
			for (int j = 0; j < numberOfPeople; j ++){
				System.out.print(seats[i][j] + " ");
			}
			System.out.println();
		}
	}
}
