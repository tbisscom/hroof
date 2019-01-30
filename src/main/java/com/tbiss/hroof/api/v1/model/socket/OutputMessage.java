package com.tbiss.hroof.api.v1.model.socket;

public class OutputMessage extends Message {

    private String time;

    public OutputMessage(final String from, final String text, final String time) {
        setFrom(from);
        setText(text);
        this.time = time;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) { this.time = time; }
}