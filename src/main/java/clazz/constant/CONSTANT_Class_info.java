package clazz.constant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CONSTANT_Class_info extends Cp_info {

    private int name_index;

    @Override
    public int getTag() {
        return 7;
    }
}
