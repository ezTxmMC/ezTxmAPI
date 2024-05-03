package dev.eztxm.object;

import dev.eztxm.config.JsonConfig;

public class ObjectConverter {
    private final JsonConfig jsonConfig;
    private final Object object;

    public ObjectConverter(JsonConfig jsonConfig, Object object) {
        this.jsonConfig = jsonConfig;
        this.object = object;
    }

    public ObjectConverter(Object object) {
        this.jsonConfig = null;
        this.object = object;
    }

    public Object asObject() {
        return object;
    }

    public String asString() {
        return object.toString();
    }

    public boolean asBoolean() {
        return (boolean) object;
    }

    public int asInteger() {
        return (int) object;
    }

    public double asDouble() {
        return (double) object;
    }

    public float asFloat() {
        return (float) object;
    }

    public JsonObject asJsonObject() {
        return new JsonObject(jsonConfig, object);
    }

    public JsonArray asJsonArray() {
        return (JsonArray) object;
    }
}
