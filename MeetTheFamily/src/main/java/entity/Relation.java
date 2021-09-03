package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public enum Relation {
    SIBLINGS("Siblings"){
        @Override
        public List<Person> findPerson(Person person){
            Person newPerson = person.getMother();
            if(newPerson==null){
                return new ArrayList<>();
            }else{
                List<Person> personList = new ArrayList<>();
                newPerson.getOffsprings().forEach((element)->{
                    if(!element.getName().equals(person.getName())){
                        personList.add(element);
                    }
                });
                return personList;
            }
        }
    },
    DAUGHTER("Daughter"){
        @Override
        public List<Person> findPerson(Person person){
            List<Person> personList = new ArrayList<>();
            person.getOffsprings().forEach((element)->{
                if(element.getGender().equals("Female")){
                    personList.add(element);
                }
            });
            return personList;
        }
    },
    SISTER_IN_LAW("Sister-In-Law"){
        @Override
        public List<Person> findPerson(Person person){
            List<Person> personList = new ArrayList<>();
            Person personPartner = person.getPartner();
            List<Person> inLaws;
            if(personPartner!=null){
                inLaws = Relation.SIBLINGS.findPerson(personPartner);
                inLaws.forEach((element)->{
                    if(element.getGender().equals("Female")){
                        personList.add(element);
                    }
                });
            }

            List<Person> familyList = new ArrayList<>();
            Relation.SIBLINGS.findPerson(person).
                    forEach((element)->{
                        if(element.getGender().equals("Male")){
                            familyList.add(element);
                        }
                    });

            familyList.forEach((element)->{
                personList.add(element.getPartner());
            });

            return personList;
        }
    },
    BROTHER_IN_LAW("Brother-In-Law"){
        @Override
        public List<Person> findPerson(Person person) {
            List<Person> personList = new ArrayList<>();
            Person personPartner = person.getPartner();
            List<Person> inLaws;
            if(personPartner!=null){
                inLaws = Relation.SIBLINGS.findPerson(personPartner);
                for(Person element : inLaws){
                    if(element.getGender().equals("Male")){
                        personList.add(element);
                    }
                }
            }
            List<Person> familyList = new ArrayList<>();
            for(Person element : Relation.SIBLINGS.findPerson(person)){
                if(element.getGender().equals("Female")){
                    familyList.add(element);
                }
            }
            for(Person element : familyList){
                personList.add(element.getPartner());
            }
            return personList;
        }
    },
    SON("Son"){
        @Override
        public List<Person> findPerson(Person person) {
            List<Person> personList = new ArrayList<>();
            for(Person element : person.getOffsprings()){
                if(element.getGender().equals("Male")){
                    personList.add(element);
                }
            }
            return personList;
        }
    },
    PATERNAL_UNCLE("Paternal-Uncle"){
        @Override
        public List<Person> findPerson(Person person) {
            List<Person> personList = new ArrayList<>();
            Person personFather = person.getFather();
            if(personFather==null){
                return null;
            }else{
                for(Person element : Relation.SIBLINGS.findPerson(personFather)){
                    if(element.getGender().equals("Male")){
                        personList.add(element);
                    }
                }
                return personList;
            }
        }
    },
    PATERNAL_AUNT("Paternal-Aunt"){
        @Override
        public List<Person> findPerson(Person person) {
            List<Person> personList = new ArrayList<>();
            Person personFather = person.getFather();
            if(personFather==null){
                return null;
            }else{
                Relation.SIBLINGS.findPerson(personFather).
                        forEach((element)->{
                            if(element.getGender().equals("Female")){
                                personList.add(element);
                            }
                        });
                return personList;
            }
        }
    },
    MATERNAL_UNCLE("Maternal-Uncle"){
        @Override
        public List<Person> findPerson(Person person) {
            List<Person> personList = new ArrayList<>();
            Person personMother = person.getMother();
            if(personMother==null){
                return null;
            }else{
                Relation.SIBLINGS.findPerson(personMother).
                        forEach((element)->{
                            if(element.getGender().equals("Male")){
                                personList.add(element);
                            }
                        });
                return personList;
            }
        }
    },
    MATERNAL_AUNT("Maternal-Aunt"){
        @Override
        public List<Person> findPerson(Person person) {
            List<Person> personList = new ArrayList<>();
            Person personMother = person.getMother();
            if(personMother==null){
                return null;
            }else{
                Relation.SIBLINGS.findPerson(personMother).
                        forEach((element)->{
                            if(element.getGender().equals("Female")){
                                personList.add(element);
                            }
                        });
                return personList;
            }
        }
    };
    public abstract List<Person> findPerson(Person person);
    private String relation;
    Relation(String relation){
        this.relation=relation;
    }
    public static Relation getRelation(String rel){
        for(Relation element : Relation.values()){
            if(element.relation.equalsIgnoreCase(rel)){
                return element;
            }
        }
        return null;
    }

}
