import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VocabularyIT {
//  Напишите программу создания небольшого словаря сленговых программерских выражений,
//  чтобы она потом по запросу возвращала значения из этого словаря.

//  Формат входных данных
//  Файл dict.txt
//  В первой строке задано одно целое число n — количество слов в словаре.
//  В следующих n строках записаны слова и их определения, разделенные ":" и символом пробела.
//  Ввод с клавиатуры
//  В первой строке записано целое число m — кол-во поисковых слов, чье определение нужно вывести.
//  В следующих m строках записаны сами слова, по одному на строке.

//  Формат выходных данных
//  Для каждого слова, независимо от регистра символов, если оно присутствует в словаре, необходимо
//  вывести на экран его определение.
//  Если слова в словаре нет, программа должна вывести "Не найдено", без кавычек.

//  Пример входных данных
//  5
//  Змея: язык программирования Python
//  Баг: от англ. bug — жучок, клоп, ошибка в программе
//  Конфа: конференция
//  Костыль: код, который нужен, чтобы исправить несовершенство ранее написанного кода
//  Бета: бета-версия, приложение на стадии публичного тестирования
//  3
//  Змея
//  Жаба
//  костыль

//  Пример выходных данных
//  язык программирования Python
//  Не найдено
//  код, который нужен, чтобы исправить несовершенство ранее написанного кода

  public static void main(String[] args) throws IOException {
    System.out.println("\n == *** Сленговый словарь для айтишника *** ==");
    Map<String, String> vocabulary = readingFile(new File("res/dict.txt"));
    List<String> wordsUser = inputUser();
    search(wordsUser, vocabulary);
  }

  private static Map<String, String> readingFile(File file) throws IOException {
    Map<String, String> hashMap = new HashMap<>();
    if (file.exists()) {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
      int numberLines = Integer.parseInt(bufferedReader.readLine());
      String sep = ":";
      for (int i = 0; i < numberLines; i++) {
        String line = bufferedReader.readLine();
        int sepIndex = line.indexOf(sep);
        String word = line.substring(0, sepIndex).toLowerCase();
        String value = line.substring(sepIndex + 2);
        hashMap.put(word, value);
      }
      bufferedReader.close();
    }
    return hashMap;
  }

  private static void search(List<String> list, Map<String, String> map) {
    System.out.println("==================================================================");
    System.out.println("\nРезультат поиска:");
    for (int i = 0; i < list.size(); i++) {
      System.out.println(map.getOrDefault(list.get(i), "Не найдено"));
    }
  }

  private static List<String> inputUser() throws IOException {
    List<String> list = new ArrayList<>();
    System.out.print("\nВведите кол-во слов для поиска: ");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int numberWords = Integer.parseInt(bufferedReader.readLine());
    System.out.println("Введите " + numberWords + " слов(а,ов) для поиска, каждое в своей строке:");
    for (int i = 0; i < numberWords; i++) {
      System.out.print((i + 1) + ". ");
      String word = bufferedReader.readLine();
      String wordToLowerCase = word.toLowerCase();
      list.add(wordToLowerCase);
    }
    return list;
  }
}
