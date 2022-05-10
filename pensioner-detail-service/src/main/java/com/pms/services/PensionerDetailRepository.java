package com.pms.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.beans.PensionerDetails;

@Repository
public interface PensionerDetailRepository extends JpaRepository<PensionerDetails, String> {

}
