package megvii.testfacepass.beans;

import java.util.Comparator;

/**
 * Created by Administrator on 2018/5/31.
 */

public class Subject implements Comparator<Subject> {

    private String id;
    private String remark;
    private String location;
    private String name;
    private String phone;
    private String comeFrom;
    private String interviewee;
    private String city;
    private String department;
    private String email;
    private String title;
    private String assemblyId;
    private String sourceMeeting;
    private String photo;
    private int  lingshiZPID;

    public int getLingshiZPID() {
        return lingshiZPID;
    }

    public void setLingshiZPID(int  lingshiZPID) {
        this.lingshiZPID = lingshiZPID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComeFrom() {
        return comeFrom;
    }

    public void setComeFrom(String comeFrom) {
        this.comeFrom = comeFrom;
    }

    public String getInterviewee() {
        return interviewee;
    }

    public void setInterviewee(String interviewee) {
        this.interviewee = interviewee;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAssemblyId() {
        return assemblyId;
    }

    public void setAssemblyId(String assemblyId) {
        this.assemblyId = assemblyId;
    }

    public String getSourceMeeting() {
        return sourceMeeting;
    }

    public void setSourceMeeting(String sourceMeeting) {
        this.sourceMeeting = sourceMeeting;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id='" + id + '\'' +
                ", remark='" + remark + '\'' +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", comeFrom='" + comeFrom + '\'' +
                ", interviewee='" + interviewee + '\'' +
                ", city='" + city + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", title='" + title + '\'' +
                ", assemblyId='" + assemblyId + '\'' +
                ", sourceMeeting='" + sourceMeeting + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }



    @Override
    public int compare(Subject o1, Subject o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
