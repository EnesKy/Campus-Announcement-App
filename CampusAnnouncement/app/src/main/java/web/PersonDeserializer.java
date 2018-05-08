package web;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import model.Instructor;
import model.Student;

public class PersonDeserializer implements JsonDeserializer<Object> {

        private static final String CLASS_META_KEY = "CLASS_META_KEY";

        @Override
        public Object deserialize(JsonElement jsonElement, Type type,
                                  JsonDeserializationContext jsonDeserializationContext)
                throws JsonParseException {
            JsonObject jsonObj = jsonElement.getAsJsonObject();
            JsonElement jsonEl = jsonObj.get("semester");
            if (jsonEl != null)
                return jsonDeserializationContext.deserialize(jsonObj, Student.class);
            else
                return jsonDeserializationContext.deserialize(jsonObj, Instructor.class);

        }
}
