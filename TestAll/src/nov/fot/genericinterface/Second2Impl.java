package nov.fot.genericinterface;

public class Second2Impl implements Second2 {

    private String name;
    
    private String name2;
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName2() {
        return name2;
    }

    @Override
    public void setName2(String name2) {
        this.name2 = name2;
    }

}
