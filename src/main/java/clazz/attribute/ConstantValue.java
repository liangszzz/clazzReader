package clazz.attribute;

import clazz.constant.CONSTANT;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConstantValue extends Attribute_info {

    private CONSTANT constant;


    public Attribute_info parseAttribute(byte[] info){

        return null;
    }

}
