import clazz.ClassFile;
import clazz.ClassReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Application {

  public static void main(String[] args) throws IOException {
    String filePath =
        "D:\\github\\demo\\target\\classes\\com\\example\\demo\\entity\\TestEntity.class";
    byte[] bytes = Files.readAllBytes(Paths.get(filePath));
    ClassReader classReader = new ClassReader(bytes);
    ClassFile classFile = classReader.parseClassFile();
    System.out.println(classFile.getMagic());
    System.out.println(classFile.getInterfaces()[0].parseString());
  }
}
