import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class BackupCreator {

    public static void main(String[] args) {
        createBackup();
    }

    public static void createBackup() {
        System.out.println("Программа для создания резервных копий файлов.");

        // Получаем текущую директорию
        String currentDirectory = ".";

        // Создаем папку backup
        File backupDir = new File(currentDirectory, "backup");
        if (!backupDir.exists()) {
            if (backupDir.mkdir()) {
                System.out.println("Папка backup успешно создана.");
            } else {
                System.out.println("Ошибка при создании папки backup.");
                return;
            }
        }

        // Обрабатываем текущую директорию
        processDirectory(new File(currentDirectory), backupDir);

        System.out.println("Резервные копии созданы в папке backup.");
    }

    private static void processDirectory(File sourceDir, File targetDir) {
        File[] files = sourceDir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Создаем копию файла в папке backup
                    copyFile(file, new File(targetDir, file.getName()));
                } else if (file.isDirectory()) {
                    // Обрабатываем поддиректорию
                    File newTargetDir = new File(targetDir, file.getName());
                    if (newTargetDir.mkdir()) {
                        processDirectory(file, newTargetDir);
                    }
                }
            }
        }
    }

    private static void copyFile(File source, File target) {
        try {
            Files.copy(source.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Создана копия файла: " + source.getName());
        } catch (IOException e) {
            System.out.println("Ошибка при копировании файла " + source.getName() + ": " + e.getMessage());
        }
    }
}
