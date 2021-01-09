package cn.supfox.pattern.prototype.shallow;

public class User {

    private int grade;
    private String val;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "User{" +
                "grade=" + grade +
                ", val='" + val + '\'' +
                '}';
    }
}
