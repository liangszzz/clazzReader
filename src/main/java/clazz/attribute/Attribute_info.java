package clazz.attribute;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Attribute_info {

    private String attribute_name;

    private int attribute_length;

    private byte[] info;
}
