package com.kossine.ims.repository;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kossine.ims.models.AdapterUsedBy;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public interface AdapterUsedByRepo extends JpaRepository<AdapterUsedBy, Long> {
	@Query("select e from AdapterUsedBy e left join fetch e.adapter")
	List<AdapterUsedBy> findAllWithJoin(Pageable page);

	@Query("select e from AdapterUsedBy e left join fetch e.adapter where e.location like %:locationQuery% ")
	List<AdapterUsedBy> findAllByLocationQuery(@Param("locationQuery") String locationQuery, Pageable page);

}