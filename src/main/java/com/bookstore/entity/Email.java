package com.bookstore.entity;

public class Email {
    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getFromPassword() {
        return fromPassword;
    }

    public String getContent() {
        return content;
    }

    public String getSubject() {
        return subject;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setFromPassword(String fromPassword) {
        this.fromPassword = fromPassword;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    private String from, to, fromPassword, content, subject;
}
