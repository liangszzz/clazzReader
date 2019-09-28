package clazz.attribute;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RuntimeVisibleAnnotations_attribute extends Attribute_info {

    private int num_annotations;

    private Object[] annotations;

    public Attribute_info parseAttribute(byte[] info) {

        return null;
    }
}
