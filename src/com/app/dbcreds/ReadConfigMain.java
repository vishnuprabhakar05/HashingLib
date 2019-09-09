package com.app.dbcreds;
import java.io.IOException;


public class ReadConfigMain{

	public static void main(String[] args) throws IOException{
		GetPropValues prop = new GetPropValues();
		prop.getPropValues();
	}

}
