package com.example.dailyTracking.service;

import com.example.dailyTracking.exceptions.EntityNotFoundException;
import com.example.dailyTracking.model.Expence;
import com.example.dailyTracking.repository.ExpenceRepository;
import com.example.dailyTracking.util.Alerts;
import com.example.dailyTracking.util.ResponseMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class use for create,update,delete,search expence
 * In this class all the methods are overridden from "ExpenceService" class.
 */
@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
@Slf4j
public class ExpenceServiceImpl implements  ExpenceService{

    private ExpenceRepository expenceRepository;

    /**
     * used to save new expence
     * @param expence
     * @return
     */
    @Override
    public ResponseMessage create(Expence expence) {
        Expence save = expenceRepository.save(expence);
        if (expence !=null){
            return new ResponseMessage(200, Alerts.saveSuccess,expence);
        }
        return new ResponseMessage(201, Alerts.saveFailed, null);

    }

    /**
     * this method use for update expence
     * @param expence
     * @return
     */
    @Override
    public ResponseMessage update(Expence expence) {
        Expence exsitExpence= expenceRepository.findById(expence.getId().longValue()).
                orElseThrow(() -> new EntityNotFoundException(Long.valueOf(expence.getId())));

        Expence save = expenceRepository.save(expence);
        if (expence !=null){
            return new ResponseMessage(200, Alerts.updateSuccess,expence);
        }
        return new ResponseMessage(201, Alerts.updateFailed, null);
    }

    /**
     * used to delete expence
     * @param id
     * @return
     */
    @Override
    public ResponseMessage delete(Integer id) {
        Expence deleteExpence= expenceRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException(Long.valueOf(id)));

        Optional<Expence> delete = expenceRepository.findById(id);
        if (delete.isEmpty()){
            return new ResponseMessage(201, Alerts.nosuchfound,null);
        }
        return new ResponseMessage(200, Alerts.removeSuccess, null);
    }

    /**
     * used to get all expence
     * @return List<Expence>
     */
    @Override
    public ResponseMessage findAll() {
        List<Expence> all= expenceRepository.findAll();
        if (all.isEmpty()) {
            return new ResponseMessage(200, Alerts.ok, all);
        } else {
            return new ResponseMessage(201, Alerts.nosuchfound, null);
        }    }
}
