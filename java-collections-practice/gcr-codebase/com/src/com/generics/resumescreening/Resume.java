package com.generics.resumescreening;

class Resume<T extends JobRole> {

    private String candidateName;
    private int experience;
    private int skillScore;
    private T jobRole;

    public Resume(String candidateName, int experience, int skillScore, T jobRole) {
        this.candidateName = candidateName;
        this.experience = experience;
        this.skillScore = skillScore;
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }

    public boolean screen() {
        return jobRole.isEligible(experience, skillScore);
    }

    public String getResult() {
        return candidateName + " → " + jobRole.getRoleName() +
               " → " + (screen() ? "SELECTED" : "REJECTED");
    }
}
