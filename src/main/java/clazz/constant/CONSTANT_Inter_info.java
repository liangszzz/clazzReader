package clazz.constant;

import lombok.Data;

@Data
public class CONSTANT_Inter_info extends Cp_info {

    private int value;

    @Override
    public int getTag() {
        return 3;
    }
}
