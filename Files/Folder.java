import java.io.File;

public class Folder {

    public static void listFiles(final File folder) {
        System.out.println("=====" + folder.getName() + "=====");
        for (final File file : folder.listFiles()) {
            if (file.isDirectory())
                listFiles(file);
            else System.out.println(file.getName());
        }
        System.out.println("++++++" + folder.getName() + "+++++++");
    }

    public static void main(String[] args) {
        final File folder = new File("C:\\Users\\sanja\\Codes");
        final File folder2 = new File("C:\\Users\\sanja\\Codes\\ADV Java\\ADV Java\\SpringMVC2\\VaccineManagement");
        listFiles(folder2);

    }
}
