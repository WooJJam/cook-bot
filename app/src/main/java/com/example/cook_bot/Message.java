package com.example.cook_bot;

public class Message {
    public static String SENT_BY_ME = "me";
    public static String SENT_BY_BOT = "bot";
    private String text;
//    private boolean isUser;
    private String sendBy;

    public Message(
            String text,
//            boolean isUser,
            String sendBy
    ) {
        this.text = text;
//        this.isUser = isUser;
        this.sendBy = sendBy;
    }

    public String getMessage() {
        return text;
    }

    public void setMessage(String text) {
        this.text = text;
    }

//    public boolean isUser() {
//        return isUser;
//    }
    public String getSendBy() {
        return sendBy;
    }
    public void setSendBy(String sendBy) {
        this.sendBy = sendBy;
    }
}
