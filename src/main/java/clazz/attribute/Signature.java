package clazz.attribute;

import clazz.ClassFile;
import clazz.constant.CONSTANT_Class_info;
import clazz.constant.CONSTANT_NameAndType_info;
import clazz.constant.CONSTANT_Utf8_info;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Signature extends Attribute_info {

    private String signature;

    @Override
    public String getName() {
        return "Signature";
    }

    @Override
    public Signature parseAttribute(ClassFile classFile) {
        if (!getName().equals(this.getAttribute_name())) {
            throw new RuntimeException("parse source file exception");
        }
        int index = read(2);
        CONSTANT_Utf8_info constant_utf8_info = (CONSTANT_Utf8_info) classFile.getConstantPool()[index];
        setSignature(constant_utf8_info.parseString());
        return this;
    }
}
