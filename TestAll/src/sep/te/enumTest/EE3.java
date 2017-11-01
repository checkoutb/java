package sep.te.enumTest;

public enum EE3 {
    OK(11), Error(11), Wrong(22), Exception(33) {
        public boolean isRest() {
            return true;
        }
    };
    
    private int value;
    
    private EE3(int value)          //OK(11) 用这个构造器。。
    {
        this.value = value;
    }
    
    public int getValue()
    {
        return this.value;
    }
    
    public boolean isRest()
    {
        return false;
    }
    
//    public int ordinal()
//    {
//        return this.value;
//    }
}
