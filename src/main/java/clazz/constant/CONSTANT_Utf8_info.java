package clazz.constant;

import lombok.Data;

@Data
public class CONSTANT_Utf8_info extends Cp_info {

    private int length;

    private String bytes;

    @Override
    public int getTag() {
        return 1;
    }
}
