package com.kossine.ims.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.kossine.ims.models.Pc;

public interface PcRepo extends GenericRepo<Pc>{

	public List<Pc> findAllWithJoin(Pageable pageable);

}
