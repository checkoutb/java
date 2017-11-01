package sep.te.enumTest;

public enum EE2 {

    OK(11), Error(16), Wrong(22), Exception(33) {
        public boolean isRest() {
            return true;
        }
    };
    
    final private int value;
    
    private EE2(int value)          //OK(11) 用这个构造器。。
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
}

