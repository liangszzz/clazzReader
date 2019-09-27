package clazz;

import clazz.constant.CONSTANT;
import clazz.constant.CONSTANT_Class_info;
import clazz.constant.CONSTANT_Utf8_info;
import com.google.common.base.Joiner;

import java.util.Arrays;

public class ClassReader {

    private int pos;

    private byte[] bytes;

    public ClassReader(byte[] bytes) {
        this.bytes = bytes;
        pos = 0;
    }

    public ClassFile parseClassFile() {
        ClassFile classFile = new ClassFile();
        parseMagic(classFile);
        parseMinOrVersion(classFile);
        parseMajorVersion(classFile);
        parseConstantPoolCount(classFile);
        parseConstantPool(classFile);
        parseAccessFlags(classFile);
        parseThisClass(classFile);
        parseSuperClass(classFile);
        parseInterfacesCount(classFile);
        parseInterfaces(classFile);
        parseFieldsCount(classFile);
        parseFields(classFile);
        parseMethodCount(classFile);
        parseMethods(classFile);
        parseAttributesCount(classFile);
        parseAttributes(classFile);
        return classFile;
    }

    private void parseAttributes(ClassFile classFile) {
    }

    private void parseAttributesCount(ClassFile classFile) {
        classFile.setAttributesCount(readU2());
    }

    private void parseMethods(ClassFile classFile) {
    }

    private void parseMethodCount(ClassFile classFile) {
        classFile.setMethodsCount(readU2());
    }

    private void parseFields(ClassFile classFile) {
    }

    private void parseFieldsCount(ClassFile classFile) {
        classFile.setFieldsCount(readU2());
    }

    private void parseInterfaces(ClassFile classFile) {
    }

    private void parseInterfacesCount(ClassFile classFile) {
        classFile.setInterfacesCount(readU2());
    }

    private void parseThisClass(ClassFile classFile) {
        CONSTANT_Class_info constant_class_info = (CONSTANT_Class_info) classFile.getConstantPool()[readU2()];
        CONSTANT_Utf8_info constant_utf8_info = (CONSTANT_Utf8_info) classFile.getConstantPool()[constant_class_info.getName_index()];
        classFile.setThisClass(constant_utf8_info.parseString());
    }

    private void parseSuperClass(ClassFile classFile) {
        int index=readU2();
        if ( index== 0) {
            classFile.setSuperClass("Object");
            return;
        }
        CONSTANT_Class_info constant_class_info = (CONSTANT_Class_info) classFile.getConstantPool()[index];
        CONSTANT_Utf8_info constant_utf8_info = (CONSTANT_Utf8_info) classFile.getConstantPool()[constant_class_info.getName_index()];
        classFile.setSuperClass(constant_utf8_info.parseString());
    }

    private void parseAccessFlags(ClassFile classFile) {
        String s = toHexString(readU2Byte());
        if (s.length() < 4) {
            for (int i = 0; i < 4 - s.length(); i++) {
                s = "0" + s;
            }
        }
        classFile.setAccessFlags(accessFlagsToString(s));
    }

    private String accessFlagsToString(String s) {
        StringBuilder builder = new StringBuilder();
        switch (s.charAt(3)) {
            case '0':
                break;
            case '1':
                builder.append("ACC_PUBLIC").append("    ");
                break;
            default:
                throw new RuntimeException("can not parse access flag");
        }
        switch (s.charAt(2)) {
            case '0':
                break;
            case '1':
                builder.append("ACC_FINAL").append("    ");
                break;
            case '2':
                builder.append("ACC_SUPER").append("    ");
                break;
            default:
                throw new RuntimeException("can not parse access flag");
        }
        switch (s.charAt(1)) {
            case '0':
                break;
            case '2':
                builder.append("ACC_INTERFACE").append("    ");
                break;
            case '4':
                builder.append("ACC_ABSTRACT").append("    ");
                break;
            default:
                throw new RuntimeException("can not parse access flag");
        }
        switch (s.charAt(0)) {
            case '0':
                break;
            case '1':
                builder.append("ACC_SYNTHETIC");
                break;
            case '2':
                builder.append("ACC_ANNOTATION");
                break;
            case '4':
                builder.append("ACC_ENUM");
                break;
            default:
                throw new RuntimeException("can not parse access flag");
        }
        return builder.toString();
    }

    private void parseConstantPool(ClassFile classFile) {
        int count = classFile.getConstantPoolCount();
        CONSTANT[] cpInfos = new CONSTANT[count];
        cpInfos[0] = null;
        for (int i = 1; i < count; i++) {
            int tag = readU1();
            cpInfos[i] = CONSTANT.parseConstant(tag, this);
        }
        classFile.setConstantPool(cpInfos);
    }

    private void parseConstantPoolCount(ClassFile classFile) {
        classFile.setConstantPoolCount(readU2());
    }

    private void parseMajorVersion(ClassFile classFile) {
        classFile.setMajorVersion(readU2());
    }

    private void parseMinOrVersion(ClassFile classFile) {
        classFile.setMinorVersion(readU2());
    }

    private void parseMagic(ClassFile classFile) {
        classFile.setMagic(readU4());
    }

    public int readU1() {
        byte[] bytes = Arrays.copyOfRange(this.bytes, pos, pos + 1);
        pos += 1;
        return bytesToInt(bytes);
    }

    public byte readU1Byte() {
        byte b = this.bytes[pos];
        pos += 1;
        return b;
    }

    public int readU2() {
        byte[] bytes = Arrays.copyOfRange(this.bytes, pos, pos + 2);
        pos += 2;
        return bytesToInt(bytes);
    }

    public byte[] readU2Byte() {
        byte[] bytes = Arrays.copyOfRange(this.bytes, pos, pos + 2);
        pos += 2;
        return bytes;
    }

    public String readU4() {
        byte[] bytes = Arrays.copyOfRange(this.bytes, pos, pos + 4);
        pos += 4;
        return bytesToString(bytes);
    }

    public int readU4Int() {
        byte[] bytes = Arrays.copyOfRange(this.bytes, pos, pos + 4);
        pos += 4;
        return bytesToInt(bytes);
    }

    public String bytesToString(byte[] bytes) {
        return toHexString(bytes);
    }

    public int bytesToInt(byte[] bytes) {
        return Integer.valueOf(toHexString(bytes), 16);
    }

    public String toHexString(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(Integer.toHexString(b & 0xFF));
        }
        return builder.toString();
    }
}
