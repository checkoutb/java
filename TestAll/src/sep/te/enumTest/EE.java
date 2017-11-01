package sep.te.enumTest;

public enum EE {

    OK, Error, Wrong, Exception;
    
    // 用了 protected Enum(String name, int ordinal) 构造器。
    // 枚举类型符合通用模式 Class Enum<E extends Enum<E>>
}
