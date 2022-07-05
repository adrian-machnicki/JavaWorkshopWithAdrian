package com.workshop.employeesapp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.workshop.employeesapp.repository.EmployeesStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SimpleEmployeesServiceTest {

    SimpleEmployeesService service;

    @Mock
    EmployeesStorage storage;

    @BeforeEach
    void setup() {
        service = new SimpleEmployeesService(storage);
    }

    @Test
    void getShouldRethrowException() {
        // given
        var nonExistentId = 1;
        given(storage.get(1)).willThrow(RuntimeException.class);

        // when
        // then
        assertThrows(RuntimeException.class, () -> storage.get(nonExistentId));
    }

}