package com.peanuts.community.data.entity.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.peanuts.community.common.BrowseControlColumn;
import com.peanuts.community.common.vo.BrowseControlLevelEnum;
import com.peanuts.community.data.entity.CommonEntity;

import lombok.Data;

/**
 * <pre>
 * Category
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/05
 */
@Data
@Entity(name = Comment.ENTITY_NAME)
public class Comment implements CommonEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 4651965101132492079L;
    public static final String ENTITY_NAME = "comment";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @BrowseControlColumn(level=BrowseControlLevelEnum.VIEW)
    private String content;
    
    @Column(nullable = false)
    @JsonIgnore
    private Long userId;
    
    @Transient
    @BrowseControlColumn(level=BrowseControlLevelEnum.VIEW)
    private User user;
    
    @DateTimeFormat(iso = ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    @Override
    public String entityName() {
        return ENTITY_NAME;
    }
    
    /**
     * @see com.peanuts.community.data.entity.Entity#getId()
     */
    @SuppressWarnings("unchecked")
    @Override
    public Long getId() {
        return this.id;
    }
}
