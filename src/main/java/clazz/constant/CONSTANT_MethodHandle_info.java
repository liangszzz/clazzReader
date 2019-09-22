package clazz.constant;

import lombok.Data;

@Data
public class CONSTANT_MethodHandle_info extends Cp_info {

    private int reference_kind;

    private int reference_index;

    @Override
    public int getTag() {
        return 15;
    }
}
