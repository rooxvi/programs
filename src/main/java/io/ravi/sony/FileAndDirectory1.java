package io.ravi.sony;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class FileAndDirectory1 {
    public static void main(String[] args) {

        File file = new File("fileTest1.txt");
        System.out.println(file.getAbsoluteFile());
        try {
            //file.createNewFile();
            if (!file.exists()) {
                //PosixFilePermission is an enum class, PosixFilePermissions is a final class

                //create file permissions from string
                Set<PosixFilePermission> filePermissions = PosixFilePermissions.fromString("---------"/* "rwxrwxrwx" */);
                FileAttribute<?> permissions = PosixFilePermissions.asFileAttribute(filePermissions);
                Files.createFile(file.toPath(), permissions);
                // printing the permissions associated with the file
                System.out.println("Executable: " + file.canExecute());
                System.out.println("Readable: " + file.canRead());
                System.out.println("Writable: " + file.canWrite());

                file.setExecutable(true);
                file.setReadable(true);
                file.setWritable(true);
            } else {
                System.out.printf("Else");
                //modify permissions

                //get the permission using file attributes
                Set<PosixFilePermission> perms = Files.readAttributes(file.toPath(), PosixFileAttributes.class).permissions();
                perms.remove(PosixFilePermission.OWNER_WRITE);

                perms.add(PosixFilePermission.OWNER_READ);
                perms.add(PosixFilePermission.OWNER_EXECUTE);
                perms.add(PosixFilePermission.GROUP_WRITE);
                perms.add(PosixFilePermission.GROUP_READ);
                perms.add(PosixFilePermission.GROUP_EXECUTE);
                perms.add(PosixFilePermission.OTHERS_WRITE);
                perms.add(PosixFilePermission.OTHERS_READ);
                perms.add(PosixFilePermission.OTHERS_EXECUTE);
                //Files.setPosixFilePermissions(file.toPath(), perms);
                Files.setPosixFilePermissions(file.toPath(), PosixFilePermissions.fromString("rwxrwxrwx"));


                System.out.println("Executable: " + file.canExecute());
                System.out.println("Readable: " + file.canRead());
                System.out.println("Writable: " + file.canWrite());

                file.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path path = Paths.get(String.valueOf(file));
        System.out.println(path);
    }
}