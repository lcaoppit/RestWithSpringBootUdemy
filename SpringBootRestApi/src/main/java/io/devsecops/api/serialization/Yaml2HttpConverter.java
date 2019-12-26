package io.devsecops.api.serialization;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class Yaml2HttpConverter extends AbstractJackson2HttpMessageConverter{

	public Yaml2HttpConverter() {
		
		super(new YAMLMapper(), MediaType.parseMediaType("application/x-yaml"));
	}

}
