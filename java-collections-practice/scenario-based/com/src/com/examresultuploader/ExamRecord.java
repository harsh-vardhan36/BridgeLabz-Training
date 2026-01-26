package com.examresultuploader;

public class ExamRecord<T> {
    private String rollNo;
    private String name;
    private String subject;
    private int marks;
    private T examType;

    public ExamRecord(String rollNo, String name,
                      String subject, int marks, T examType) {
        this.rollNo = rollNo;
        this.name = name;
        this.subject = subject;
        this.marks = marks;
        this.examType = examType;
    }

    public String getSubject() { return subject; }
    public int getMarks() { return marks; }
    public String getName() { return name; }
}
