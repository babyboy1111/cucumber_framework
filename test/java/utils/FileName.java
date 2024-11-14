package utils;

import java.util.HashMap;
import java.util.Map;

public class FileName {
    private String name;
    private String locator;
    private String type;
    public FileName(String name,String locator){
        this.locator= locator;
        this.name =name;
        this.type = type;
    }

    public String getName(){
        return name;

    }

    public String getLocator(){
        return locator;
    }

    public String getType(){
        return type;
    }
}
