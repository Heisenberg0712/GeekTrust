package service.inter;

import service.impl.FamilyImpl;

import java.util.List;

public interface Execute {
    public void getCommand(List<String> stringList, FamilyImpl family);
}
