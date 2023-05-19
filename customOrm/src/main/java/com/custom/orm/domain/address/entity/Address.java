package com.custom.orm.domain.address.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author Himal Rai on 5/19/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */
@Data
@Builder
public class Address {
    private int id;
    private String name;
}
