package com.example.gor.myhomies3;

import java.util.List;
import static org.mockito.Mockito.*;

/**
 * Created by Gor on 23.06.2017.
 */

public class MockitoTest {
    List mockedList = mock(List.class);

    // using mock object - it does not throw any "unexpected interaction" exception
    mockedList.add("one");
    mockedList.clear();

    // selective, explicit, highly readable verification
    verify(mockedList).add("one");
    verify(mockedList).clear();
}
