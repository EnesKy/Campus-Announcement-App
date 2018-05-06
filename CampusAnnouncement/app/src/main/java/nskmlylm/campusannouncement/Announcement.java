package nskmlylm.campusannouncement;


public class Announcement {
    String user, header, desc, date;

    public Announcement(String user, String header, String desc, String date) {
        this.user = user;
        this.header = header;
        this.desc = desc;
        this.date = date;
    }

    /*
    Calendar c = Calendar.getInstance();
    SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
    String date = dateformat.format(c.getTime());
    */

    public void setUser(String user) {
        this.user = user;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public String getHeader() {
        return header;
    }

    public String getDesc() {
        return desc;
    }

    public String getDate() {
        return date;
    }

}
