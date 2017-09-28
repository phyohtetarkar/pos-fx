package com.jsoft.pos.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

@SuppressWarnings("serial")
public class DateDeSerializer extends StdDeserializer<LocalDate> {

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	protected DateDeSerializer() {
		super(LocalDate.class);
	}

	@Override
	public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		String date = p.getText();
		return LocalDate.parse(date, formatter);
	}

}
