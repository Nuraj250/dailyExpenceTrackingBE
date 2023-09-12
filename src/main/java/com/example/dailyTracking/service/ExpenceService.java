package com.example.dailyTracking.service;

import com.example.dailyTracking.model.Expence;
import com.example.dailyTracking.util.ResponseMessage;
/**
 * This class use for create,update,delete,search expence
 */
public interface ExpenceService {

    /**
     * used to store A nes expence to db
     * @param expence
     * @return
     */
    ResponseMessage create(Expence expence);

    /**
     * Used to update an existing object in the db
     * @param expence
     * @return
     */
    ResponseMessage update(Expence expence);

    /**
     * Used to delete an existing object in the db
     * @param id
     * @return
     */
    ResponseMessage delete(Integer id);

    /**
     * * Used to find an existing obj in the db by id
     * @return
     */
    ResponseMessage findAll();
}
