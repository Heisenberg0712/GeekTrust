package service.impl;

import entity.Person;
import entity.Relation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class FamilyImpl {
    private Person man;
    private Person woman;
    private Map<String,Person> tree = new HashMap<>();
    public FamilyImpl(Person woman,Person man){
        this.man=man;
        this.woman=woman;
        this.tree.put(this.man.getName(),man);
        this.tree.put(this.woman.getName(),woman);
    }
    /*The following method is used to insert child to the mother*/

    public String insertChild(String mom,String nameOfChild,String gender){
        if(this.tree.containsKey(mom)){
            Person person = this.tree.get(mom);

            Person offspring = new Person(nameOfChild,gender,person);

            if(person.offspringUpdate(offspring)){

                this.tree.put(offspring.getName(),offspring);
                return "CHILD_ADDITION_SUCCEEDED";
            }else{
                return "CHILD_ADDITION_FAILED";
            }
        }else{
            return "PERSON_NOT_FOUND";
        }
    }

    /*The following method is used to add partner. This method is used in collaboration with Family Initialization class*/
    public String addPartner(String nameOfPerson,Person person){
        if(this.tree.containsKey(nameOfPerson)){
            Person toBeAdded = this.tree.get(nameOfPerson);
            toBeAdded.setPartner(person);
            person.setPartner(toBeAdded);
            this.tree.put(person.getName(),person);
            return "SPOUSE_ADDED";
        }else{
            return "PERSON_NOT_FOUND";
        }
    }

    /*The following method is used to get the relationship between two person in the family tree*/
    public String relationGetter(String nameOfPerson, Relation relation){
        if(this.tree.containsKey(nameOfPerson)){
            Person person = this.tree.get(nameOfPerson);
            List<Person> personList = relation.findPerson(person);
            if(personList.size()==0){
                return "NONE";
            }else{
                for(Person element : personList){
                    System.out.print(element.getName()+" ");
                }
                return "";

            }
        }else{
            return "PERSON_NOT_FOUND";
        }
    }
}
