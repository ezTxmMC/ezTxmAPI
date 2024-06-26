package de.eztxm.ezlib.config.object;

import de.eztxm.ezlib.config.JsonConfig;
import org.json.JSONArray;
import org.json.JSONException;

public class JsonArray {
    private final JsonConfig jsonConfig;
    private final JSONArray jsonArray;

    public JsonArray(JsonConfig jsonConfig, Object object) {
        this.jsonConfig = jsonConfig;
        this.jsonArray = (JSONArray) object;
    }

    public JsonArray(JsonConfig jsonConfig, JSONArray jsonArray) {
        this.jsonConfig = jsonConfig;
        this.jsonArray = jsonArray;
    }

    public void add(String value) {
        this.jsonArray.put(value);
        jsonConfig.save();
    }

    public void remove(String value) {
        for (int i = 0; i < jsonArray.length(); i++) {
            String currentString = jsonArray.getString(i);
            if (currentString.equals(value)) {
                jsonArray.remove(i);
                break;
            }
        }
    }

    public ObjectConverter get(String key) {
        try {
            Object object = null;
            for (int i = 0; i < jsonArray.length(); i++) {
                String currentString = jsonArray.getString(i);
                if (currentString.equals(key)) {
                    object = jsonArray.get(i);
                    break;
                }
            }
            return new ObjectConverter(object);
        } catch (JSONException | NullPointerException e) {
            return null;
        }
    }

    public Object getAsObject(String key) {
        try {
            Object object = null;
            for (int i = 0; i < jsonArray.length(); i++) {
                String currentString = jsonArray.getString(i);
                if (currentString.equals(key)) {
                    object = jsonArray.get(i);
                    break;
                }
            }
            return object;
        } catch (JSONException | NullPointerException e) {
            return null;
        }
    }
}
