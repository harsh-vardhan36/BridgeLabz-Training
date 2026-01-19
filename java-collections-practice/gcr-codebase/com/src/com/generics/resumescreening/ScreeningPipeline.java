package com.generics.resumescreening;

import java.util.*;

class ScreeningPipeline {

    public static <T extends Resume<?>> void processResume(T resume) {
        System.out.println(resume.getResult());
    }

    public static void processAllResumes(
            List<? extends Resume<? extends JobRole>> resumes) {

        for (Resume<? extends JobRole> r : resumes) {
            System.out.println(r.getResult());
        }
    }
}
