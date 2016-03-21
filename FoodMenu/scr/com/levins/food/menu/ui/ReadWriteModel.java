package com.levins.food.menu.ui;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.levins.food.menu.jpa.FoodMenuUnit;

public class ReadWriteModel {
	private List<FoodMenuUnit> listOfUnit;

	public List<FoodMenuUnit> getListOfAnimal() {
		return listOfUnit;
	}

	public void setListOfAnimal(List<FoodMenuUnit> singleLine) {
		this.listOfUnit = singleLine;
	}
//TODO
	public static List<FoodMenuUnit> read(File inputFilePath)
			throws FileNotFoundException, IOException {
		String currentLine;
		List<FoodMenuUnit> lineList = new ArrayList<FoodMenuUnit>();

		try (BufferedReader br = new BufferedReader(new FileReader(
				inputFilePath))) {

			while ((currentLine = br.readLine()) != null) {
//				String[] animal = currentLine.split(",");
//				Animal newAnimal = new Animal(animal[0], animal[1], animal[2],
//						animal[3], animal[4], animal[5], animal[6]);
//				lineList.add(newAnimal);
//				System.out.println(newAnimal.toString());
			}
		}

		return lineList;
	}

	public static void writeNewFile(Queue<String> sorceToWrite,
			String outputFile) throws IOException {
		try (BufferedWriter bufferWrite = new BufferedWriter(new FileWriter(
				outputFile))) {
			while (sorceToWrite.size() > 0) {
				bufferWrite.write(sorceToWrite.poll());
			}
		}
	}


}
