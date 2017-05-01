/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ysa;

/**
 *
 * @author Kadir
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class DataSetReader {
	
	public int[][] trainingData;
	public int[][] testData;

	public DataSetReader(final String trainFile, final String testFile) {
		loadTrainingData(trainFile);
		loadTestData(testFile);
	}
	
	public void loadTrainingData(final String trainFile) {
		trainingData = new int[21][70];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(trainFile)));
			String line;
			
			for (int i=0; i<21; i++) {
				try {
					line = br.readLine();
					StringTokenizer strTok = new StringTokenizer(line);
					
					for (int j=0; j<70; j++)
						trainingData[i][j] = Integer.parseInt(strTok.nextToken());
					
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	public void loadTestData(final String testFile) {
		testData = new int[3][70];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(testFile)));
			String line;
			
			for (int i=0; i<3; i++) {
				try {
					line = br.readLine();
					StringTokenizer strTok = new StringTokenizer(line);
					
					for (int j=0; j<70; j++)
						testData[i][j] = Integer.parseInt(strTok.nextToken());
					
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
}
