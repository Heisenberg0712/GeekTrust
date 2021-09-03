import entity.Argument;
import entity.Setup;
import service.impl.FamilyImpl;
import service.impl.FamilyInit;

import javax.swing.text.html.Option;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeekTrustFamily {
    public static void main(String[] args) throws FileNotFoundException {
        FamilyImpl family = FamilyInit.familyInit();
        List<Argument> argumentList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            String line = reader.readLine();
            while (line!=null){
                line = mainExecution(argumentList, reader, line);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        for(Argument argument : argumentList){
            argument.executeCommand(family);
        }
    }

    private static String mainExecution(List<Argument> argumentList, BufferedReader reader, String line) throws IOException {
        List<String> inputLine = Arrays.asList(line.split(" "));
        extracted(argumentList, inputLine);
        line = reader.readLine();
        return line;
    }

    private static void extracted(List<Argument> argumentList, List<String> inputLine) {
        //System.out.println(inputLine.get(0));
        argumentList.add(new Argument(inputLine.subList(1, inputLine.size()), Setup.valueOf(inputLine.get(0))
        .getExecute()));
    }
}
