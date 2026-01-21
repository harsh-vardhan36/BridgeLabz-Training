package com.queue.hospitaltriage;

import java.util.PriorityQueue;

public class HospitalTriage {

    private PriorityQueue<Patient> pq;

    public HospitalTriage() {
    	
        pq = new PriorityQueue<>(
            (a, b) -> b.severity - a.severity
        );
    }

    public void addPatient(Patient p) {
        pq.add(p);
    }

    public void treatPatients() {
        while (!pq.isEmpty()) {
            Patient p = pq.remove();
            System.out.println(p.name + " (Severity: " + p.severity + ")");
        }
    }
}
