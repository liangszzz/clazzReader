package clazz.constant;

import lombok.Data;

@Data
public class CONSTANT_Double_info extends Cp_info {

    private int high_bytes;

    private int low_bytes;

    @Override
    public int getTag() {
        return 6;
    }
}
