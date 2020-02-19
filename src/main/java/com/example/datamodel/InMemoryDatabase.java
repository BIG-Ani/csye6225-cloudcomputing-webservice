package com.example.datamodel;

import java.util.HashMap;

public class InMemoryDatabase {

    private static HashMap<Long, Professor> professorDB = new HashMap<> ();

    public static HashMap<Long, Professor> getProfessorDB() {
        professorDB.put((long) 1, new Professor("101", "zhou"));
        professorDB.put((long) 2, new Professor("102", "lei"));
        professorDB.put((long) 3, new Professor("103", "chen"));
        professorDB.put((long) 4, new Professor("104", "kelsey"));
        professorDB.put((long) 5, new Professor("105", "ma"));

        return professorDB;
    }
}
