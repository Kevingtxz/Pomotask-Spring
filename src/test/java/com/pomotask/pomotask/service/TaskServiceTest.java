//package com.pomotask.pomotask.service;
//
//
//import com.pomotask.pomotask.builder.TaskFormBuilder;
//import com.pomotask.pomotask.domain.TaskEntity;
//import com.pomotask.pomotask.dto.form.TaskForm;
//import com.pomotask.pomotask.dto.mapper.TaskMapper;
//import com.pomotask.pomotask.repository.TaskRepository;
//import com.pomotask.pomotask.service.exception.ObjectNotFoundException;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Spy;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.is;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class TaskServiceTest {
//
//    private static final long INVALID_USER_ID = 1L;
//    @Mock
//    private TaskRepository repo;
//    @InjectMocks
//    private TaskService service;
//    @Spy
//    private TaskMapper mapper;
//
//
//    @Test
//    void whenTaskIsInsertedThenTaskShouldBeCreated() {
//
//        TaskForm expectedTaskForm = TaskFormBuilder.builder().build().toForm();
//        TaskEntity expectedSavedTask = mapper.toModel(expectedTaskForm);
//
//        when(repo.save(expectedSavedTask))
//                .thenReturn(expectedSavedTask);
//
//        TaskEntity task = service.insert("user@example.com", expectedTaskForm);
//        assertThat(task.getTitle(), is(equalTo(expectedSavedTask.getTitle())));
//
//    }
//
//    @Test
//    void whenExclusionIsCalledWithValidIdThenATaskShouldBeDeleted() throws ObjectNotFoundException {
//        TaskForm expectedDeletedTaskForm = TaskFormBuilder.builder().build().toForm();
//        TaskEntity expectedDeletedTask = mapper.toModel(expectedDeletedTaskForm);
//
//        when(repo.findByUserEmailAndId(
//                "user@example.com",
//                expectedDeletedTaskForm.getId()))
//                .thenReturn(Optional.of(expectedDeletedTask));
//        doNothing().when(repo).deleteById(expectedDeletedTaskForm.getId());
//
//        service.deleteByUserEmailAndId(
//                "user@example.com",
//                expectedDeletedTaskForm.getId());
//
//        verify(repo, times(1))
//                .findByUserEmailAndId(
//                        "user@example.com",
//                        expectedDeletedTaskForm.getId());
//        verify(repo, times(1)).deleteByUserEmailAndId(
//                "user@example.com",
//                expectedDeletedTaskForm.getId());
//    }
//
////    @Test
////    void whenIncrementIsCalledThenIncrementTaskStock() throws TaskNotFoundException, TaskStockExceededException {
////        //given
////        TaskForm expectedTaskForm = TaskFormBuilder.builder().build().toForm();
////        TaskEntity expectedTask = mapper.toModel(expectedTaskForm);
////
////        //when
////        when(repo.findById(expectedTaskForm.getId())).thenReturn(Optional.of(expectedTask));
////        when(repo.save(expectedTask)).thenReturn(expectedTask);
////
////        int quantityToIncrement = 10;
////        int expectedQuantityAfterIncrement = expectedTaskForm.getQuantity() + quantityToIncrement;
////
////        // then
////        TaskForm incrementedTaskForm = service.increment(expectedTaskForm.getId(), quantityToIncrement);
////
////        assertThat(expectedQuantityAfterIncrement, equalTo(incrementedTaskForm.getQuantity()));
////        assertThat(expectedQuantityAfterIncrement, lessThan(expectedTaskForm.getMax()));
////    }
////
////    @Test
////    void whenIncrementIsGreatherThanMaxThenThrowException() {
////        TaskForm expectedTaskForm = TaskFormBuilder.builder().build().toForm();
////        TaskEntity expectedTask = mapper.toModel(expectedTaskForm);
////
////        when(repo.findById(expectedTaskForm.getId())).thenReturn(Optional.of(expectedTask));
////
////        int quantityToIncrement = 80;
////        assertThrows(TaskStockExceededException.class, () -> service.increment(expectedTaskForm.getId(), quantityToIncrement));
////    }
////
////    @Test
////    void whenIncrementAfterSumIsGreatherThanMaxThenThrowException() {
////        TaskForm expectedTaskForm = TaskFormBuilder.builder().build().toForm();
////        TaskEntity expectedTask = mapper.toModel(expectedTaskForm);
////
////        when(repo.findById(expectedTaskForm.getId())).thenReturn(Optional.of(expectedTask));
////
////        int quantityToIncrement = 45;
////        assertThrows(TaskStockExceededException.class, () -> service.increment(expectedTaskForm.getId(), quantityToIncrement));
////    }
////
////    @Test
////    void whenIncrementIsCalledWithInvalidIdThenThrowException() {
////        int quantityToIncrement = 10;
////
////        when(repo.findById(INVALID_BEER_ID)).thenReturn(Optional.empty());
////
////        assertThrows(TaskNotFoundException.class, () -> service.increment(INVALID_BEER_ID, quantityToIncrement));
////    }
////
//////    @Test
//////    void whenDecrementIsCalledThenDecrementTaskStock() throws TaskNotFoundException, TaskStockExceededException {
//////        TaskForm expectedTaskForm = TaskFormBuilder.builder().build().toForm();
//////        TaskEntity expectedTask = mapper.toModel(expectedTaskForm);
//////
//////        when(repo.findById(expectedTaskForm.getId())).thenReturn(Optional.of(expectedTask));
//////        when(repo.save(expectedTask)).thenReturn(expectedTask);
//////
//////        int quantityToDecrement = 5;
//////        int expectedQuantityAfterDecrement = expectedTaskForm.getQuantity() - quantityToDecrement;
//////        TaskForm incrementedTaskForm = service.decrement(expectedTaskForm.getId(), quantityToDecrement);
//////
//////        assertThat(expectedQuantityAfterDecrement, equalTo(incrementedTaskForm.getQuantity()));
//////        assertThat(expectedQuantityAfterDecrement, greaterThan(0));
//////    }
//////
//////    @Test
//////    void whenDecrementIsCalledToEmptyStockThenEmptyTaskStock() throws TaskNotFoundException, TaskStockExceededException {
//////        TaskForm expectedTaskForm = TaskFormBuilder.builder().build().toForm();
//////        TaskEntity expectedTask = mapper.toModel(expectedTaskForm);
//////
//////        when(repo.findById(expectedTaskForm.getId())).thenReturn(Optional.of(expectedTask));
//////        when(repo.save(expectedTask)).thenReturn(expectedTask);
//////
//////        int quantityToDecrement = 10;
//////        int expectedQuantityAfterDecrement = expectedTaskForm.getQuantity() - quantityToDecrement;
//////        TaskForm incrementedTaskForm = service.decrement(expectedTaskForm.getId(), quantityToDecrement);
//////
//////        assertThat(expectedQuantityAfterDecrement, equalTo(0));
//////        assertThat(expectedQuantityAfterDecrement, equalTo(incrementedTaskForm.getQuantity()));
//////    }
//////
//////    @Test
//////    void whenDecrementIsLowerThanZeroThenThrowException() {
//////        TaskForm expectedTaskForm = TaskFormBuilder.builder().build().toForm();
//////        TaskEntity expectedTask = mapper.toModel(expectedTaskForm);
//////
//////        when(repo.findById(expectedTaskForm.getId())).thenReturn(Optional.of(expectedTask));
//////
//////        int quantityToDecrement = 80;
//////        assertThrows(TaskStockExceededException.class, () -> service.decrement(expectedTaskForm.getId(), quantityToDecrement));
//////    }
//////
//////    @Test
//////    void whenDecrementIsCalledWithInvalidIdThenThrowException() {
//////        int quantityToDecrement = 10;
//////
//////        when(repo.findById(INVALID_BEER_ID)).thenReturn(Optional.empty());
//////
//////        assertThrows(TaskNotFoundException.class, () -> service.decrement(INVALID_BEER_ID, quantityToDecrement));
//////    }
//}
