package clazz.constant;

import clazz.ClassReader;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CONSTANT_Utf8_info extends CONSTANT {

    private int length;

    private int[] bytes;

    @Override
    public int getTag() {
        return 1;
    }

    @Override
    public CONSTANT parse(ClassReader classReader) {
        CONSTANT_Utf8_info constant = new CONSTANT_Utf8_info();
        constant.setTag(getTag());
        constant.setLength(classReader.readU2());
        int[] bs = new int[length];
        for (int i = 0; i < length; i++) {
            bs[i] = classReader.readU1();
        }
        constant.setBytes(bs);
        return constant;
    }

    public String parseString() {
        return "";
    }
}
