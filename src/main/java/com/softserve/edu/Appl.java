package com.softserve.edu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Appl {
	public static void main(String[] args) {
		List<String> cars = new ArrayList<String>();
		for (int i = 0; i < 12; i++) {
			cars.add(new String(String.valueOf(i)));
		}
		int k = 0;
		Iterator<String> it = cars.iterator();
		while (it.hasNext()) {
			if (k == 5) {
				System.out.println(" k =" + k + "  cars[" + (k - 2) + "]=" + cars.get(k - 2));
			}
			k++;
			System.out.println(it.next());
		}
		//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = 1, y = 1;
		try
		{
			System.out.print("x=");
			x = Integer.parseInt(br.readLine()); // =Float.parseFloat(…);
			System.out.print("y=");
			y = Integer.parseInt(br.readLine());
		} catch (Exception e) { // NumberFormatException
			System.out.println("I/O Error.");
		}
		if (x > y)
		{
			System.out.println("x is maximum, x=" + x);
		} else
		{
			System.out.println("y is maximum, y=" + y);
		}
	}

}
