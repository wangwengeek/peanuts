package com.peanuts.community.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.peanuts.community.data.entity.RdbEntity;
import com.peanuts.community.data.repository.rdb.RdbSearchable;

/**
 * <pre>
 * Base of RDB repository
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/02
 */
@NoRepositoryBean
public interface RdbRepository<T extends RdbEntity, E extends Serializable>
        extends Repository<T, E>, JpaRepository<T, E>, RdbSearchable<T> {
}
