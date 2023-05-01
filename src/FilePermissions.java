import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FilePermissions {
//  В файловую систему одного суперкомпьютера проник вирус, который сломал контроль за правами
//  доступа к файлам. Для каждого файла известно, с какими действиями можно к нему обращаться:
//  запись W,
//  чтение R,
//  запуск X.

//  Файл files.txt
//  В первой строке содержится число N — количество файлов, содержащихся в данной файловой системе.
//  В следующих N строчках содержатся имена файлов и допустимых с ними операций, разделенные
//  пробелами.

//  Файл operations.txt
//  Далее указано число M — количество запросов к файлам.
//  В последних M строках указан запрос вида Операция Файл.
//  К одному и тому же файлу может быть применено любое количество запросов.
//  Вам требуется восстановить контроль над правами доступа к файлам.

//  Файл results.txt
//  Ваша программа для каждого запроса должна будет выводить Файл: Операция: OK, если над файлом
//  выполняется допустимая операция, или же Файл: Операция: Access denied, если операция недопустима
//
//  Пример входных данных
//  4
//  helloworld.exe R X
//  pinglog W R
//  nya R
//  goodluck X W R
//  5
//  read nya
//  write helloworld.exe
//  execute nya
//  read pinglog
//  write pinglog

//  Пример выходных данных
//  nya: read: OK
//  helloworld.exe: write: Access denied
//  nya: execute: Access denied
//  pinglog: read: OK
//  pinglog: write: OK

  public static void main(String[] args) throws IOException {
    Map<String, String[]> files = new HashMap<>();
    BufferedReader bufferedReader = new BufferedReader(new FileReader("res/files.txt"));
    if (bufferedReader.ready()) {
      int numberFiles = Integer.parseInt(bufferedReader.readLine());
      for (int i = 0; i < numberFiles; i++) {
        String line = bufferedReader.readLine();
        int firstSpaceIndex = line.indexOf(" ");
        String nameFile = line.substring(0, firstSpaceIndex);
        String restLine = line.substring(firstSpaceIndex + 1);
        files.get(nameFile);
        String[] actions = restLine.split(" ");
        files.put(nameFile, actions);
      }
      bufferedReader.close();
    }
  }
}
