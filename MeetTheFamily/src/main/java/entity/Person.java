package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class Person {
    private String name;
    private String gender;
    private Person partner;
    private Person parent;
    private List<Person> offsprings;
    public Person(String nameOfPerson,String gender){
        this.name=nameOfPerson;
        this.gender=gender;
        offsprings=new ArrayList<>();
    }
    public Person(String nameOfChild,String gender,Person parent){
        this.name=nameOfChild;
        this.gender=gender;
        this.parent=parent;
        offsprings=new ArrayList<>();
    }
    public Person getFather(){
        if(this.parent!=null && this.parent.getGender().equals("Male")){
            return this.parent;
        }else if(this.parent!=null && this.parent.getGender().equals("Female")){
            return this.parent.getPartner();
        }else{
            return null;
        }
    }
    public Person getMother(){
        if(this.parent!=null && this.parent.getGender().equals("Female")){
            return this.parent;
        }else if(this.parent!=null && this.parent.getGender().equals("Male")){
            return this.parent.getPartner();
        }else{
            return null;
        }
    }
    public boolean offspringUpdate(Person person){
        if(this.gender.equals("Male")){
            return false;
        }else{
            this.offsprings.add(person);
            return true;
        }
    }
}
