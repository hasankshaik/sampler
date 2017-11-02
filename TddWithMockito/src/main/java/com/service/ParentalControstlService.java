package com.service;

import com.service.exception.TechnicalFailureException;
import com.service.exception.TitleNotFoundException;

import javax.inject.Inject;

public class ParentalControstlService {
    @Inject
    private MovieService movieService;

    public ResponceObj isMovieAvaiableToWatch(String someMovieId, Integer level) {

        try {
            Integer parentalControlLevel=movieService.getParentalControlLevel(someMovieId);
            if(parentalControlLevel>=level){
                return new ResponceObj(true,"Enjoy movie");
            }
        } catch (TitleNotFoundException e) {
            new ResponceObj(false,"Title Not Found");
        } catch (TechnicalFailureException e) {
            new ResponceObj(false,"Cannot Watch at the moment");
        }

        return new ResponceObj(false,"SystemError");
    }
}
