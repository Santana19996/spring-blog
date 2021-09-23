package com.codeup.springblog.repos;

import com.codeup.springblog.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface AdRepository extends JpaRepository<Ad,Long> {

    @Query("from Ad a where a.id = ?1")
    Ad getAdById(int id);

    Ad getByDescription(String description);

}
