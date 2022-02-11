package sort;
//1.定义一个学生类Student，具有年龄age和姓名username两个属性，并通过Comparable接口实现比较规则
public class ComparableStudent implements Comparable<ComparableStudent> {


    private String userName;
    private int age;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(ComparableStudent o) {
        return this.age-o.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
