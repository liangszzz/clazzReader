package clazz.constant;

import lombok.Data;

@Data
public class CONSTANT_String_info extends Cp_info {

    private int string_index;

    @Override
    public int getTag() {
        return 8;
    }
}
