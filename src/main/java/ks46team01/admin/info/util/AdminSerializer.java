package ks46team01.admin.info.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import ks46team01.admin.info.entity.Admin;

import java.io.IOException;

public class AdminSerializer extends JsonSerializer<Admin> {

    @Override
    public void serialize(Admin admin, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("adminUsername", admin.getAdminUsername());

        jsonGenerator.writeEndObject();
    }
}
