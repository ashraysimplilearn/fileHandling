package com.simplilearn.FileHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fileOperations {
	
	public static String path;
	public static String folder;
	public static String filename;
	
	/*
	 * This Program is Designed to Create a File at Dynamic Directory
	 */
	public static void writeFile(String path, String folder, String filename) throws IOException {
		String text = "File Handling is Crazy";
		File fFolder = new File(path.concat(folder));
		System.out.println(fFolder);
		if(fFolder.exists()) {
			System.out.println("Folder Already Present");
			File fname = new File(path.concat(folder).concat("/").concat(filename));
			if (fname.exists()) {
				System.out.println("File Already Present");
			}
			else
				fname.createNewFile();	
			
			FileWriter fwrite = new FileWriter(fname);
			fwrite.write(text);	
			readFile(path,folder,filename);
			fwrite.close();
		}
		else
		{
			fFolder.mkdir();
			System.out.println("New Folder Created");
			/*
			 * Any File type can be created by changing the File Extension
			 */
			File fname = new File(path.concat(folder).concat("/").concat(filename));
			if (fname.exists()) {
				System.out.println("File Already Present");
			}
			else
				fname.createNewFile();
			
			FileWriter fwrite = new FileWriter(fname);
			fwrite.write(text);	
			fwrite.close();
			
		}		
			
	}

	public static void readFile(String path, String folder, String filename) throws IOException{
		String readLine;
		FileReader fRead = new FileReader(path.concat(folder).concat("/").concat(filename));
		BufferedReader br = new BufferedReader(fRead);
			while((readLine=br.readLine())!= null) {
				System.out.println(readLine);
			}
		br.close();
		fRead.close();
		
	}
	
	public static void appendFile(String path, String folder, String filename) throws IOException{
		String aPath = path.concat(folder).concat("/").concat(filename);
		System.out.println("Append File Path: "+aPath);
		String newString  = "This is One Hell of a Ride";
		BufferedWriter bAppend = new BufferedWriter(new FileWriter(aPath,true));
		bAppend.write(newString);
		bAppend.close();
		
	}
	
	public static void deleteFile(String path, String folder, String filename) throws IOException{
		String aPath = path.concat(folder).concat("/").concat(filename);
		System.out.println("FileToBeDeleted: "+aPath);
		File fDelete = new File(aPath);
		fDelete.delete();
		System.out.println("File has been Deleted\n");
	}
	
	
	public static void main(String[] args) throws IOException {
		writeFile("/Users/ashraykn/Desktop/Simplilearn_Classes/","File_Handling","simplilearnFileHandling.txt");
		readFile("/Users/ashraykn/Desktop/Simplilearn_Classes/","File_Handling","simplilearnFileHandling.txt");
		appendFile("/Users/ashraykn/Desktop/Simplilearn_Classes/","File_Handling","simplilearnFileHandling.txt");
		deleteFile("/Users/ashraykn/Desktop/Simplilearn_Classes/","File_Handling","simplilearnFileHandling.txt");
		
	}


}
