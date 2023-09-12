package com.example.dailyTracking.repository;

import com.example.dailyTracking.model.Expence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
/**
 * This interface class use for create,update,delete,search driver
 */
public interface ExpenceRepository extends JpaRepository<Expence ,Long> {
    /**
     * This method is used for retrieve data from mysql which are the current expence.
     * @param id
     * @return
     */
    Optional<Expence> findById(Integer id);
}
