package com.waltersoft.reactiveweb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("vehicles.categories")
public class Category implements Persistable<Integer> {

    @Id
    private Integer id;

    @Transient
    private boolean newCategory;

    @NotNull
    @NotBlank
    private String name;

    @Override
    @Transient
    public boolean isNew() {
        return this.newCategory || id == null;
    }

    public Category setAsNew(){
        this.newCategory = true;
        return this;
    }
}
