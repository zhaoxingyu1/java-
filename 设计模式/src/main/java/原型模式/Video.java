package 原型模式;

import java.util.Date;

/**
 * @author zxy
 * @Classname Video
 * @Date 2022/5/7 15:52
 */

public class Video implements Cloneable{


    private String name;
    private Date date;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Video(){

    }

    public Video(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
