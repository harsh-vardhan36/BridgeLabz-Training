package com.generics.resumescreening;

class SoftwareEngineer extends JobRole {

    public SoftwareEngineer() {
        super("Software Engineer");
    }

    public boolean isEligible(int experience, int skillScore) {
        return experience >= 2 && skillScore >= 70;
    }
}

class DataScientist extends JobRole {

    public DataScientist() {
        super("Data Scientist");
    }

    public boolean isEligible(int experience, int skillScore) {
        return experience >= 3 && skillScore >= 75;
    }
}

class ProductManager extends JobRole {

    public ProductManager() {
        super("Product Manager");
    }

    public boolean isEligible(int experience, int skillScore) {
        return experience >= 4 && skillScore >= 65;
    }
}
