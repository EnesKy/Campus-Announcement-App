package nskmlylm.campusannouncement;

public class Comment {
    String user, comm, date;

    public Comment(String user, String comm, String date) {
        this.user = user; this.comm = comm; this.date = date;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setDesc(String desc) {
        this.comm = desc;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public String getDesc() {
        return comm;
    }

    public String getDate() {
        return date;
    }
}
