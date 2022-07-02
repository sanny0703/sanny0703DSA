import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortingFilesBySize {
    public static void getFileSizeInMB(final File folder) {
        Map<String, String> map = new LinkedHashMap<>();
        for (final File file : folder.listFiles()) {
            // bytes
            long length = file.length();
            long lengthInKb = length / 1024;
            long sizeInMB = lengthInKb / 1024;
            map.put(file.getName(), lengthInKb + " kB");
        }
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    public static void main(String[] args) {
        getFileSizeInMB(new File("C:\\Users\\sanja\\Codes\\ADV Java\\ADV Java\\SpringMVC2\\VaccineManagement"));
    }
}
