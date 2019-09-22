package clazz.constant;

import lombok.Data;

@Data
public class CONSTANT_InvokeDynamic_info extends Cp_info {


    private int bootstrap_method_attr_index;

    private int name_and_type_index;


    @Override
    public int getTag() {
        return 18;
    }
}
