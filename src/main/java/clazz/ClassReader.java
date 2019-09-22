package clazz;

import clazz.constant.CONSTANT;

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

    private void parseSuperClass(ClassFile classFile) {
        classFile.setSuperClass(readU2());
    }

    private void parseAccessFlags(ClassFile classFile) {
        classFile.setAccessFlags(readU2());
    }

    private void parseConstantPool(ClassFile classFile) {
        int count = classFile.getConstantPoolCount();
        CONSTANT[] cpInfos = new CONSTANT[count];
        cpInfos[0] = null;
        for (int i = 1; i < count; i++) {
            int tag = readU1();
            cpInfos[i] = null;
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
        pos += 2;
        return bytesToInt(bytes);
    }

    public int readU2() {
        byte[] bytes = Arrays.copyOfRange(this.bytes, pos, pos + 2);
        pos += 2;
        return bytesToInt(bytes);
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
