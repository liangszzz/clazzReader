package clazz.attribute;

import clazz.ClassFile;
import clazz.ClassReader;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;

@Getter
@Setter
public abstract class Attribute_info {

    private String attribute_name;

    private int attribute_length;

    private byte[] info;

    public abstract String getName();

    public abstract Attribute_info parseAttribute(ClassFile classFile);

    private static HashMap<String, Attribute_info> map = new HashMap<>();

    static {
        SourceFile sourceFile = new SourceFile();
        map.put(sourceFile.getName(), sourceFile);
        Code code = new Code();
        map.put(code.getName(), code);
        MethodParameters methodParameters = new MethodParameters();
        map.put(methodParameters.getName(), methodParameters);
        LineNumberTable lineNumberTable = new LineNumberTable();
        map.put(lineNumberTable.getName(), lineNumberTable);
        LocalVariableTable localVariableTable = new LocalVariableTable();
        map.put(localVariableTable.getName(), localVariableTable);
    }

    public static Attribute_info getInstance(String attribute_name) {
        return map.get(attribute_name);
    }


    private int index = 0;

    protected int read(int i) {
        int k = ClassReader.bytesToInt(Arrays.copyOfRange(getInfo(), index, index + i));
        index += i;
        return k;
    }

    protected byte[] readBytes(int length) {
        byte[] bytes = Arrays.copyOfRange(this.getInfo(), index, index + length);
        index += length;
        return bytes;
    }
}
