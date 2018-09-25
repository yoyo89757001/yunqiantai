package megvii.testfacepass.beans;

import android.graphics.Bitmap;

public class MSRBean {
    private byte[] bitmap;
    private String sex;
    private int age;

    public byte[] getBitmap() {
        return bitmap;
    }

    public void setBitmap(byte[] bitmap) {
        this.bitmap = bitmap;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
