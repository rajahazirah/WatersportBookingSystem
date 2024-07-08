package model;

public class Activity {
    private int actid;
    private String actname;
    private String actdesc;
    private double actprice;
    private String actpax;

    // Getters and setters

    public int getActid() {
        return actid;
    }

    public void setActid(int actid) {
        this.actid = actid;
    }

    public String getActname() {
        return actname;
    }

    public void setActname(String actname) {
        this.actname = actname;
    }

    public String getActdesc() {
        return actdesc;
    }

    public void setActdesc(String actdesc) {
        this.actdesc = actdesc;
    }

    public double getActprice() {
        return actprice;
    }

    public void setActprice(double actprice) {
        this.actprice = actprice;
    }

    public String getActpax() {
        return actpax;
    }

    public void setActpax(String actpax) {
        this.actpax = actpax;
    }
}
