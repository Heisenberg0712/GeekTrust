package service.interImpl;

import service.impl.FamilyImpl;
import service.inter.Execute;

import java.util.List;

public class ForChild implements Execute {
    @Override
    public void getCommand(List<String> stringList, FamilyImpl family) {
        String result;
        if(stringList.get(2).equals("Male")){
            result = family.insertChild(stringList.get(0), stringList.get(1), "Male");
        }else{
            result = family.insertChild(stringList.get(0), stringList.get(1), "Female");
        }
        System.out.println(result);

    }
}
