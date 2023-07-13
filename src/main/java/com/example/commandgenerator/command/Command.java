package com.example.commandgenerator.command;

import java.util.*;

public class Command {
    private Map<String, String> moduleID;
    private final Map<String, String> commandID;
    private String size;
    private List<String> data;

    public Command(Map<String, String> moduleID, Map<String, String> commandID) {
        this.moduleID = moduleID;
        this.commandID = commandID;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    private String listToString(List<String> list) {
        String string = "#0x";

        if (list.isEmpty()) {
            string = string + "0#";
        } else {
            for (String str : list) {
                string = string + str + "#0x";
            }
        }

        string = string.substring(0, string.length()-2);

        return string;
    }

    public String toString(String moduleIDKey, String commandIDKey) {
        return "#0x" + moduleID.get(moduleIDKey) + "#0x" + commandID.get(commandIDKey) + "#0x" + getSize() + listToString(data);
    }

    public String toStringEmptyData(String moduleIDKey, String commandIDKey) {
        return "#0x" + moduleID.get(moduleIDKey) + "#0x" + commandID.get(commandIDKey) + "#0x00"  + "#";
    }
}
