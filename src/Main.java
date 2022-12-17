import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        В папке csv лежат два csv-файла: список книг и список авторов.
//        В папке images лежат обложки книг. В файле с книгами есть поле author_id и image_path.
//        Первое поле обозначает идентификатор автора, второе – название файла картинки(которая лежит в папке images).
//            Задание
//        Создайте Map<Integer, String> authors. Ключ – id автора, значение – его имя.
//        Прочитайте весь файл author.csv, записав каждую пару id-name в наш Map authors.
//        Прочитайте каждую строчку файла book.csv и для каждой строки сделайте следующее:
//    Считайте название книги (столбец title)
//        Считайте поле author_id
//        Из Map authors найдите имя автора по этому author_id
//        Считайте название файла-обложки книги (поле image_path)
//        Считайте картинку с этим названием (image_path), которая лежит в папке images в массив byte[]
//        Запишите этот массив байт в новую картинку. Картинка должна лежать в папке result/img.
//        Картинка должна иметь название вида «Имя автора – название книги».
//        Например для первой строки из файла books.csv картинка будет иметь название «Фрир О. – UK для начинающих».
//        Дополнительное задание
//        Найдите самую дорогую книгу.  (поле price отвечает за цену)
//        Найдите самую дешевую книгу.
//        Запишите в текстовый файл результаты. Файл должен лежать в папке result


        Map<Integer, String> authors = new HashMap<>();
        String str = "";

        try (BufferedReader br = new BufferedReader(new FileReader("author.csv"))) {
            // чтение посимвольно
            br.readLine();

            while (br.ready()) {
                str = br.readLine();
                //  System.out.println(str);
                String[] line = str.split(",");
                //System.out.println(line[0] + " "+ line[1]);
                int i = Integer.parseInt(line[0]);
                authors.put(i, line[1]);
                //System.out.println( authors.entrySet());
            }


        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }


        try (BufferedReader br = new BufferedReader(new FileReader("book.csv"))) {
            // чтение посимвольно
            br.readLine();

            while (br.ready()) {
                str = br.readLine();
                String[] line = str.split(",");
                //    Считайте название книги (столбец title)
                //        Считайте поле author_id
                //System.out.println(line[1] +" "+ line[5]+ " " );

//                Из Map authors найдите имя автора по этому author_id
                int y= Integer.parseInt(line[5]);
                System.out.println(line[1] +" "+ line[5]+ " " + authors.get(y));

                //Считайте название файла-обложки книги (поле image_path)
                System.out.println(line[4]);

            }


        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }


    }
}