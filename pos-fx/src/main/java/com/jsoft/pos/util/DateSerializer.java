package com.jsoft.pos.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

@SuppressWarnings("serial")
public class DateSerializer extends StdSerializer<LocalDate> {
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public DateSerializer() {
		super(LocalDate.class);
	}

	@Override
	public void serialize(LocalDate val, JsonGenerator gen, SerializerProvider sp) 
			throws IOException {
		gen.writeString(val.format(formatter));
	}

}
