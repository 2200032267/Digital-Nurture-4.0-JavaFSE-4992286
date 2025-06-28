package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MyServiceWithAnnotationsTest {

    @Mock
    private ExternalApi mockApi;

    @InjectMocks
    private MyService service;

    @Test
    public void testFetchDataWithAnnotations() {
        when(mockApi.getData()).thenReturn("Annotated Mock Data");
        String result = service.fetchData();
        assertEquals("Service: Annotated Mock Data", result);
    }
}
