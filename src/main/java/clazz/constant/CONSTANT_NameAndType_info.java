package clazz.constant;

import lombok.Data;

@Data
public class CONSTANT_NameAndType_info extends Cp_info {


    private int name_index;

    private int descriptor_index;

    @Override
    public int getTag() {
        return 12;
    }
}
