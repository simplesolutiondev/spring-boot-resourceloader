package dev.simplesolution;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

@Component
public class TestReadFile implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(TestReadFile.class);
	
	@Autowired
	private ResourceLoader resourceLoader;

	@Override
	public void run(String... args) throws Exception {
		Resource resource = resourceLoader.getResource("classpath:data.txt");
		InputStream inputStream = resource.getInputStream();
		byte[] fileData = FileCopyUtils.copyToByteArray(inputStream);
		String outputString = new String(fileData);
		
		logger.info("data.txt file content:");
		logger.info(outputString);
		
	}

}
