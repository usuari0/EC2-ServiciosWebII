package com.idat.EC2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.EC2.models.Bodega;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Integer>{

}
