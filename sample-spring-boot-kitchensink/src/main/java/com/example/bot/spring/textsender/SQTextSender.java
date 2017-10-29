package com.example.bot.spring.textsender;

import com.example.bot.spring.database.*;

public class SQTextSender implements TextSender {
	private SQDBEngine sqdbengine; 

	public SQTextSender() {
		// TODO Auto-generated constructor stub
		this.sqdbengine = new SQDBEngine();
	}
	
	@Override
	public String process(String userId, String msg) throws Exception{
		if(msg == null) {
			return "unvalid input for SQTextSender.";
		}
		// TODO Auto-generated method stub
		/* Label: greeting/ thanks/ goodbye */
		String label = null; 
		
		try {
		// if msg contains certain keywords, label it
			
			label = sqdbengine.search(msg);
			label = label.replaceAll("\\s+$", "");	// trunc the whitespace at the end 
			
			//int length = label.length();
			//System.out.print(length);
			
			/*
			if (msg == "Hi") {
				label = "greeting";
			}
			*/
		}catch (Exception e){
			System.out.println("---------- inside SQTextSender ---------- ");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		switch (label) {
			case "greeting":{
				System.out.print("should be here");
				return "Hi! How can I help you?";
			}
			case "thanks":{
				return "You are welcome =)";
			}
			case "goodbye":{
				return "have a nice day!";
			}
			default:{
				return "Sorry /o\\, not understand"; 
			}
		}			
	}
}