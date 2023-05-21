package com.custom.orm.domain.address.repo;

import com.custom.orm.database.jpa.SbJpaRepository;
import com.custom.orm.domain.address.entity.Company;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author Himal Rai on 5/21/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */
@Repository
@Component
public class CompanyRepository extends SbJpaRepository<Company> {
}
