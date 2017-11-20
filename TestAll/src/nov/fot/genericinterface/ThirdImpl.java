package nov.fot.genericinterface;

public class ThirdImpl implements Third {

    private int age;
    
    private String name;
    
    private String add;
    
    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAdd() {
        return add;
    }

    @Override
    public void setAdd(String add) {
        this.add = add;
    }

}
