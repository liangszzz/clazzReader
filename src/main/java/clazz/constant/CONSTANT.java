package clazz.constant;

import clazz.ClassReader;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class CONSTANT{

    private int tag;

    public abstract int getTag();

    public abstract CONSTANT parse(ClassReader classReader);
}
