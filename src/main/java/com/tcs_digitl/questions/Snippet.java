package com.tcs_digitl.questions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Snippet {
	
	void code() throws FileNotFoundException{
	try (PrintWriter writer = new PrintWriter(new File("test.txt"))) {
	    writer.println("Hello World");
	}
}
}
