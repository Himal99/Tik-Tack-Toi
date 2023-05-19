package com.custom.orm.database.jpa;

import com.custom.orm.database.template.SbOrmTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author Himal Rai on 5/19/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */

@Component
@Repository
public abstract class SbJpaRepository<T> extends SbOrmTemplate<T>{
/** this is our custom JPA Repository **/
}
