package service.interImpl;

import entity.Relation;
import service.impl.FamilyImpl;
import service.inter.Execute;

import java.util.List;

public class ForOthers implements Execute {
    @Override
    public void getCommand(List<String> stringList, FamilyImpl family) {
        String result = family.relationGetter(stringList.get(0), Relation.getRelation(stringList.get(1)));
        System.out.println(result);
    }
}
