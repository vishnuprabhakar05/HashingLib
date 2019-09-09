package com.app.dbcreds;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Properties;


public class GetPropValues extends GetFields {
	private static final String USER = "user";
	private static final String PASS = "pass";
	InputStream inputStream;
	GetFields getFields= new GetFields();
	
	public void getPropValues() throws IOException {
		Properties properties = new Properties();
		String fileName = "config.properties";
		
		inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
		
		if(null != inputStream) {
			properties.load(inputStream);
		} else {
			throw new FileNotFoundException("Property file cannot be located");
		}
		
		getFields.setUsername(properties.getProperty(USER));
		getFields.setPassword(properties.getProperty(PASS));
		
		Deque<GetFields> fieldValues = new ArrayDeque<GetFields>();
		fieldValues.add(getFields);
		
		String user = getFields.getUsername();
		System.out.println(user);
		//System.out.println(Arrays.toString(fieldValues.toArray()));
	}
}
