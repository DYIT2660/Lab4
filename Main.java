import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      System.out.println("Unsorted Array ---------------------------------------------------");
      ArrayList<Integer> integerList = Lab4.getList();
      Lab4.outputList(integerList);

      System.out.println("\n\nBubble sort results ----------------------------------------------");
      long bubbleStartTime = System.nanoTime();
      ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(integerList);
      long bubbleEndTime = System.nanoTime();
      Lab4.outputList(bubbleSortedList);
      System.out.println("\nBubble sort time: " + (bubbleEndTime - bubbleStartTime) / 1000000.0 + " ms");

      System.out.println("\n\nInsertion sort results -------------------------------------------");
      long insertionStartTime = System.nanoTime();
      ArrayList<Integer> insertionSortedList = Lab4.insertionSort(integerList);
      long insertionEndTime = System.nanoTime();
      Lab4.outputList(insertionSortedList);
      System.out.println("\nInsertion sort time: " + (insertionEndTime - insertionStartTime) / 1000000.0 + " ms");
    }
}

class Lab4 {
  public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
    // Step 1 - Implement insertion sort algorithm here
    ArrayList<Integer> list = new ArrayList<>(integerList);
    for (int i = 1; i < list.size(); i++) {
      int iKey = list.get(i);
      int j = i - 1;
      while (j >= 0 && list.get(j) > iKey) {
        list.set(j + 1, list.get(j));
        j--;
      }
      list.set(j + 1, iKey);
    }
    return list;
  }

  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
    // Step 2 - Implement the bubble sort algorithm here
    ArrayList<Integer> list = new ArrayList<>(integerList);
    for (int i = 0; i < list.size() - 1; i++) {
      for (int j = 0; j < list.size() - 1 - i; j++) {
        if (list.get(j) > list.get(j + 1)) {
          int temp = list.get(j);
          list.set(j, list.get(j + 1));
          list.set(j + 1, temp);
        }
      }
    }
    return list;
  }

  public static ArrayList<Integer> getList() {
    ArrayList<Integer> integerList = new ArrayList<>();
    String line;
    try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
        while ((line = br.readLine()) != null) {
            integerList.add(Integer.parseInt(line));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return integerList;
  }

  public static void outputList(ArrayList<Integer> integerList) {
    for (int i = 0; i < integerList.size(); i++) {
        System.out.print(integerList.get(i) + " ");
    }
  }
}