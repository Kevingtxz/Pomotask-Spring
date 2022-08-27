package com.pomotask.pomotask.service;


import com.pomotask.pomotask.app.dto.mapper.TimerMapper;
import com.pomotask.pomotask.app.repository.TimerRepository;
import com.pomotask.pomotask.app.service.TimerService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TimerServiceTest {

    private static final long INVALID_USER_ID = 1L;
    @Mock
    private TimerRepository repo;
    @InjectMocks
    private TimerService service;
    @Spy
    private TimerMapper mapper;


//    @Test
//    void whenExclusionIsCalledWithValidIdThenATimerShouldBeDeleted() throws ObjectNotFoundException {
//        TimerForm expectedDeletedTimerForm = TimerFormBuilder.builder().build().toForm();
//        TimerEntity expectedDeletedTimer = mapper.toModel(expectedDeletedTimerForm);
//
//        when(repo.findByUserEmailAndId(
//                "user@example.com",
//                expectedDeletedTimerForm.getId()))
//                .thenReturn(Optional.of(expectedDeletedTimer));
//        doNothing().when(repo).deleteById(expectedDeletedTimerForm.getId());
//
//        service.deleteByUserEmailAndId(
//                "user@example.com",
//                expectedDeletedTimerForm.getId());
//
//        verify(repo, times(1))
//                .findByUserEmailAndId(
//                        "user@example.com",
//                        expectedDeletedTimerForm.getId());
//        verify(repo, times(1)).deleteByUserEmailAndId(
//                "user@example.com",
//                expectedDeletedTimerForm.getId());
//    }

//    @Test
//    void whenIncrementIsCalledThenIncrementTimerStock() throws TimerNotFoundException, TimerStockExceededException {
//        //given
//        TimerForm expectedTimerForm = TimerFormBuilder.builder().build().toForm();
//        TimerEntity expectedTimer = mapper.toModel(expectedTimerForm);
//
//        //when
//        when(repo.findById(expectedTimerForm.getId())).thenReturn(Optional.of(expectedTimer));
//        when(repo.save(expectedTimer)).thenReturn(expectedTimer);
//
//        int quantityToIncrement = 10;
//        int expectedQuantityAfterIncrement = expectedTimerForm.getQuantity() + quantityToIncrement;
//
//        // then
//        TimerForm incrementedTimerForm = service.increment(expectedTimerForm.getId(), quantityToIncrement);
//
//        assertThat(expectedQuantityAfterIncrement, equalTo(incrementedTimerForm.getQuantity()));
//        assertThat(expectedQuantityAfterIncrement, lessThan(expectedTimerForm.getMax()));
//    }
//
//    @Test
//    void whenIncrementIsGreatherThanMaxThenThrowException() {
//        TimerForm expectedTimerForm = TimerFormBuilder.builder().build().toForm();
//        TimerEntity expectedTimer = mapper.toModel(expectedTimerForm);
//
//        when(repo.findById(expectedTimerForm.getId())).thenReturn(Optional.of(expectedTimer));
//
//        int quantityToIncrement = 80;
//        assertThrows(TimerStockExceededException.class, () -> service.increment(expectedTimerForm.getId(), quantityToIncrement));
//    }
//
//    @Test
//    void whenIncrementAfterSumIsGreatherThanMaxThenThrowException() {
//        TimerForm expectedTimerForm = TimerFormBuilder.builder().build().toForm();
//        TimerEntity expectedTimer = mapper.toModel(expectedTimerForm);
//
//        when(repo.findById(expectedTimerForm.getId())).thenReturn(Optional.of(expectedTimer));
//
//        int quantityToIncrement = 45;
//        assertThrows(TimerStockExceededException.class, () -> service.increment(expectedTimerForm.getId(), quantityToIncrement));
//    }
//
//    @Test
//    void whenIncrementIsCalledWithInvalidIdThenThrowException() {
//        int quantityToIncrement = 10;
//
//        when(repo.findById(INVALID_BEER_ID)).thenReturn(Optional.empty());
//
//        assertThrows(TimerNotFoundException.class, () -> service.increment(INVALID_BEER_ID, quantityToIncrement));
//    }
//
////    @Test
////    void whenDecrementIsCalledThenDecrementTimerStock() throws TimerNotFoundException, TimerStockExceededException {
////        TimerForm expectedTimerForm = TimerFormBuilder.builder().build().toForm();
////        TimerEntity expectedTimer = mapper.toModel(expectedTimerForm);
////
////        when(repo.findById(expectedTimerForm.getId())).thenReturn(Optional.of(expectedTimer));
////        when(repo.save(expectedTimer)).thenReturn(expectedTimer);
////
////        int quantityToDecrement = 5;
////        int expectedQuantityAfterDecrement = expectedTimerForm.getQuantity() - quantityToDecrement;
////        TimerForm incrementedTimerForm = service.decrement(expectedTimerForm.getId(), quantityToDecrement);
////
////        assertThat(expectedQuantityAfterDecrement, equalTo(incrementedTimerForm.getQuantity()));
////        assertThat(expectedQuantityAfterDecrement, greaterThan(0));
////    }
////
////    @Test
////    void whenDecrementIsCalledToEmptyStockThenEmptyTimerStock() throws TimerNotFoundException, TimerStockExceededException {
////        TimerForm expectedTimerForm = TimerFormBuilder.builder().build().toForm();
////        TimerEntity expectedTimer = mapper.toModel(expectedTimerForm);
////
////        when(repo.findById(expectedTimerForm.getId())).thenReturn(Optional.of(expectedTimer));
////        when(repo.save(expectedTimer)).thenReturn(expectedTimer);
////
////        int quantityToDecrement = 10;
////        int expectedQuantityAfterDecrement = expectedTimerForm.getQuantity() - quantityToDecrement;
////        TimerForm incrementedTimerForm = service.decrement(expectedTimerForm.getId(), quantityToDecrement);
////
////        assertThat(expectedQuantityAfterDecrement, equalTo(0));
////        assertThat(expectedQuantityAfterDecrement, equalTo(incrementedTimerForm.getQuantity()));
////    }
////
////    @Test
////    void whenDecrementIsLowerThanZeroThenThrowException() {
////        TimerForm expectedTimerForm = TimerFormBuilder.builder().build().toForm();
////        TimerEntity expectedTimer = mapper.toModel(expectedTimerForm);
////
////        when(repo.findById(expectedTimerForm.getId())).thenReturn(Optional.of(expectedTimer));
////
////        int quantityToDecrement = 80;
////        assertThrows(TimerStockExceededException.class, () -> service.decrement(expectedTimerForm.getId(), quantityToDecrement));
////    }
////
////    @Test
////    void whenDecrementIsCalledWithInvalidIdThenThrowException() {
////        int quantityToDecrement = 10;
////
////        when(repo.findById(INVALID_BEER_ID)).thenReturn(Optional.empty());
////
////        assertThrows(TimerNotFoundException.class, () -> service.decrement(INVALID_BEER_ID, quantityToDecrement));
////    }
}
