package app;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FileContentFilteringUtilityDemonstrationWork {

    private static String pathInputFile;


    @BeforeAll
    public static void setUp()  {
        //в проекте есть  два файла с примерами из задания, выберете 1 или 2
        String numberFileOneORTwo = "2";
        pathInputFile = "src/testData/in"+ numberFileOneORTwo +".txt";
    }


    /**
     * Минимальный набор параметров
     */
    @Test
    public void testFileContentFilter_1() {
        // Эмулируем ввод данных
        String[] args = {pathInputFile};
        // Вызов main
        App.main(args);
    }

    /**
     * Добавлено указание пути до папки, где будут сохранены результаты
     */
    @Test
    public void testFileContentFilter_2() {
        // Эмулируем ввод данных
        String[] args = {"-s", "-o", "src/test/outData", pathInputFile};
        // Вызов main
        App.main(args);
    }


    /**
     * Добавлено указание пути до папки, где будут сохранены результаты и вывод стасистики (флаг -s по умолчанию).
     */
    @Test
    public void testFileContentFilter_3() {
        // Эмулируем ввод данных
        String[] args = {"-f", "-o", "src/test/outData", pathInputFile};
        // Вызов main
        App.main(args);
    }

    /**
     * Добавлен префекс к файлам
     */
    @Test
    public void testFileContentFilter_4() {
        // Эмулируем ввод данных
        String[] args = {"-p", "prefix_", pathInputFile};
        // Вызов main
        App.main(args);
    }

    /**
     * Добавлено указание пути до папки, где будут сохранены результаты и префекс файлов
     */
    @Test
    public void testFileContentFilter_5() {
        // Эмулируем ввод данных
        String[] args = {"-o", "src/test/outData", "-p", "prefix_", pathInputFile};
        // Вызов main
        App.main(args);
    }

    /**
     * Добавлено указание пути до папки, где будут сохранены результаты и режим '-a' добавления в существующие файлы значений
     */
    @Test
    public void testFileContentFilter_6() {
        // Эмулируем ввод данных
        String[] args = {"-o", "src/test/outData", "-a", pathInputFile};
        // Вызов main
        App.main(args);
    }

    /**
     * Полный набор опций
     */
    @Test
    public void testFileContentFilter_7() {
        // Эмулируем ввод данных
        String[] args = {"-o", "src/test/outData", "-p", "prefix_", "-a", pathInputFile};
        // Вызов main
        App.main(args);
    }




}

