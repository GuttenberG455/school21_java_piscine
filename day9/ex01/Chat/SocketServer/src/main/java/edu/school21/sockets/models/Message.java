package edu.school21.sockets.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    private Long id;
    private String text;
    private User author;
    private LocalDateTime sendingTime;

    public Message(Long id, String text, User author, LocalDateTime sendingTime) {
        this.id = id;
        this.text = text;
        this.author = author;
        this.sendingTime = sendingTime;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDateTime getSendingTime() {
        return sendingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) && Objects.equals(text, message.text) && Objects.equals(author, message.author) && Objects.equals(sendingTime, message.sendingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, author, sendingTime);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", author=" + author +
                ", sendingTime=" + sendingTime +
                '}';
    }
}
