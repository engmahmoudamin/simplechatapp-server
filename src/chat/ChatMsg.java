package chat;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Mahmoud
 */
public class ChatMsg {
    private String name;
    private String msg;
    private String time;

    public ChatMsg() {
    }

    public ChatMsg(String name, String msg, String time) {
        this.name = name;
        this.msg = msg;
        this.time = time;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
}
