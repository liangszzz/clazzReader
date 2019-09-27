package clazz;

import clazz.constant.CONSTANT;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassFile {

    private String magic;

    private int minorVersion;

    private int majorVersion;

    private int constantPoolCount;

    private CONSTANT[] constantPool;

    private String accessFlags;

    private int thisClass;

    private int superClass;

    private int interfacesCount;

    private Object[] interfaces;

    private int fieldsCount;

    private Object[] fields;

    private int methodsCount;

    private Object[] methods;

    private int attributesCount;

    private Object[] attributes;
}
