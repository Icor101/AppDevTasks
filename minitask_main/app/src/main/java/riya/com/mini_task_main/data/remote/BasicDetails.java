package riya.com.mini_task_main.data.remote;

/**
 * Created by BBMishra on 16-May-18.
 */

public class BasicDetails {
    private String name,id,username;
    public BasicDetails(){

    }
    public BasicDetails(String name,int id,String username)
    {
        this.name=name;
        this.id=String.valueOf(id);
        this.username=username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getid() {
        return Integer.valueOf(id);
    }

    public void setid(int id) {
        this.id = String.valueOf(id);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
