package com.apirest.leccese.apirest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest.leccese.apirest.Entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
