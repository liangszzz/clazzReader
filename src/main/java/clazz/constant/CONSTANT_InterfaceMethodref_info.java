package clazz.constant;

import lombok.Data;

@Data
public class CONSTANT_InterfaceMethodref_info extends Cp_info {

    private int class_index;

    private int name_and_type_index;

    @Override
    public int getTag() {
        return 11;
    }
}
