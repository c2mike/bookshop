package Dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private int date;
    private int userid;
    private String state;
    private float price;
    private String showdate;
    private List<OrderItem> items;

    public String getShowdate() {
        return showdate;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
        help();
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void help()
    {
        Date date1;
        date1 = new Date(date*1000l);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        showdate = simpleDateFormat.format(date1);
    }
}
