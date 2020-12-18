import java.sql.Timestamp;
public class Customer {
    private String name;
    private String phone;
    private int partysize;
    private Timestamp time;
    
    //constructor
    public Customer() {
    	this.name = "unknow";
    	this.phone = "000";
    	this.partysize = 0;
    	this.time = null;
    }

    public Customer(String _name,String _phone, int size, Timestamp _time) {
    	this.name = _name;
    	this.phone = _phone;
    	this.partysize = size;
    	this.time = _time;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPartysize(int partysize) {
        this.partysize = partysize;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getPartysize() {
        return partysize;
    }

    public String getPhone() {
        return phone;
    }

    public Timestamp getTime() {
        return time;
    }

    public String getName() {
        return name;
    }
}
