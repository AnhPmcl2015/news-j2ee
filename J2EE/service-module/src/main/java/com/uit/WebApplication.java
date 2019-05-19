package com.uit;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
	"com.uit"
})
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
	
//	@PostConstruct
//	public void init() throws IOException, UnsupportedEncodingException  {
//		
//		File folder = new File("D:\\GitHub\\news-j2ee\\190517 thanhnien");
//		File outputFile = new File("D:\\GitHub\\news-j2ee\\test.txt");
//
//		
//		
//		if(folder.isDirectory()) {
//			
//			for(File file : folder.listFiles()) {
//				System.out.println(file.getPath());
//				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
//				String line;
//				
//				while((line = br.readLine()) != null) {
////					out.append(line).append("\r\n");
//				}
//				
//				br.close();
//			}
//		}
//		
//		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\GitHub\\news-j2ee\\test.txt"), "UTF-8"));
//		out.append("Xin chào");
//		out.flush();
//		out.close();
//	}
}