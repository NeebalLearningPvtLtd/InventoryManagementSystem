package com.kossine.ims.repository;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kossine.ims.models.LaptopUsedBy;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public interface LaptopUsedByRepo extends JpaRepository<LaptopUsedBy, Long> {

	@Query("select e from LaptopUsedBy e left join fetch e.laptop")
	List<LaptopUsedBy> findAllWithJoin(Pageable page);

	@Query("select e from LaptopUsedBy e left join fetch e.laptop where e.location like %:locationQuery% ")
	List<LaptopUsedBy> findAllByLocationQuery(@Param("locationQuery") String locationQuery, Pageable page);

}
