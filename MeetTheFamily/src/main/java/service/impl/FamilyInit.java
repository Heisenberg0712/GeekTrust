package service.impl;

import entity.Person;


public class FamilyInit {
    public static FamilyImpl familyInit(){
        Person raja = new Person("King Shan","Male");
        Person rani = new Person("Queen Anga","Female");
        rani.setPartner(raja);
        FamilyImpl family = new FamilyImpl(rani,raja);
        /* The following function are setting up the family of Shan and Anga*/
        settingUpQueenAnga(raja, family);

        firstLayerFamily(family);

        settingUpJaya(family);

        settingUpAritAndSatvy(family);

        settingUpKrpi(family);
        return family;
    }

    private static void firstLayerFamily(FamilyImpl family) {
        Person lika = new Person("Lika","Female");
        family.addPartner("Vich",lika);

        Person amba = new Person("Amba","Female");
        family.addPartner("Chit",amba);

        Person chitra = new Person("Chitra","Female");
        family.addPartner("Aras",chitra);

        Person vyan = new Person("Vyan","Male");
        family.addPartner("Satya",vyan);

        family.insertChild("Amba","Dhrita","Female");
        family.insertChild("Amba","Tritha","Female");
        family.insertChild("Amba","Vritha","Male");
    }

    private static void settingUpQueenAnga(Person raja, FamilyImpl family) {
        family.addPartner("Queen Anga",raja);
        family.insertChild("Queen Anga","Ish","Male");
        family.insertChild("Queen Anga","Satya","Female");
        family.insertChild("Queen Anga","Aras","Male");
        family.insertChild("Queen Anga","Vich","Male");
        family.insertChild("Queen Anga","Chit","Male");
    }

    private static void settingUpJaya(FamilyImpl family) {
        Person jaya = new Person("Jaya","Male");
        family.addPartner("Dhrita",jaya);
        family.insertChild("Dhrita","Yodhan","Male");
        family.insertChild("Lika","Vila","Female");
        family.insertChild("Lika","Chika","Female");
        family.insertChild("Chitra","Ahit","Male");
        family.insertChild("Chitra","Jnki","Female");
    }

    private static void settingUpAritAndSatvy(FamilyImpl family) {
        Person arit = new Person("Arit","Male");
        family.addPartner("Jnki",arit);
        family.insertChild("Jnki","Lavnya","Female");
        family.insertChild("Jnki","Lake","Male");
        family.insertChild("Satya","Asva","Male");
        Person satvy = new Person("Satvy","Female");
        family.addPartner("Asva",satvy);
        family.insertChild("Satvy","Vasa","Male");
    }

    private static void settingUpKrpi(FamilyImpl family) {
        family.insertChild("Satya", "Vyas", "Male");
        Person krpy = new Person("Krpi", "Female");
        family.addPartner("Vyas", krpy);
        family.insertChild("Krpi", "Kriya", "Male");
        family.insertChild("Krpi", "Krithi", "Female");
        family.insertChild("Satya", "Atya", "Female");
    }
}
