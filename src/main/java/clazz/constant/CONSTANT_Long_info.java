package clazz.constant;

import lombok.Data;

@Data
public class CONSTANT_Long_info extends Cp_info {

    private int high_bytes;

    private int low_bytes;

    @Override
    public int getTag() {
        return 5;
    }

    public long toLong() {
        return ((long) high_bytes << 32) + low_bytes;
    }
}
