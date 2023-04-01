package com.jdsk.people.servicies;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.jdsk.people.interfaces.IScrapperService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ScrapperServiceImpl  implements IScrapperService {
	

	
	private static String getWebContent (String link) {
	
		
		try {
			URL url = new URL(link);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			String encoding = conn.getContentEncoding();
			InputStream input = conn.getInputStream();
			Stream<String> lines = new BufferedReader(new InputStreamReader(input)).lines();
			return lines.collect(Collectors.joining());
		} catch (Exception e) {
			log.info(e.getMessage());
			return e.getMessage();
		}
		
	}

}
