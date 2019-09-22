package clazz.constant;

import lombok.Data;

@Data
public class CONSTANT_MethodType_info extends Cp_info {

    private int descriptor_index;

    @Override
    public int getTag() {
        return 16;
    }
}
