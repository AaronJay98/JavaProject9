import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        File srcFile = new File("src/ReadSrc.java");
        Scanner readLine = new Scanner(srcFile);
        HashMap<String, ArrayList<String>> identifierMap = new HashMap<>();
        Scanner in;
        String curLine;
        String curIdentifier;

        while (readLine.hasNextLine()) {
            curLine = readLine.nextLine();
            in = new Scanner(curLine);
            in.useDelimiter("[^A-Za-z0-9_]+");

            while (in.hasNext()) {
                curIdentifier = in.next();
                if (identifierMap.containsKey(curIdentifier)) {
                    identifierMap.get(curIdentifier).add(curLine);
                } else {
                    ArrayList<String> lines = new ArrayList<>();
                    lines.add(curLine);
                    identifierMap.put(curIdentifier, lines);
                }

            }
        }

        identifierMap.forEach((identifier, lines) -> print(identifier, lines));

    }

    private static void print(String identifier, ArrayList lines) {
        System.out.println(identifier + " occurs in: ");
        lines.forEach((line) -> System.out.println(line));
        System.out.println("");
    }

}
