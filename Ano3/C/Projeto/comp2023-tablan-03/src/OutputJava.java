import ATableJava.ATable;
import ATableJava.ATable.ColumnType;
import ATableJava.Table;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.Console;
import java.util.function.Function;

public class OutputJava {
   public static void main(String[] args)throws IOException {
      String[] headers = {"n1","n2","qualquer"};
      ColumnType[] columnTypes = {ColumnType.Double,ColumnType.Double,ColumnType.Double};
      Map<String, Function<Map<String, Object>, Object>> formulas = new HashMap<>();
      formulas.put("qualquer", row -> ((Double)row.get("n1")) + ((Double)row.get("n2")) / 2);
      Table t;
      t = new Table(headers, columnTypes);
      t.addRowFromConsole();
      t.addRowFromConsole();
      System.out.print("n1 and ");
      System.out.println(" n2: ");
      t.addRowFromConsole();
      System.out.println(t);
   }
}
