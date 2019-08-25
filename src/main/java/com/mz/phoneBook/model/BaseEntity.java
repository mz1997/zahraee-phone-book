package com.mz.phoneBook.model;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity <PK extends Serializable> {
}
