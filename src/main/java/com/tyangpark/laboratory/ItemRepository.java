package com.tyangpark.laboratory;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository  extends CrudRepository<Item, Integer> {
}
