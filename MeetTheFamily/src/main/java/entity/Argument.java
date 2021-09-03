package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import service.impl.FamilyImpl;
import service.inter.Execute;

import java.util.List;

@Getter
@Setter
@Data
public class Argument {
    private List<String> stringList;
    private Execute execute;
    public void executeCommand(FamilyImpl family){
        Person person = new Person("Testing","Male");
        this.execute.getCommand(stringList,family);
        Person person2 = new Person("Testing","Male");
    }
    public Argument(List<String> stringList,Execute execute){
        this.stringList=stringList;
        this.execute=execute;
    }

}
