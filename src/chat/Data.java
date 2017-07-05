/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.util.Vector;

/**
 *
 * @author Mahmoud
 */
public class Data {
    private  Vector<ChatMsg> messages;
    private  Vector<User> users;

    public Data(Vector<ChatMsg> messages, Vector<User> users) {
        this.messages = messages;
        this.users = users;
    }

    public Data() {
    }

    public Vector<ChatMsg> getMessages() {
        return messages;
    }

    public void setMessages(Vector<ChatMsg> messages) {
        this.messages = messages;
    }

    public Vector<User> getUsers() {
        return users;
    }

    public void setUsers(Vector<User> users) {
        this.users = users;
    }
    
    
}
