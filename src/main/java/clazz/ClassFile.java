package clazz;

import clazz.attribute.Attribute_info;
import clazz.constant.CONSTANT;
import clazz.constant.CONSTANT_Utf8_info;
import clazz.field.Field_info;
import clazz.method.Method_info;
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

    private String thisClass;

    private String superClass;

    private int interfacesCount;

    private CONSTANT_Utf8_info[] interfaces;

    private int fieldsCount;

    private Field_info[] fields;

    private int methodsCount;

    private Method_info[] methods;

    private int attributesCount;

    private Attribute_info[] attributes;
}
