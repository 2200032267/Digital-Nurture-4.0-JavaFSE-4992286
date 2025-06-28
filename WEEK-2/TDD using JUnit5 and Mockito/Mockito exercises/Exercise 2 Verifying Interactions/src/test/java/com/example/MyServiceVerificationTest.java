package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MyServiceVerificationTest {

    @Mock
    private ExternalApi mockApi;

    @InjectMocks
    private MyService service;

    @Test
    public void testSendDataWithCorrectArguments() {
        String input = "test data";
        service.processAndSendData(input);
        verify(mockApi).sendData("Processed: TEST DATA", 2);
    }

    @Test
    public void testSendDataForUrgentMessage() {
        String input = "urgent";
        service.processAndSendData(input);
        verify(mockApi).sendData("Processed: URGENT", 1);
    }

    @Test
    public void testVerificationWithNumberOfInvocations() {
        service.processAndSendData("data1");
        service.processAndSendData("data2");
        verify(mockApi, times(2)).sendData(anyString(), anyInt());

        ExternalApi otherMockApi = mock(ExternalApi.class);
        verify(otherMockApi, never()).sendData(anyString(), anyInt());
    }

    @Test
    public void testVerificationWithArgumentMatchers() {
        String input = "some important data";

        service.processAndSendData(input);

        // ✅ Use eq() for both arguments to avoid InvalidUseOfMatchersException
        verify(mockApi).sendData(eq("Processed: SOME IMPORTANT DATA"), eq(2));

        // ✅ You can also use contains() and matchers together
        verify(mockApi).sendData(contains("IMPORTANT"), eq(2));
    }

}
