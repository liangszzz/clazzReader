package clazz.constant;

import lombok.Data;

@Data
public class CONSTANT_Float_info extends Cp_info {


    private int value;

    @Override
    public int getTag() {
        return 4;
    }
}
