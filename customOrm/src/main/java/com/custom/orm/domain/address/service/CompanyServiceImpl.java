package com.custom.orm.domain.address.service;

import com.custom.orm.database.generator.TableGenerator;
import com.custom.orm.domain.address.entity.Company;
import com.custom.orm.domain.address.repo.CompanyRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.custom.orm.domain.address.sql.CompanySqlManager.INSERT;

/**
 * @author Himal Rai on 5/21/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */
@Service
@Component
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;
    private final TableGenerator generator;

    public CompanyServiceImpl(CompanyRepository repository, TableGenerator generator) {
        this.repository = repository;
        this.generator = generator;
        generator.setTableName("company");
        generator.setMappedFinalColumns(Boolean.TRUE);
    }

    @Override
    public String save(Company o) throws Exception {
        repository.save(o.getObjects(),INSERT);
        return "success";
    }

    @Override
    public int createTable() throws Exception {
        Map<String, String> columns =
                new HashMap(){{
                    put("cName","varchar(200)");
                    put("cAddress","varchar(200)");
                    put("cCode","varchar(200)");
                    put("cMun","varchar(200)");
                    put("cState","varchar(200)");
                }};
        generator.setTableName("company");
        generator.setColumn(columns);
        return repository.createTable(generator);
    }

    @Override
    public List<Company> findAll() throws Exception {
        return null;
    }

    @Override
    public Company findById(int id) throws Exception {
        return repository.findById(id,Company::map).get(0);
    }

    @Override
    public String deleteById(int id) throws Exception {
        return null;
    }
}
