import java.io.*;
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
//        Считайте название книги (столбец title)
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
        byte[] bytes = null;
        double max = 0;
        double min = 1000000;
        String s = "";
        String s1 = "";
        String res = "";
        try (BufferedReader br = new BufferedReader(new FileReader("author.csv"))) {
            // чтение посимвольно
            br.readLine();

            while (br.ready()) {
                str = br.readLine();
                String[] line = str.split(",");
                int i = Integer.parseInt(line[0]);
                authors.put(i, line[1]);
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
                //    Считайте поле author_id
                //    Из Map authors найдите имя автора по этому author_id
                int y = Integer.parseInt(line[5]);
                System.out.println("Название книги, id, автор: " + line[1] + " " + line[5] + " " + authors.get(y));

                //Считайте название файла-обложки книги (поле image_path)
                System.out.println("Название файла-обложки книги: " + line[4]);

                // Дополнительное задание
                double x = Double.parseDouble(line[2]);
                if (max < x) {
                    max = x;
                    s1 = max + " " + line[1];
                }
                if (min > x) {
                    min = x;
                    s = min + " " + line[1];
                }
                res = "Самая дешевая книга - " + s + ". " + "Самая дорогая книга - " + s1;


                // Считайте картинку с этим названием (image_path),
                // которая лежит в папке images в массив byte[]
                //        Запишите этот массив байт в новую картинку.
                //        Картинка должна лежать в папке result/img.
                //        Картинка должна иметь название вида «Имя автора – название книги».
                //        Например для первой строки из файла books.csv картинка будет иметь
                //        название «Фрир О. – UK для начинающих».
                String str3 = line[4];
                String str4 = authors.get(y) + " - " + line[1] + ".jpg";

                try (FileInputStream inputStream = new FileInputStream(str3)) {
                    bytes = inputStream.readAllBytes();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

                try (FileOutputStream outputStream = new FileOutputStream("result/" + str4)) {
                    outputStream.write(bytes);

                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }


            }


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


        try (FileWriter writer = new FileWriter("result.txt", false)) {
            // запись всей строки
            writer.write(res);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }
}