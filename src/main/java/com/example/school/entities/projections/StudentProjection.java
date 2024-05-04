package com.example.school.entities.projections;

import com.example.school.entities.Tutor;
import org.springframework.beans.factory.annotation.Value;

public interface StudentProjection {

    Long getId();

    String getFull_Name();
}
