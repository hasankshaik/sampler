package com.service;

import com.service.exception.TechnicalFailureException;
import com.service.exception.TitleNotFoundException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ParentalControstlServiceTest {

    @Mock
    private MovieService movieService;
    @InjectMocks
    private ParentalControstlService parentalControstlService;


    //Scenario 1
    //when  the customer preference is equal to or leoss ParentalControlLevel
    //Given Movie Service responce is ParentalControlLevel "PG"
    //then indicate to   the caller that the customer can    watch the movie
    
    @Test
    public void testWhenParentalControlLevelIsLessOrEqualToCustomerPreferenceThenCustomerCanWatchTheMovie() throws TechnicalFailureException, TitleNotFoundException {
        given(movieService.getParentalControlLevel("SomeMovieId")).willReturn(15);
        ResponceObj movieAvaiableToWatch = parentalControstlService.isMovieAvaiableToWatch("SomeMovieId", 1);
        assertThat(movieAvaiableToWatch.getCanWatch(), is(true));


    }

    //Scenario 2
    //Given Movie Service responce is TitleNotFound exception
    // When the caller request with customer preference
    //Then     Indicate the error to the calling    client.

    @Test
    public void shouldIndicateErrorWhenMovieCouldNotbeFound() throws TechnicalFailureException, TitleNotFoundException {
        given(movieService.getParentalControlLevel("SomeMovieId")).willThrow(TitleNotFoundException.class);
        ResponceObj movieAvaiableToWatch = parentalControstlService.isMovieAvaiableToWatch("SomeMovieId", 1);
        assertThat(movieAvaiableToWatch.getCanWatch(), is(false));

    }

    //Scenario 3
    //Given Movie Service responce is Technical failure  exception
    // When the caller request with customer preference
    // then     Indicate that the customer cannot    watch this movie
    @Test
    public void shouldIndicateCannotWatchMovieOnError() throws TechnicalFailureException, TitleNotFoundException {
        given(movieService.getParentalControlLevel("SomeMovieId")).willThrow(TechnicalFailureException.class);
        ResponceObj movieAvaiableToWatch = parentalControstlService.isMovieAvaiableToWatch("SomeMovieId", 1);
        assertThat(movieAvaiableToWatch.getCanWatch(), is(false));

    }

}
